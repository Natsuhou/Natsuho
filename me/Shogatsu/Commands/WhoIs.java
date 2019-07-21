package me.Shogatsu.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;


import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CommandInfo(
        name = "Meme Collection",
        description = "Displays your collection of memes"
)
public class WhoIs extends Command {
    private EmbedBuilder builder;
    private Member member;
    private DateTimeFormatter dtf;
    private String roles, members;
    private Role tempRoles;
    private Member tempMembers;

    public WhoIs() {
        this.name = "whois";
        this.help = "Shows your collection of memes";
        this.aliases = new String[]{"userinfo", "who"};
        this.cooldown = 5;
        this.arguments = "[name]";
    }
    @Override
    protected void execute(CommandEvent e) {
        //Remove message to reduce clutter
        e.getMessage().delete().queue();

        if (e.getArgs().isEmpty()) {
            e.reply("Please provide a name! Type 'whois @UserName");
        } else {
            try {
                member = e.getMessage().getMentionedMembers().get(0);
                dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                builder = new EmbedBuilder()
                        .setColor(Color.yellow)
                        .setThumbnail(member.getUser().getAvatarUrl())
                        .setAuthor("Member information on " + member.getEffectiveName(), member.getUser().getAvatarUrl(), "https://cdn1.iconfinder.com/data/icons/MetroStation-PNG/252/MB__search.png")
                        .addField("Join Date: ", member.getJoinDate().format(dtf), true)
                        .addField("Status: ", member.getOnlineStatus().toString(), true)
                        .addField("Effective ID: ", member.getUser().getId(), true)
                        .addField("Roles: ", getRoles(member.getRoles()), true);
                e.reply(builder.build());

            } catch (IndexOutOfBoundsException ex) {
                e.reply("Please reformat command as: 'whois @Username");
            }
        }
    }
    private String getRoles(List rolesList) {
        roles = "";
        if (!rolesList.isEmpty()) {
            tempRoles = (Role) rolesList.get(0);
            roles = tempRoles.getName();
            for (int i = 1; i < rolesList.size(); i++) {
                tempRoles = (Role) rolesList.get(i);
                roles += ", " + tempRoles.getName();
            }
        } else {
            roles = "No Roles";
        }
        return roles;
    }
}
