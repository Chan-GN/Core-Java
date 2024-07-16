package _interface.media_player;

public class Main {
    public static void main(String[] args) {
        MediaPlayerManager manager = new MediaPlayerManager();

        VideoPlayer videoPlayer = new VideoPlayer("Inception", 8880, "1080p");
        AudioPlayer audioPlayer = new AudioPlayer("Bohemian Rhapsody", 354, 320);
        LiveStreamPlayer liveStreamPlayer = new LiveStreamPlayer("Tech Conference 2023");

        manager.addPlayer(videoPlayer);
        manager.addPlayer(audioPlayer);
        manager.addPlayer(liveStreamPlayer);

        System.out.println("Playing all media:");
        manager.playAll();

        System.out.println("\nMedia Info:");
        manager.displayAllMediaInfo();

        System.out.println("\nTesting individual players:");
        videoPlayer.seek(3600);
        System.out.println("Video current position: " + MediaPlayer.formatDuration(videoPlayer.getCurrentPosition()));

        audioPlayer.play();
        System.out.println("Audio bitrate: " + audioPlayer.getBitrate() + "kbps");

        liveStreamPlayer.updateViewerCount(1000);
        System.out.println("Live stream viewers: " + liveStreamPlayer.getViewerCount());

        System.out.println("\nStopping all media:");
        manager.stopAll();

        System.out.println("\nPlayback status:");
        System.out.println("Video: " + videoPlayer.getPlaybackStatus());
        System.out.println("Audio: " + audioPlayer.getPlaybackStatus());
        System.out.println("Live Stream: " + liveStreamPlayer.getPlaybackStatus());
    }
}