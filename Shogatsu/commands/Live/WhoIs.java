package me.Shogatsu.commands.Live;

import me.Shogatsu.commands.Live.ResourceMethods.NatsuhoR1;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;


import java.awt.*;
import java.time.format.DateTimeFormatter;

@CommandInfo(
        name = "Meme Collection",
        description = "Displays your collection of memes"
)
public class WhoIs extends Command {
    private EmbedBuilder builder;
    private Member member;
    private DateTimeFormatter dtf;
    private String roles;
    private Role temp;

    NatsuhoR1 natsuho = new NatsuhoR1();

    public WhoIs() {
        this.name = "whois";
        this.help = "Shows your collection of memes";
        this.aliases = new String[]{"userinfo", "who"};
        this.cooldown = 5;
        this.arguments = "[name]";
    }
    @Override
    protected void execute(CommandEvent e) {
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
                        .addField("Roles: ", natsuho.getRoles(member.getRoles()), true);
                e.reply(builder.build());

            } catch (IndexOutOfBoundsException ex) {
                e.reply("Please reformat command as: 'whois @Username");
            }
        }
    }
}
