package net.austrianlinuxmemer.calculator;

public abstract class AbstractCalculator {
    CalculationOperation add;
    CalculationOperation subtract;
    CalculationOperation multiply;
    CalculationOperation divide;
    public AbstractCalculator() {}
    public abstract Number add(Number a, Number b);
    public abstract Number subtract(Number a, Number b);
    public abstract Number multiply(Number a, Number b);
    public abstract Number divide(Number a, Number b);
}
