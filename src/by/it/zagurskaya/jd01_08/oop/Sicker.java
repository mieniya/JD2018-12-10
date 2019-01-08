package by.it.zagurskaya.jd01_08.oop;

public class Sicker {

    private String name;

    private Sick sick;

    private SickList sickList;

    private Prescript prescript;

    public Sicker(String name, Sick sick) {
        this.name = name;
        this.sick = sick;
    }

    public String getName() {
        return name;
    }

    public Sick getSick() {
        return sick;
    }

    public SickList getSickList() {
        return sickList;
    }

    public void setSickList(SickList sickList) {
        this.sickList = sickList;
    }

    public void setPrescript(Prescript prescript) {
        this.prescript = prescript;
    }
}
