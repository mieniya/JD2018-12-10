package by.it.zagurskaya.calc;

class Scalar extends Var {

//    Scalar(double value1) {
//        value = value1;
//    }

    // static private double valueStatic; - поле принадлещит классу, т.е. ВСЕ объекты класса Scalar имеют ОБЩЕЕ значение поля
    //  private double valueStatic; - поле принадлещит объекту(конкретному) класса, т.е. КАЖДЫЙ объект класса Scalar имеют СОБСТВЕННОЕ значение поля

    private double value;

    Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    public double getValue() {
        return value;
    }
    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double res = this.value + ((Scalar) other).value;
            return VarCreator.getInstance().create(Double.toString(res));//new Scalar(res);
        } else if ((other instanceof Vector))
        {
            throw new CalcException(LocalMessages.NOT_REALIZED_SUPPLIER.get());//notRealized

        }
        else if ((other instanceof Matrix)) {
            throw new CalcException(LocalMessages.NOT_REALIZED_SUPPLIER.get());//notRealized

        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double res = this.value - ((Scalar) other).value;
//            return new Scalar(res);
            return VarCreator.getInstance().create(Double.toString(res));
        } else if ((other instanceof Vector)) {
            String massage = LocalMessages.NOT_REALIZED_SUPPLIER.get();
            logger.log(massage);
            throw new CalcException(massage);//notRealized

        } else if ((other instanceof Matrix)) {
            String massage = LocalMessages.NOT_REALIZED_SUPPLIER.get();
            logger.log(massage);
            throw new CalcException(massage);//notRealized
        }
        Var minus = VarCreator.getInstance().create(Double.toString(-1));
        return other.add(this.mul(minus));
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0){
                String massage = LocalMessages.ZERO_DIVIDE_SUPPLIER.get();
                logger.log(massage);
                throw new CalcException(massage);//zeroDivide
                }
            double res = this.value / ((Scalar) other).value;
            return VarCreator.getInstance().create(Double.toString(res));//new Scalar(res);
        } else if ((other instanceof Vector)) {
            String massage = LocalMessages.ACTION_NOT_IMPOSSIBLE_SUPPLIER.get();
            logger.log(massage);
            throw new CalcException(massage);//actionNotImpossible

        } else if ((other instanceof Matrix)) {
            String massage = LocalMessages.ACTION_NOT_IMPOSSIBLE_SUPPLIER.get();
            logger.log(massage);
            throw new CalcException(massage);//actionNotImpossible
        }
        return super.div(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double res = this.value * ((Scalar) other).value;
            return VarCreator.getInstance().create(Double.toString(res));//new Scalar(res);
        } else if ((other instanceof Vector)) {
            String massage = LocalMessages.NOT_REALIZED_SUPPLIER.get();
            logger.log(massage);
            throw new CalcException(massage);//notRealized

        } else if ((other instanceof Matrix)) {
            String massage = LocalMessages.NOT_REALIZED_SUPPLIER.get();
            logger.log(massage);
            throw new CalcException(massage);//notRealized

        }
        return other.mul(this);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
