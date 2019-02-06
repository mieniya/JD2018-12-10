package by.it.zagurskaya.calc;

//public class Var extends Object{
//  public Var(){
//     super();// контруктор предка
//    }
//}

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    protected Logger logger = Logger.getLogger();

    @Override
    public Var add(Var other) throws CalcException {
        logger.log("");
        String massage = LocalMessages.ADDITION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
        logger.log(massage);
        throw new CalcException(massage);//addition on impossible
    }

    @Override
    public Var sub(Var other) throws CalcException {
        String massage = LocalMessages.SUBTRACTION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
        logger.log(massage);
        throw new CalcException(massage);//subtraction on impossible

    }

    @Override
    public Var div(Var other) throws CalcException {
        String massage = LocalMessages.DIVISION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
        logger.log(massage);
        throw new CalcException(massage);//division on impossible

    }

    @Override
    public Var mul(Var other) throws CalcException {
        String massage = LocalMessages.MULTIPLICATION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
        logger.log(massage);
        throw new CalcException(massage); //multiplication on impossible

    }

    @Override
    public String toString() {

        return LocalMessages.NOT_DEFINED_SUPPLIER.get();
    }//notDefined


}