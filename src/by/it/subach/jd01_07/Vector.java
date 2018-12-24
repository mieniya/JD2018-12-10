package by.it.subach.jd01_07;

public class Vector extends Var{

    private double [] value;

    public Vector (double [] value){
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
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
