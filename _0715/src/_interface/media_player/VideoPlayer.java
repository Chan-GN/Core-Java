package _interface.media_player;

public class VideoPlayer implements MediaPlayer {
    private String videoTitle;
    private int currentPosition;
    private int duration;
    private String resolution;

    public VideoPlayer(String videoTitle, int duration, String resolution) {
        this.videoTitle = videoTitle;
        this.duration = duration;
        this.resolution = resolution;
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + videoTitle);
    }

    @Override
    public void pause() {
        System.out.println("Video paused");
    }

    @Override
    public void stop() {
        currentPosition = 0;
        System.out.println("Video stopped");
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
        return "Video: " + videoTitle + ", Duration: " + MediaPlayer.formatDuration(duration) + ", Resolution: " + resolution;
    }

    public String getResolution() {
        return resolution;
    }
}