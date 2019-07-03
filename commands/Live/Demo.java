package me.Shogatsu.commands.Live;

import me.Shogatsu.commands.Live.ResourceMethods.NatsuhoMongo;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;


public class
Demo extends Command {
    public Demo() {
        this.name = "demo";
        this.aliases = new String[] {"demoFun"};
        this.help = "Testing out new builds!";
    }
    @Override
    protected void execute(CommandEvent e) {
        NatsuhoMongo user = new NatsuhoMongo();
        user.createAccount(e.getAuthor().getId());
        EmbedBuilder eb = new EmbedBuilder()
                .setColor(Color.green)
                .setThumbnail("http://clipart-library.com/image_gallery2/Success-PNG-Image.png")
                .setAuthor("Account has been successfully created!", null, e.getAuthor().getAvatarUrl())
                .setDescription("Please have fun and don't forget to vote for free rewards!")
                .setFooter("Need some help? Do 'help for more info!", e.getJDA().getSelfUser().getAvatarUrl());
        e.reply(eb.build());
    }
}
