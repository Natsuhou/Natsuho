package me.Shogatsu.commands.Incomplete;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Anime extends Command {
    public Anime() {
        this.name = "anime";
        this.help = "Use this command to watch anime";
    }
    @Override
    protected void execute(CommandEvent e) {
        if (e.getArgs().isEmpty()) {
            e.reply("Please type a valid anime! Ex: 'anime Naruto");
        }
    }
}
