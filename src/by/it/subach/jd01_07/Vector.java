package by.it.subach.jd01_07;

public class Vector extends Var{

    private double [] value;
    private Vector vector;
    private String strVector;

    public Vector (double [] value){
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }



    Vector (Vector vector1){
        this.vector = vector1.vector;
        value = vector1.value;
    }

    Vector(String strVector){
        this.strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String [] str = this.strVector.split(",");
        this.value = new double[str.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter = ", ";
        }

        out.append('}');
        return out.toString();
    }




}
