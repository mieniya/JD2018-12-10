package by.it.zagurskaya.jd01_08.oop;

interface Medic {
    void doCure(Sick sick);// лечить

    SickList doCreateSickList(Sick sick);  // создать больничный лист

    SickList doContinueSickList(SickList sickList); // продлевать БЛ

    void doCloseSickList(SickList sickList);   // закрыть больничный лист

    Prescript doCreatePrescript(Sick sick); // создать рецепт

    void doAsk(Sick sick);             // опрашивать

    void doSayProfession();   // представиться

    boolean isWorking();// активен(т.е. не на больничном/сесии и т.д.)

    void getNext();// вызвать следующего
}
