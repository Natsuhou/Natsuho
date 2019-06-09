package com.Shogatsu.commands.Incomplete;

import com.Shogatsu.BotCore;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;


import java.awt.*;
import java.time.format.DateTimeFormatter;

@CommandInfo(
        name = "Meme Collection",
        description = "Displays your collection of memes"
)
public class WhoIs extends Command {
    EmbedBuilder builder;
    Member member;
    DateTimeFormatter dtf;

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
            e.reply("Please provide a name! Ex: 'whois @UserName");
        } else {
            try {
                member = e.getMessage().getMentionedMembers().get(0);
                dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                builder = new EmbedBuilder()
                        //Fix this Color.RGBtoHSB()
                        .setColor(Color.yellow)
                        .setThumbnail(member.getUser().getAvatarUrl())
                        .setAuthor("Member information on " + member.getEffectiveName(), member.getUser().getAvatarUrl(), "https://cdn1.iconfinder.com/data/icons/MetroStation-PNG/252/MB__search.png")
                        .addField("Join Date: ", member.getJoinDate().format(dtf), true)
                        .addField("Status: ", member.getOnlineStatus().toString(), true)
                        .addField("Effective ID: ", member.getUser().getId(), true);
                e.reply(builder.build());

            } catch (IndexOutOfBoundsException ex) {
                e.reply("Remember to @ them when typing this command!");
            }
        }
    }
}
