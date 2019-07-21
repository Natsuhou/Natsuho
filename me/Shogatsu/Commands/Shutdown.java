package me.Shogatsu.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import java.awt.*;

public class Shutdown extends Command {
    public Shutdown() {
        this.name = "shutdown";
        this.help = "Command used to make sure bot doesn't destroy everything";
        this.aliases = new String[]{"botgone"};
        this.userPermissions = new Permission[]{Permission.ADMINISTRATOR};
    }

    @Override
    protected void execute(CommandEvent e) {
        //Remove message to reduce clutter
        e.getMessage().delete().queue();

        JDA core = e.getJDA();

        EmbedBuilder builder = new EmbedBuilder()
                .setColor(Color.yellow)
                .setThumbnail(e.getAuthor().getAvatarUrl())
                .setDescription(e.getAuthor().getName() + " has shut down the bot");

        e.reply(builder.build());
        core.shutdown();
    }
}
