package by.it.naron.jd01_08;

class Scalar extends Var {
    private double value;

     Scalar(double value) {
        this.value = value;
    }

    Scalar (String str){
         this.value = Double.parseDouble(str);
    }

    Scalar (Scalar scalar){
         this.value=scalar.value;
    }

    @Override
    public Var add(Var other) {
         if (other instanceof Scalar){
             double res = this.value+((Scalar) other).value;
         }


        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
         Scalar minus = new Scalar(-1);
        return super.add(this.mul(minus));
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
