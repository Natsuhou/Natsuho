package me.Shogatsu.Commands.General;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

@CommandInfo(
        name = "Server info",
        description = "Displays guild's owner, region and members"
)

public class ServerInfo extends Command {
    public ServerInfo() {
        this.name = "sinfo";
        this.aliases = new String[] {"sInfo", "serverInfo"};
        this.help = "Returns information about the server";
        this.cooldown = 5;
    }
    @Override
    protected void execute(@NotNull CommandEvent e) {
        EmbedBuilder sinfo = new EmbedBuilder()
                .setColor(Color.yellow)
                .setThumbnail(e.getGuild().getIconUrl())
                .setAuthor(e.getGuild().getName())
                .addField("Owner: ", e.getGuild().getOwner().getEffectiveName(), true)
                .addField("Region: ", e.getGuild().getRegion().toString(), true)
                .addField("Members: ", getMembers(e.getGuild().getMembers()), true);
        e.reply(sinfo.build());
    }
    private String getMembers(@NotNull List membersList) {
        String members;
        Member tempMembers;

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

