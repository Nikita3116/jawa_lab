public class SimpleFraction {
    private Number numerator;   // Числитель
    private Number denominator; // Знаменатель

    public SimpleFraction(Number numerator, Number denominator) {
        if (denominator.getValue() == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void display() {
        System.out.println(numerator + "/" + denominator);
    }

    public SimpleFraction add(SimpleFraction other) {
        Number newNumerator = new Number(this.numerator.getValue() * other.denominator.getValue() +
                other.numerator.getValue() * this.denominator.getValue());
        Number newDenominator = new Number(this.denominator.getValue() * other.denominator.getValue());
        return new SimpleFraction(newNumerator, newDenominator);
    }

    public SimpleFraction subtract(SimpleFraction other) {
        Number newNumerator = new Number(this.numerator.getValue() * other.denominator.getValue() -
                other.numerator.getValue() * this.denominator.getValue());
        Number newDenominator = new Number(this.denominator.getValue() * other.denominator.getValue());
        return new SimpleFraction(newNumerator, newDenominator);
    }

    // Умножение дробей
    public SimpleFraction multiply(SimpleFraction other) {
        Number newNumerator = new Number(this.numerator.getValue() * other.numerator.getValue());
        Number newDenominator = new Number(this.denominator.getValue() * other.denominator.getValue());
        return new SimpleFraction(newNumerator, newDenominator);
    }

    // Деление дробей
    public SimpleFraction divide(SimpleFraction other) {
        if (other.numerator.getValue() == 0) {
            throw new ArithmeticException("Cannot divide by fraction with numerator 0");
        }
        Number newNumerator = new Number(this.numerator.getValue() * other.denominator.getValue());
        Number newDenominator = new Number(this.denominator.getValue() * other.numerator.getValue());
        return new SimpleFraction(newNumerator, newDenominator);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SimpleFraction that = (SimpleFraction) obj;
        return numerator.equals(that.numerator) && denominator.equals(that.denominator);
    }

    @Override
    public int hashCode() {
        return 31 * numerator.hashCode() + denominator.hashCode();
    }

    @Override
    public String toString() {
        return "Простая дробь{" +
                "числитель=" + numerator +
                ", знаменатель=" + denominator +
                '}';
    }

}