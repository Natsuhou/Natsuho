package me.Shogatsu.commands.Incomplete;

import me.Shogatsu.commands.Live.ResourceMethods.NatsuhoMongo;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.core.EmbedBuilder;

import java.awt.*;


@CommandInfo(
        name = "Create Account",
        description = "Command used to create a new account"
)
public class CreateAccount extends Command {

    private MongoClientURI cURI;
    private MongoClient mc;
    private MongoDatabase db;
    private MongoCollection col;

    public CreateAccount() {
        this.name = "create";
        this.help = "Used to create a user account";
        this.aliases = new String[]{"createAccount", "newAccount", "cAccount"};
    }

    @Override
    protected void execute(CommandEvent e) {
        String userId = e.getAuthor().getId();
        String userName = e.getAuthor().getName();

        NatsuhoMongo user = new NatsuhoMongo();

        if(user.hasAccount(e.getAuthor().getId())) {
            EmbedBuilder eb = new EmbedBuilder()
                    .setColor(Color.pink)
                    .setThumbnail("https://pngtree.com/free-icon/fail_641034")
                    .setAuthor("Account creation has failed", null, e.getAuthor().getAvatarUrl())
                    .setDescription("Perhaps you have created an account already?")
                    .setFooter("If you believe this is an error, please contact " + e.getGuild().getOwner().getEffectiveName(), e.getSelfUser().getAvatarUrl());
            e.reply(eb.build());
        } else {
            user.createAccount(e.getAuthor().getId());
            EmbedBuilder eb = new EmbedBuilder()
                    .setColor(Color.pink)
                    .setThumbnail("http://clipart-library.com/image_gallery2/Success-PNG-Image.png")
                    .setAuthor("Account has been successfully created!", null, e.getAuthor().getAvatarUrl())
                    .setDescription("Please have fun and don't forget to vote for free rewards!")
                    .setFooter("Need some help? Do 'help for more info!", e.getJDA().getSelfUser().getAvatarUrl());
            e.reply(eb.build());
        }
    }
}
