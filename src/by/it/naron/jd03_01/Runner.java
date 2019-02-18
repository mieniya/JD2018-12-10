package by.it.naron.jd03_01;

public class Runner {
    public static void main(String[] args) {

        C_Init init = new C_Init();
        C_Reset reset = new C_Reset();

        reset.dropDB();
        init.createDB();


    }
}
