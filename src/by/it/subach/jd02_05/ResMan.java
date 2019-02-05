package by.it.subach.jd02_05;

import java.util.Locale;

public enum  ResMan {

    INSTANCE;

    private final String RESOURCE = "/home/owner/git/JD2018-12-10/src/by/it/subach/jd02_05/messages";
;    private Locale locale;

    ResMan(){
        locale = Locale.getDefault();
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
