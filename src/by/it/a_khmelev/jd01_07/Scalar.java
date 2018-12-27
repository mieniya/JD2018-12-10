package by.it.a_khmelev.jd01_07;

class Scalar extends Var{

    private double value;


    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;
    }

    Scalar(String strValue) {
        value=Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
