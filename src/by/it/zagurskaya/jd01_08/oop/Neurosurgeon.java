package by.it.zagurskaya.jd01_08.oop;

public class Neurosurgeon extends Surgeon {

    private Sicker patient;

    public void doAsk(Sicker sicker) {
        super.doAsk(sicker);
        patient = sicker;
    }

    @Override
    protected String getSickerName() {
        return patient.getName();
    }

    public void doCure() {
        Prescript prescript = doCreatePrescript(patient.getSick());
        SickList sickList = doCreateSickList(patient.getSick());
        super.doCure(patient.getSick());
        patient.setPrescript(prescript);
        patient.setSickList(sickList);
        super.getNext();
    }

    @Override
    public void doSayProfession() {
        System.out.println("Я нейро-хирург с дипломом...");
    }

}
