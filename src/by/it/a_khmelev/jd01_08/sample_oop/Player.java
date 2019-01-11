package by.it.a_khmelev.jd01_08.sample_oop;

public abstract class Player implements Technik {

    private String track;

    boolean play;

    boolean pause;

    @Override
    public void on() {
        System.out.println("Player on");
        play = false;
        pause = false;
    }

    @Override
    public void off() {
        System.out.println("Player off");
    }

    void showStatus() {
        if (play && !pause)
            System.out.println("Плеер воспроизводит " + track);
        else if (!play)
            System.out.println("Плеер остановлен");
        else if (pause)
            System.out.println("Плеер на паузе "+track);
    }

    void start(String track) {
        this.track = track;
        pause = false;
        play = true;
        showStatus();
    }

    void start() {
        track = "";
        pause = false;
        play = true;
        showStatus();
    }

    abstract void stop();

    abstract void pause();

    public String getTrack() {
        return track;
    }
}
