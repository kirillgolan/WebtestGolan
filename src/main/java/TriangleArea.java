import static java.lang.Math.*;

public class TriangleArea {


    public static Double Area (int a, int b, int c)  {

        a = abs(a);
        b = abs(b);
        c = abs(c);
        Integer p = (a+b+c)/2;
            System.out.println("Area: "+ sqrt(p * (p - a) * (p - b) * (p - c)));
            Double s = sqrt(p * (p - a) * (p - b) * (p - c));
            return s;
    }

}