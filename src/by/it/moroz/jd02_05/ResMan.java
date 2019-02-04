package by.it.moroz.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {

    INSTANCE;

    private final String RESOURSE="by.it.moroz.jd02_05.messages";
    private Locale locale;
    private ResourceBundle resourceBundle;

    ResMan(){
        locale=Locale.getDefault();
        resourceBundle=ResourceBundle.getBundle(RESOURSE, locale);
    }

    public void setLocale(Locale locale){
        this.locale = locale;
    }

    public void setLocale(String language){
        setLocale(new Locale(language));
    }

    public void setLocale(String language, String country){
        setLocale(new Locale(language, country));
    }

    public String get(){
        return null;
    }
}
