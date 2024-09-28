package net.austrianlinuxmemer.calculator.calculators;

import net.austrianlinuxmemer.calculator.AbstractCalculator;
import net.austrianlinuxmemer.calculator.Number;

public class VectorCalculator extends AbstractCalculator {
    @Override
    public Number add(Number a, Number b) {
        return new Number(a.getA() + b.getA(), a.getB() + b.getB());
    }

    @Override
    public Number subtract(Number a, Number b) {
        return new Number(a.getA() - b.getA(), a.getB() - b.getB());
    }

    @Override
    public Number multiply(Number a, Number b) {
        return null;
    }

    @Override
    public Number divide(Number a, Number b) {
        return null;
    }
}
