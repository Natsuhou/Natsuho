package com.Shogatsu.commands.Live.MusicCommands;

import com.Shogatsu.commands.Live.ResourceMethods.NatsuhoMusic;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;

public class Play extends Command {
    NatsuhoMusic natsuho;
    Guild guild;
    EmbedBuilder error;
    public Play() {
        this.name = "play";
        this.help = "Play a certain track";
        this.aliases = new String[] {"playTrack", "pTrack"};
    }
    @Override
    protected void execute(CommandEvent e) {
        natsuho = new NatsuhoMusic();
        guild = e.getGuild();

        if (guild != null && !e.getAuthor().isBot()) {
            if (e.getArgs().isEmpty()) {
                e.reply("Please enter a youtube link into the command!");
            } else {
                try {
                    natsuho.loadAndPlay(e.getTextChannel(), e.getArgs());
                } catch (IndexOutOfBoundsException et) {
                    e.reply("Please reformat command as: 'play (youtube link) to play a song!");
                }
            }
        } else {
            e.reply("Either guild is null or command issuer is a bot.");
        }
    }
}
