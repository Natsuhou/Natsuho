package com.Shogatsu.commands.Live.MusicCommands;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import net.dv8tion.jda.core.audio.AudioSendHandler;

public class SendHandler implements AudioSendHandler {
    private final AudioPlayer player;
    private AudioFrame lastFrame;

    public SendHandler(AudioPlayer player) {
        this.player = player;
    }

    @Override
    public boolean canProvide() {
        if (lastFrame == null) {
            lastFrame = player.provide();
        }
        return lastFrame != null;
    }

    @Override
    public byte[] provide20MsAudio() {
        if (lastFrame == null) {
            lastFrame = player.provide();
        }
        byte[] data = lastFrame != null ? lastFrame.getData() : null;
        lastFrame = null;
        return data;
    }
    @Override
    public boolean isOpus() {
        return true;
    }
}
