package com.Shogatsu.commands.Incomplete;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.var;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;

import java.awt.*;
import java.util.List;

public class ServerInfo extends Command {
    private EmbedBuilder sinfo;

    public ServerInfo() {
        this.name = "sinfo";
        this.aliases = new String[]{"sInfo", "serverInfo"};
        this.help = "Returns information about the server";
    }
    @Override
    protected void execute(CommandEvent e) {
        sinfo = new EmbedBuilder();

        sinfo.setColor(Color.yellow);
        sinfo.setThumbnail(e.getGuild().getIconUrl());
        sinfo.setAuthor(e.getGuild().getName());

        sinfo.addField("Owner: ", e.getGuild().getOwner().getEffectiveName(), true);
        sinfo.addField("Region: ", e.getGuild().getRegion().toString(), true);

        //This is good for getting peoples ID?
        /*
        for (var members : e.getGuild().getMembers().toArray()) {
            sinfo.addField("Members: ", members.toString(), true );
        }
        */

        e.reply(sinfo.build());
    }/*
    private int getMembers(CommandEvent e) {
        List members = e.getGuild().getMembers();
        for (int i = 0; i < members.size(); i++) {
            String pog = members.get(i).toString();
        }

    }*/
}

