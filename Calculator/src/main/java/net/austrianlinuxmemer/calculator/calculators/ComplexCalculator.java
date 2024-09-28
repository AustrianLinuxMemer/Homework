package net.austrianlinuxmemer.calculator.calculators;

import net.austrianlinuxmemer.calculator.AbstractCalculator;
import net.austrianlinuxmemer.calculator.Number;

public class ComplexCalculator extends AbstractCalculator {
    @Override
    public Number add(Number a, Number b) {
        double real = a.getA() + b.getA();
        double imaginary = a.getB() + b.getB();
        return new Number(real, imaginary);
    }

    @Override
    public Number subtract(Number a, Number b) {
        double real = a.getA() - b.getA();
        double imaginary = a.getB() - b.getB();
        return new Number(real, imaginary);
    }

    @Override
    public Number multiply(Number a, Number b) {
        double real = a.getA()*b.getA()+a.getB()*b.getB();
        double imaginary = a.getA()*b.getB()+a.getB()*b.getA();
        return new Number(real, imaginary);
    }

    @Override
    public Number divide(Number a, Number b) {
        double real = (a.getA()*b.getA() + b.getA()*b.getB()) / (b.getA()*b.getA() + b.getB()*b.getB());
        double imaginary = (a.getB()*b.getA() - a.getA()*b.getB()) / (b.getA()*b.getA() + b.getB() * b.getB());
        return new Number(real, imaginary);
    }
}
