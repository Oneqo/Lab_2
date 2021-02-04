import java.lang.Math;
import java.util.ArrayList;

public class Main {
    private final static double EPSILON = 0.00001;
    private static ArrayList<Double> roots = new ArrayList<>();
    /**
     * Pseudo code:
     * Newton-Raphson method formula:
     *xn+1 = xn - f(xn)/f'(xn)
     *let f(x) be the left side of the equation
     *let f'(x) be the derivative of f(x)
     */
    public static void main(String args[]) {
        for(int i = 0; i < 20; i++)
        {
            double x = Math.random() * 1.8;
            double deltaX = 0, nextX = 0;
            for (int j = 0; j < 2000; j++) {
                nextX = findNextX(x);
                deltaX = Math.abs(x - nextX);
                if (deltaX <= EPSILON) {
                    break;
                }

                x = nextX;
            }

            if(!containsRoot(nextX))
            {
                roots.add(nextX);
            }
        }

        System.out.println("The roots for the specified function are:");
        for(int i = 0; i < roots.size(); i++)
        {
            System.out.println(roots.get(i));
        }

    }


    static double findNextX(double x) {
        double nextX;
        double a = 9, b = 8, c = 1, d = 4, e = 2, f = 2, g = 1; //constants
        double fOfx = a * Math.pow(x, 6) - b * Math.pow(x, 5) + c * Math.pow(x, 4) - d * Math.pow(x, 3) + e * Math.pow(x, 2) - f * x + g; //full polynomial
        double fPrimeOfx = 6 * a * Math.pow(x, 5) - 5 * b * Math.pow(x, 4) + 4 * c * Math.pow(x, 3) - 3 * d * Math.pow(x, 2) + 2 * e * x - f; //derivative

        nextX = x - fOfx / fPrimeOfx;

        return nextX;
    }

    static boolean containsRoot(double foundRoot)
    {
        for(int i = 0; i < roots.size(); i++)
        {
            if(Math.abs(roots.get(i) - foundRoot) <= EPSILON)
            {
                return true;
            }
        }

        return false;
    }
}
