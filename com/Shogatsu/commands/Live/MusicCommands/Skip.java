package com.Shogatsu.commands.Live.MusicCommands;

import com.Shogatsu.commands.Live.ResourceMethods.NatsuhoMusic;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;

import java.awt.*;

public class Skip extends Command {
    NatsuhoMusic natsuho;
    Guild guild;

    public Skip() {
        this.name = "skip";
        this.help = "Skip the current song!";
        this.aliases = new String[] {"sSong", "rSkip", "nSkip"};
    }
    @Override
    protected void execute(CommandEvent e) {
        natsuho = new NatsuhoMusic();
        guild = e.getGuild();
        if (guild != null && !e.getAuthor().isBot()) {
            natsuho.skipTrack(e.getTextChannel());
            EmbedBuilder skip = new EmbedBuilder()
                    .setAuthor(e.getAuthor().getName() + " has skipped the current track", null, e.getAuthor().getAvatarUrl())
                    .setColor(Color.orange)
                    .setFooter("Need help? Type 'help for more info!", null);
            e.reply(skip.build());
        }
    }
}
