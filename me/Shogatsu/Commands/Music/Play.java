package me.Shogatsu.Commands.Music;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Managers.MusicManager;

public class Play extends Command {
    public Play() {
        this.name = "play";
        this.help = "Play a song via youtube link";
    }
    @Override
    protected void execute(CommandEvent e) {
        MusicManager music = new MusicManager(e);

    }
}
