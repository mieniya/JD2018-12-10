package by.it.zagurskaya.jd01_08.oop;

import java.time.LocalDate;
import java.util.Date;

abstract class Surgeon implements Medic {

    protected boolean isAtWork = false;

    protected int sickListNumber = 1;

    @Override
    public SickList doCreateSickList(Sick sick) {
//        System.out.println(String.format("Выдан больничный лист #%s с %s по %s", sickListNumber++, LocalDate.now(), LocalDate.now().plusDays(3L)));
        int sickListNumber = this.sickListNumber++;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(sick.getSickListDay());

        SickList sickList = new SickList();
        sickList.setOpen(true);
        sickList.setNumber(sickListNumber);
        sickList.setStartDate(startDate);
        sickList.setEndDate(endDate);
        sickList.setSickName(sick.getSickName());
        sickList.setSickerName(getSickerName());

        System.out.println("Выдан больничный лист #" + sickListNumber + " с " + startDate + " по " + endDate);
        return sickList;
    }

    protected abstract String getSickerName();

    @Override
    public SickList doContinueSickList(SickList sickList) {
        sickList.getEndDate().plusDays(2);
        System.out.println("Продлён больничный лист #" + sickList.getNumber() + " до " + sickList.getEndDate());
        return sickList;
    }

    @Override
    public void doCloseSickList(SickList sickList) {
        sickList.setOpen(false);
        System.out.println("Закрыт больничный лист #" + sickList.getNumber());
    }

    @Override
    public Prescript doCreatePrescript(Sick sick) {
        Prescript prescript = new Prescript();
        prescript.setPillsName(sick.getSickKiller());
        System.out.println("Создан рецепт на " + prescript.getPillsName() + " пилюли");
        return prescript;
    }

    public void doAsk(Sicker sicker) {
        doAsk(sicker.getSick());
    }

    @Override
    public void doAsk(Sick sick) {
        isAtWork = true;
        System.out.println("- На что жалуемся???");
        System.out.println("- " + sick.getSymptoms());
        System.out.println("- Понятно");
    }

    @Override
    public boolean isWorking() {
        if (isAtWork) {
            System.out.println("Вы что не видите я работаю...!!!");
        } else {
            System.out.println("Проходим...");
        }
        return isAtWork;
    }

    @Override
    public void getNext() {
        isAtWork = false;
        System.out.println("Следующий...");
    }

    @Override
    public void doCure(Sick sick) {
        System.out.println("Время лечит " + sick.getSickName() + "...!!");
    }
}
