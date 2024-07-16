package _interface.media_player;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayerManager {
    private List<MediaPlayer> players;

    public MediaPlayerManager() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(MediaPlayer player) {
        players.add(player);
    }

    public void playAll() {
        for (MediaPlayer player : players) {
            player.play();
        }
    }

    public void stopAll() {
        for (MediaPlayer player : players) {
            player.stop();
        }
    }

    public void displayAllMediaInfo() {
        for (MediaPlayer player : players) {
            System.out.println(player.getMediaInfo());
        }
    }
}