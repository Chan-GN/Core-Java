package _interface.media_player;

public class LiveStreamPlayer implements MediaPlayer {
    private String streamTitle;
    private int currentPosition;
    private int viewerCount;

    public LiveStreamPlayer(String streamTitle) {
        this.streamTitle = streamTitle;
        this.viewerCount = 0;
    }

    @Override
    public void play() {
        System.out.println("Starting live stream: " + streamTitle);
    }

    @Override
    public void pause() {
        System.out.println("Live stream paused (buffering)");
    }

    @Override
    public void stop() {
        System.out.println("Live stream ended");
    }

    @Override
    public void seek(int position) {
        System.out.println("Seeking is not supported for live streams");
    }

    @Override
    public int getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public int getDuration() {
        return -1; // Live streams don't have a fixed duration
    }

    @Override
    public String getMediaInfo() {
        return "Live Stream: " + streamTitle + ", Viewers: " + viewerCount;
    }

    public int getViewerCount() {
        return viewerCount;
    }

    public void updateViewerCount(int count) {
        this.viewerCount = count;
        System.out.println("Viewer count updated: " + count);
    }
}