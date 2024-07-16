package _interface.media_player;

public class AudioPlayer implements MediaPlayer {
    private String audioTitle;
    private int currentPosition;
    private int duration;
    private int bitrate;

    public AudioPlayer(String audioTitle, int duration, int bitrate) {
        this.audioTitle = audioTitle;
        this.duration = duration;
        this.bitrate = bitrate;
    }

    @Override
    public void play() {
        System.out.println("Playing audio: " + audioTitle);
    }

    @Override
    public void pause() {
        System.out.println("Audio paused");
    }

    @Override
    public void stop() {
        currentPosition = 0;
        System.out.println("Audio stopped");
    }

    @Override
    public void seek(int position) {
        if (position >= 0 && position <= duration) {
            currentPosition = position;
            System.out.println("Seeked to " + MediaPlayer.formatDuration(position));
        }
    }

    @Override
    public int getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getMediaInfo() {
        return "Audio: " + audioTitle + ", Duration: " + MediaPlayer.formatDuration(duration) + ", Bitrate: " + bitrate + "kbps";
    }

    public int getBitrate() {
        return bitrate;
    }
}