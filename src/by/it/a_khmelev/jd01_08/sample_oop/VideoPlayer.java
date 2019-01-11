package by.it.a_khmelev.jd01_08.sample_oop;

class VideoPlayer extends Player {

    @Override
    void stop() {
        pause = false;
        play = false;
        showStatus();
    }

    @Override
    void pause() {
        pause = !pause;
        showStatus();

    }
}
