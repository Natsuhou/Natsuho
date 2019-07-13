package me.Shogatsu.commands.Account;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import org.bson.Document;
import java.awt.*;

public class NatsuhoMongo {
    private MongoClientURI cUri;
    private MongoCollection<Document> col;
    private MongoDatabase db;
    private MongoClient mc;
    private Document doc;
    private CommandEvent e;
    private User author;
    private Message message;
    private String discordId;


    public NatsuhoMongo(CommandEvent event) {
        final String uri = "mongodb+srv://Shogatsu:Thewonderwaffledg2@cluster0-lzh9e.mongodb.net/test?retryWrites=true";
        this.cUri = new MongoClientURI(uri);
        this.mc = new MongoClient(cUri);
        this.db = mc.getDatabase("Natsuho");
        this.col = db.getCollection("UserInfo");

        this.e = event;

        /*
        This was mostly done so I don't have to type
        e.getAuthor or e.getMessage everytime I want to get the user
        so when I want to get things like the author name or the raw message,
        I can just do author.getName() or message.getContentRaw() rather than
        e.getAuthor().getName() or e.getMessage().getContentRaw()
         */
        this.author = e.getAuthor();
        this.message = e.getMessage();
        this.discordId = author.getId();
    }

    //Create an account in the mongo database with the key identifier being their unique discord id
    public void createAccount(String userId) {
        doc = new Document()
                .append("discordId", userId)
                .append("currency", 0);
        col.insertOne(doc);
        mc.close();
    }

    //Used to check if user has an account based off of discord id as key identifier
    public boolean hasAccount() {
        BasicDBObject query = new BasicDBObject("discordId", discordId);

        doc = col.find(query).first();
        return doc != null;
    }

    //Invoked when user gains currency by farming or something
    public void addCurrency(int amount) {
        /*
        Checks if user has account. If not, account will automatically be created for user.
         */
        while (!hasAccount()) {
            e.reply("Hey " + author.getName() + " it looks like you need an account! \nLet me make one for you!" );
            EmbedBuilder newAcc = new EmbedBuilder()
                    .setColor(Color.green)
                    .setThumbnail("http://clipart-library.com/image_gallery2/Success-PNG-Image.png")
                    .setAuthor("Account has been successfully created!", null, e.getAuthor().getAvatarUrl())
                    .setDescription("Please have fun and don't forget to vote for free rewards!")
                    .setFooter("Need some help? Do 'help for more info!", null);
            e.reply(newAcc.build());

            try {
                createAccount(discordId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*
        Body of the command
         */
        BasicDBObject updatedDoc = new BasicDBObject().append("$inc", new BasicDBObject().append("currency", amount));
        col.updateOne(new BasicDBObject().append("discordId", discordId), updatedDoc);

        //Currently a test command to add stuff
        EmbedBuilder addC = new EmbedBuilder()
                .setTitle("Added Currency to account")
                .setDescription("Amount added is " + amount);
        e.getChannel().sendMessage(addC.build()).queue();
        mc.close();

    }

    //Invoked when user tries to purchase something
    public void removeCurrency(int amount) {
        /*
        Checks if user has account. If not, account will automatically be created for user.
         */
        while (!hasAccount()) {
            e.reply("Hey " + author.getName() + " it looks like you need an account!");
            e.reply("Let me make one for you!");

            EmbedBuilder newAcc = new EmbedBuilder()
                    .setColor(Color.green)
                    .setThumbnail("http://clipart-library.com/image_gallery2/Success-PNG-Image.png")
                    .setAuthor("Account has been successfully created!", null, e.getAuthor().getAvatarUrl())
                    .setDescription("Please have fun and don't forget to vote for free rewards!")
                    .setFooter("Need some help? Do 'help for more info!", null);
            e.reply(newAcc.build());
            createAccount(discordId);
        }
        /*
        Body of the command
         */
    }

    public int getCurrency() {
        int currency = 50;
        return currency;
    }
}
