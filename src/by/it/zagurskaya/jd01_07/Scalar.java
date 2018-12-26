package by.it.zagurskaya.jd01_07;

class Scalar extends Var {

//    Scalar(double value1) {
//        value = value1;
//    }

   // static private double valueStatic; - поле принадлещит классу, т.е. ВСЕ объекты класса Scalar имеют ОБЩЕЕ значение поля
    //  private double valueStatic; - поле принадлещит объекту(конкретному) класса, т.е. КАЖДЫЙ объект класса Scalar имеют СОБСТВЕННОЕ значение поля

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        value = otherScalar.value;
    }

    Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        //return "какой-то скаляр";
        //return Double.toString(value);
        return String.valueOf(value);
    }
}
