package me.Shogatsu.commands.Music;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;

import java.awt.*;

public class Skip extends Command {
    Music natsuho;
    Guild guild;

    public Skip() {
        this.name = "skip";
        this.help = "Skip the current song!";
        this.aliases = new String[] {"sSong", "rSkip", "nSkip"};
        this.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        natsuho = new Music();
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
