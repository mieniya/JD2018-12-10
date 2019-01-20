package by.it.dziomin.сalculator;

public class CalcException extends Exception {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public CalcException(String message) {
        this.msg = "ERROR:" + message;
    }

}
