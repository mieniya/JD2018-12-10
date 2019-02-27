package by.it.naron.jd03_01;

public class Runner {
    public static void main(String[] args) {

        C_Init init = new C_Init();
        C_Reset reset = new C_Reset();

//remove naron database
      //  reset.dropDB();

//create and insert naron database
        init.createDB();


    }
}
