package by.it.zagurskaya.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANSE;
    private Locale locale;
    private final String RECOURS = "by.it.zagurskaya.jd02_05.messeges";
    private ResourceBundle resourceBundle;

    ResMan () {
        setLocale(Locale.getDefault());
    }


    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(RECOURS,locale);
    }
    public void setLocale(Locale locale, String country) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(RECOURS,locale);
    }
}
