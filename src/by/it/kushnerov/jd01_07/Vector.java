package by.it.kushnerov.jd01_07;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector(Vector otherVector){
        this.value = otherVector.value;
    }

    Vector(String strVector){
        strVector = strVector.replaceAll("[{}]","").trim();
        String[] strMas = strVector.split(",");
        this.value = new double[strMas.length];
        for (int i = 0; i < strMas.length; i++) {
            this.value[i] = Double.parseDouble(strMas[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter=", ";
        }
        out.append('}');
        return out.toString();
    }
}
