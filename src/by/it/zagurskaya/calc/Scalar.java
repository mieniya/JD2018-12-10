package by.it.zagurskaya.calc;

class Scalar extends Var {

//    Scalar(double value1) {
//        value = value1;
//    }

    // static private double valueStatic; - поле принадлещит классу, т.е. ВСЕ объекты класса Scalar имеют ОБЩЕЕ значение поля
    //  private double valueStatic; - поле принадлещит объекту(конкретному) класса, т.е. КАЖДЫЙ объект класса Scalar имеют СОБСТВЕННОЕ значение поля

    private double value;

    public double getValue() {
        return value;
    }

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
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double res = this.value + ((Scalar) other).value;
            return new Scalar(res);
        } else if ((other instanceof Vector))
//        {
//            double[] res = Arrays.copyOf(((Scalar) other).getValue(),((Vector) other).getLenght());
//            for (int i = 0; i < res.length; i++) {
//                res[i] = this.value + res[i];
//            }
//            return new Vector(res);
//        }
        {
//            throw new CalcException("Действие не реализовано");//notRealized
            throw new CalcException(Localmessages.NOTREALIZED);//notRealized

        }
        else if ((other instanceof Matrix)) {
//            throw new CalcException("Действие не реализовано");//notRealized
            throw new CalcException(Localmessages.NOTREALIZED);//notRealized

        }
        return other.add(this);
        // other Vector or Matrix;
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double res = this.value - ((Scalar) other).value;
            return new Scalar(res);
        } else if ((other instanceof Vector)) {
//            throw new CalcException("Действие не реализовано");//notRealized
            throw new CalcException(Localmessages.NOTREALIZED);//notRealized

        } else if ((other instanceof Matrix)) {
            throw new CalcException(Localmessages.NOTREALIZED);//notRealized
        }
        Scalar minus = new Scalar(-1);
        return other.add(this.mul(minus));
        // other Vector or Matrix;
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0)
                throw new CalcException(Localmessages.ZERODIVIDE);//zeroDivide
            double res = this.value / ((Scalar) other).value;
            return new Scalar(res);
        } else if ((other instanceof Vector)) {
//            throw new CalcException("Действие не возможно");//actionNotImpossible
            throw new CalcException(Localmessages.ACTIONNOTIMPOSSIBLE);//actionNotImpossible

        } else if ((other instanceof Matrix)) {
            //            throw new CalcException("Действие не возможно");//actionNotImpossible
            throw new CalcException(Localmessages.ACTIONNOTIMPOSSIBLE);//actionNotImpossible
        }
        return super.div(other);
        // other Vector or Matrix;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double res = this.value * ((Scalar) other).value;
            return new Scalar(res);
        } else if ((other instanceof Vector)) {
//            throw new CalcException("Действие не реализовано");//notRealized
            throw new CalcException(Localmessages.NOTREALIZED);//notRealized

        } else if ((other instanceof Matrix)) {
//            throw new CalcException("Действие не реализовано");//notRealized
            throw new CalcException(Localmessages.NOTREALIZED);//notRealized

        }
        return other.mul(this);
        // other Vector or Matrix;
    }

    @Override
    public String toString() {
        //return "какой-то скаляр";
        //return Double.toString(value);
        return String.valueOf(value);
    }
}
