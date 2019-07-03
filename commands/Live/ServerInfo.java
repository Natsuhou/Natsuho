package me.Shogatsu.commands.Live;

import me.Shogatsu.commands.Live.ResourceMethods.NatsuhoR1;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;

public class ServerInfo extends Command {
    NatsuhoR1 natsuho = new NatsuhoR1();

    public ServerInfo() {
        this.name = "sinfo";
        this.aliases = new String[]{"sInfo", "serverInfo"};
        this.help = "Returns information about the server";
        this.cooldown = 5;
    }
    @Override
    protected void execute(CommandEvent e) {
        EmbedBuilder sinfo = new EmbedBuilder()
                .setColor(Color.yellow)
                .setThumbnail(e.getGuild().getIconUrl())
                .setAuthor(e.getGuild().getName())
                .addField("Owner: ", e.getGuild().getOwner().getEffectiveName(), true)
                .addField("Region: ", e.getGuild().getRegion().toString(), true)
                .addField("Members: ", natsuho.getMembers(e.getGuild().getMembers()), true);

        e.reply(sinfo.build());
        e.getGuild().getMembers();
    }
}

