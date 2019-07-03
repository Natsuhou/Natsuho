package me.Shogatsu.commands.Live.MusicCommands;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

public class MusicManager {
    private final AudioPlayer player;
    public final TrackScheduler scheduler;

    public MusicManager(AudioPlayerManager manager) {
        player = manager.createPlayer();
        scheduler = new TrackScheduler(player);
        player.addListener(scheduler);
    }

    public SendHandler getSendHandler() {
        return new SendHandler(player);
    }
}
