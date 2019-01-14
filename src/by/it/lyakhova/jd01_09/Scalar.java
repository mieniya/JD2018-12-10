package by.it.lyakhova.jd01_09;

class Scalar extends Var {

    private double value;

    public double getValue() { return value; }

    Scalar (double value){
      this.value=value;
  }

   Scalar (Scalar otherScalar){
       this.value=otherScalar.value;
  }

   Scalar(String strValue){
       value = Double.parseDouble(strValue);
  }

    @Override
    public Var add(Var other) {
       if (other instanceof Scalar){
           double res = this.value+((Scalar) other).value;
           return new Scalar(res);
       }
       return other.add(this);
       //other Vector or Matrix
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double res = this.value-((Scalar) other).value;
            return new Scalar(res);
        }
        Scalar minus = new Scalar(-1);
        //other Vector or Matrix
        return other.add(this.mul((minus)));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double res = this.value*((Scalar) other).value;
            return new Scalar(res);
        }

        //other Vector or Matrix
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double res = this.value/((Scalar) other).value;
            return new Scalar(res);
        }
        return super.div(other);
    }

    public String toString() {
       return Double.toString(value);
        //return String.valueOf(value);
   }

}
