package by.it.a_khmelev.jd01_08.sample_oop;

public class Runner {
    public static void main(String[] args) {
        Player p=new VideoPlayer();
        p.on();
        p.start();
        p.pause();
        p.pause();
        p.stop();
        p.start("Yooooooo");
        p.pause();
        p.stop();
        p.off();
    }
}
