package me.Shogatsu.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;

import java.awt.*;
import java.time.format.DateTimeFormatter;

public class ServerInfo extends Command {
    private String members;
    private Member tempMembers;

    public ServerInfo() {
        this.name = "sinfo";
        this.aliases = new String[]{"sInfo", "serverInfo"};
        this.help = "Returns information about the server";
        this.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        //Remove message to reduce clutter
        e.getMessage().delete().queue();

        EmbedBuilder sinfo = new EmbedBuilder()
                .setColor(Color.yellow)
                .setThumbnail(e.getGuild().getIconUrl())
                .setAuthor(e.getGuild().getName())
                .addField("Owner: ", e.getGuild().getOwner().getEffectiveName(), true)
                .addField("Region: ", e.getGuild().getRegion().toString(), true)
                .addField("Members: ", getMembers(e.getGuild().getMembers()), true);

        e.reply(sinfo.build());
        e.getGuild().getMembers();
    }
    public String getMembers(java.util.List membersList) {
        members = "";
        if (!membersList.isEmpty()) {
            tempMembers = (Member) membersList.get(0);
            members = tempMembers.getEffectiveName();
            for (int i = 1; i < membersList.size(); i++) {
                tempMembers = (Member) membersList.get(i);
                members += ", " + tempMembers.getEffectiveName();
            }
        }
        return members;
    }

}

