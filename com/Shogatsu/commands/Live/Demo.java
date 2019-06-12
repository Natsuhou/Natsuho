package com.Shogatsu.commands.Live;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;


public class Demo extends Command {
    public Demo() {
        this.name = "demo";
        this.aliases = new String[] {"demoFun"};
        this.help = "Testing out new builds!";
    }
    @Override
    protected void execute(CommandEvent e) {
        e.reply("You just used the debug command. Check console for errors");
        EmbedBuilder skip = new EmbedBuilder()
                .setAuthor(e.getAuthor().getName() + " has skipped the current track", null, e.getAuthor().getAvatarUrl())
                .setColor(Color.orange)
                .setThumbnail(e.getSelfUser().getAvatarUrl());
        e.reply(skip.build());
    }
}
