package util;

public enum Grade {

    F ("F", 0),
    D ("D", 1),
    C ("C", 2),
    B ("B", 3),
    A ("A", 4);

    public final String stringValue;
    public final double numericValue;

    Grade(String stringValue, double numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    public double getNumericValue() {
        return numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public String toString() {
        return "Grade " + getStringValue() + " corresponds to numeric grade " + getNumericValue();
    }
}
