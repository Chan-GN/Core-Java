package _interface.media_player;

public interface MediaPlayer {
    static String formatDuration(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    void play();

    void pause();

    void stop();

    void seek(int position);

    int getCurrentPosition();

    int getDuration();

    String getMediaInfo();

    default String getPlaybackStatus() {
        if (getCurrentPosition() == 0) {
            return "Stopped";
        } else if (getCurrentPosition() < getDuration()) {
            return "Playing";
        } else {
            return "Paused";
        }
    }
}