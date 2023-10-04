package ladMS;

import java.util.Scanner;

public class Equation {
    private double a;
    private double b;
    private double c;
    private int sign;

    public Equation(double a, double b, double c, int sign) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.sign = sign;
    }

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public void inputValues(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = scanner.nextDouble();
        System.out.println("Enter b: ");
        b = scanner.nextDouble();
        System.out.println("Enter c: ");
        c = scanner.nextDouble();
    }

    public double getFunctionValue(Point point) {
        return point.x * a + point.y * b - c;
    }

    public Point getIntersection(Equation equation2) {
        Point result= new Point();
        double denominator = getDeterminant(a, b, equation2.getA(), equation2.getB());
        if (denominator == 0) {
            result.x = result.y = -999999;
            return result;
        }
        result.x = getDeterminant(c, b, equation2.getC(), equation2.getB()) / denominator;
        result.y = getDeterminant(a, c, equation2.getA(), equation2.getC()) / denominator;
        return result;
    }
    double getDeterminant(double a, double b, double c, double d) {
        return a * d - b * c;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", sign=" + sign +
                '}';
    }
}
