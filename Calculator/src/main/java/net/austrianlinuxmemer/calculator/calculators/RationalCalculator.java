package net.austrianlinuxmemer.calculator.calculators;

import net.austrianlinuxmemer.calculator.AbstractCalculator;
import net.austrianlinuxmemer.calculator.Number;

public class RationalCalculator extends AbstractCalculator {
    @Override
    public Number add(Number a, Number b) {
        double[] upper = {a.getA(), b.getA()};
        double[] lower = {a.getB(), b.getB()};
        double lcm = lcm(lower[0], lower[1]);
        upper[0] *= lcm/lower[0];
        upper[1] *= lcm/lower[1];
        double sum = upper[0]+upper[1];
        double gcd = gcd(Math.abs(sum), lcm);
        sum /= gcd;
        lcm /= gcd;
        return new Number(sum, lcm);
    }

    @Override
    public Number subtract(Number a, Number b) {
        double[] upper = {a.getA(), b.getA()};
        double[] lower = {a.getB(), b.getB()};
        double lcm = lcm(lower[0], lower[1]);
        upper[0] *= lcm/lower[0];
        upper[1] *= lcm/lower[1];
        double sum = upper[0]-upper[1];
        double gcd = gcd(Math.abs(sum), lcm);
        sum /= gcd;
        lcm /= gcd;
        return new Number(sum, lcm);
    }

    @Override
    public Number multiply(Number a, Number b) {
        double[] upper = {a.getA(), b.getA()};
        double[] lower = {a.getB(), b.getB()};
        return new Number(upper[0]*upper[1], lower[0]*lower[1]);
    }

    @Override
    public Number divide(Number a, Number b) {
        double[] upper = {a.getA(), b.getA()};
        double[] lower = {a.getB(), b.getB()};
        return new Number(upper[0]*lower[1], upper[0]*lower[1]);
    }
    private double gcd(double a, double b) {
        while (b != 0) {
            double temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private double lcm(double a, double b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a*b)/gcd(a, b);
    }
}
