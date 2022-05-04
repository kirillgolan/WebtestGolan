import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleArea.class);

    @BeforeAll
    static void beforeAll() {
        logger.error("ERROR");
    }


    @Test
    @DisplayName("Треугольник существует")
    void test1() {
        assertFalse(TriangleArea.Area(2,2,2)==0);
        assertFalse(TriangleArea.Area(6,7,9)==0);
        assertFalse(TriangleArea.Area(7,10,12)==0);
    }

    @Test
    @DisplayName("Треугольник не существует")
    void test2() {
        assertFalse(TriangleArea.Area(2,2,200)==0);
        assertFalse(TriangleArea.Area(3,4,8)==0);
        assertFalse(TriangleArea.Area(1,3,1)==0);
    }

    @ParameterizedTest
    @CsvSource({"2,2,2,1.7320508075688772","6,-7,9,20.97617696340303","7,10,12,28.0","7,6,7,18.973665961010276"})
    @DisplayName("Существующие треугольники")
    void test2(int a, int b, int c, double d) {
        assertEquals(TriangleArea.Area(a,b,c),d);
    }

}
