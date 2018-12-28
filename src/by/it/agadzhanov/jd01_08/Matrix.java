package by.it.agadzhanov.jd01_08;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{]", " ");
        strMatrix = strMatrix.replaceAll("[}]", " ");
        strMatrix = strMatrix.trim();
        String[] strMatrixRows = strMatrix.split(" , ");

        //finding number of columns
        String[] exampleRow = strMatrixRows[0].split(",");
        int columnNumber = exampleRow.length;

        //filling the matrix with elements of double type
        double[][] matrixElements = new double[strMatrixRows.length][columnNumber];
        for (int i = 0; i < strMatrixRows.length; i++) {
            String[] rowMas = strMatrixRows[i].split(",");
            for (int j = 0; j < columnNumber; j++) {
                double[] doubleMas = new double[columnNumber];
                doubleMas[j] = Double.parseDouble(rowMas[j]);
                matrixElements[i][j] = doubleMas[j];
            }
        }
        this.value = matrixElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ { ");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == 0)
                    delimiter = "";
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i <= value.length - 2) {
                sb.append(" }, { ");
            }
        }
        sb.append(" } }");
        return sb.toString();
    }
}