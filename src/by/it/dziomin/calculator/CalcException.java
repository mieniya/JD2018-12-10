package by.it.dziomin.calculator;

import by.it.dziomin.calculator.logs.Logger;

public class CalcException extends Exception {

    private String msg;
    private String shortMsg;

    public CalcException(String message) {
        Logger logger = Logger.getInstance();
        logger.printToFile(Localizer.getBundle().getString(Localization.ERROR) + " " + message);
        this.msg = Localizer.getBundle().getString(Localization.ERROR) + message;
        this.shortMsg = Localizer.getBundle().getString(Localization.ERROR);
    }

    String getMsg() {
        return msg;
    }
    String getShortMsg() {
        return shortMsg;
    }

}
