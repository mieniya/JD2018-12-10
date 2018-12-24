package by.it.migunko.jd01_07;

class Scalar extends Var{
    private double value;
    public Scalar (double value){
        this.value=value;
    }
    public Scalar(Scalar otherScalar){
        this.value=otherScalar.value;
    }
    public Scalar(String strValue){
        value=Double.parseDouble(strValue);
    }

}
