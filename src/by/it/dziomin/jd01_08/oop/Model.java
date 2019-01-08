package by.it.dziomin.jd01_08.oop;

public class Model extends SiemensMobile {

    private boolean dualSim;
    private String modelName = "C1517";

    Model(boolean dualSim, String imei) {
        super(imei);
        System.out.println("Model: Construct " + modelName + " mobile dualSim = " + dualSim);
        this.dualSim = dualSim;
    }

    @Override
    public void getModelName() {
        System.out.println("Model: Get model name " + modelName);
    }

    @Override
    public void getSim() {
        if (dualSim) {
            System.out.println("Model: Get main sim");
        } else {
            super.getSim();
        }
    }


}
