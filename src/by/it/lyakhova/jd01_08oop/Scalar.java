package by.it.lyakhova.jd01_08oop;

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

    public String toString() {
        return Double.toString(value);
        //return String.valueOf(value);
    }

//--------------------------------------------------------------------------------
    //Sum
    @Override
    public Var addCross(Scalar scalar) { return scalar.add(this); }
    @Override
    public Var addCross(Vector vector) { return vector.add(this); }
    @Override
    public Var addCross(Matrix matrix) { return matrix.add(this); }

    @Override
    public Var add(Var other){ return other.addCross(this); }

    //Scalar + Scalar
    public Var add(Scalar other) {
        double res = this.value + other.value;
        return new Scalar(res);
    }

//-----------------------------------------------------------------------------
    //Minus
    @Override
    public Var subCross(Scalar scalar) { return scalar.sub(this); }
    @Override
    public Var subCross(Vector vector) { return vector.sub(this); }
    @Override
    public Var subCross(Matrix matrix) { return matrix.sub(this); }


    @Override
    public Var sub(Var other) { return other.subCross(this); }

    //Scalar - Scalar
    public Var sub (Scalar other){
        double res = this.value- other.value;
        return new Scalar(res);
    }

//-------------------------------------------------------------------------------
    //Multiplication
    @Override
    public Var mulCross(Scalar scalar) { return scalar.mul(this); }
    @Override
    public Var mulCross(Vector vector) { return vector.mul(this); }
    @Override
    public Var mulCross(Matrix matrix) { return matrix.mul(this); }

    @Override
    public Var mul(Var other) {
        return other.mulCross(this);
    }

    //Scalar * Scalar
    public Var mul (Scalar other){
        double res = this.value*((Scalar) other).value;
        return new Scalar(res);
    }

//------------------------------------------------------------------------------------
    //Division
    @Override
    public Var divCross(Scalar scalar) { return scalar.div(this); }
    @Override
    public Var divCross(Vector vector) { return vector.div(this); }
    @Override
    public Var divCross(Matrix matrix) { return matrix.div(this); }

    @Override
    public Var div(Var other) { return other.divCross(this); }

    //Scalar / Scalar
    public Var div (Scalar other){
        double res = this.value / other.value;
        return new Scalar(res);
    }


}
