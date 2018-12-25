package by.it.agadzhanov.jd01_07;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{]", " ");
        strVector = strVector.replaceAll("[}]", " ");
        strVector = strVector.replaceAll("[,]", " ");
        strVector = strVector.trim();
        String[] stringMas = strVector.split(" ");
        double[] doubleMas = new double[stringMas.length];
        for (int i = 0; i < doubleMas.length; i++) {
            doubleMas[i] = Double.parseDouble(stringMas[i]);
        }
        this.value = doubleMas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
