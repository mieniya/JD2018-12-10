package by.it.subach.jd01_07;

class Matrix extends Var {
    private double [][] value;
    private double matrix;
    private String strMatrix;

    Matrix(double [][] value){
        this.value = value;
    }




    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            out.append("{");
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if(i == value.length-1){
                out.append("}");
            }
            else {
                out.append("}, ");
                delimiter = "";
            }
        }
        out.append("}");
        return out.toString();
    }
}
