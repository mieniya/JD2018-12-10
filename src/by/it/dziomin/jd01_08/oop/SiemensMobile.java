package by.it.dziomin.jd01_08.oop;

public abstract class SiemensMobile implements Mobile {

    private String productName = "Siemens";
    private String imei;

    SiemensMobile(String imei) {
        System.out.println("SiemensMobile: Construct " + productName + " mobile" + " imei = " + imei);
        this.imei = imei;
    }

    protected abstract void getModelName();

    @Override
    public void turnOn() {
        System.out.println("SiemensMobile: Turn ON");
        getLogo();
        getModelName();
    }

    @Override
    public void call(){
        getSim();
        System.out.println("SiemensMobile: Call");
    }

    @Override
    public void sendSms(){
        getSim();
        System.out.println("SiemensMobile: Send SMS");
    }

    @Override
    public void turnOff() {
        System.out.println("SiemensMobile: Turn OFF");
        getLogo();
        getModelName();
    }

    public void turnOff(String message) {
        System.out.println("SiemensMobile: Turn OFF with message " + message);
        getLogo();
        getModelName();
    }

    private void getLogo(){
        System.out.println("SiemensMobile: Get " + productName + " logo");
    }

    protected void getSim(){
        System.out.println("SiemensMobile: Get default sim");
    }
}
