package com.Shogatsu.commands.Live;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Role;

import java.awt.*;

public class Shutdown extends Command {
    EmbedBuilder builder;
    public Shutdown() {
        this.name = "shutdown";
        this.help = "Shuts down the bot";
        this.aliases = new String[]{"botgone"};
        this.userPermissions = new Permission[]{Permission.ADMINISTRATOR};
    }

    @Override
    protected void execute(CommandEvent e) {
        JDA core = e.getJDA();
        builder = new EmbedBuilder()
            .setColor(Color.yellow)
            .setThumbnail(e.getAuthor().getAvatarUrl())
            .setDescription(e.getAuthor().getName() + " has shut down the bot");

        e.reply(builder.build());
        core.shutdown();
    }
}
