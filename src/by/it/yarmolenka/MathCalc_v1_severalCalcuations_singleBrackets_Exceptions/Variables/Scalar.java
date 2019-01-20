package by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Variables;

public class Scalar extends Var {

    public double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String s) {
        this.value = Double.parseDouble(s);
    }

    @Override
    public String toString(){
        return Double.toString(this.value);
    }
}
