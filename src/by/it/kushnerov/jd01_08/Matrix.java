package by.it.kushnerov.jd01_08;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value){
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
               System.arraycopy(value[i],0,this.value[i],0,value[i].length);
        }
    }

    Matrix(Matrix otherMatrix){
        this.value = otherMatrix.value;
    }

    Matrix(String strMatrix){
        String[] strMas1 = strMatrix.split("},");
        for (int i = 0; i < strMas1.length; i++) {
            strMas1[i] = strMas1[i].replaceAll("[{}]","").trim();
        }
        this.value = new double[strMas1.length][];
        String[] strMas2;
        for (int i = 0; i < value.length; i++) {
            strMas2 = strMas1[i].split(",");
            value[i] = new double[strMas2.length];
            for (int j = 0; j < value[i].length; j++) {
                this.value[i][j] = Double.parseDouble(strMas2[j]);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            delimiter ="}, {";
        }
        out.append("}}");
        return out.toString();
    }
}
