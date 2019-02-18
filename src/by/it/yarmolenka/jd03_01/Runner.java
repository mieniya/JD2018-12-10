package by.it.yarmolenka.jd03_01;

public class Runner {
    public static void main(String[] args) {
        C_Reset reset = new C_Reset();
        C_Init init = new C_Init();
        B_ShowGamblers show = new B_ShowGamblers();
        reset.resetSQL();
        init.initializeSQL();
        show.showGamblers();
    }
}
