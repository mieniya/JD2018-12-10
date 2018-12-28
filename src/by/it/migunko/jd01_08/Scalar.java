package by.it.migunko.jd01_08;

class Scalar extends Var {
    private double value;
    Scalar (double value){
        this.value=value;
    }

    Scalar(Scalar otherScalar){

        this.value=otherScalar.value;
    }




    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
