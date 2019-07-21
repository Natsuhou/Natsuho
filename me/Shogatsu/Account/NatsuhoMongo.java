package me.Shogatsu.Account;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.jagrosh.jdautilities.examples.doc.Author;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import org.bson.Document;
import java.awt.*;

public class NatsuhoMongo {
    private MongoCollection<Document> col;
    private MongoDatabase db;
    private MongoClient mc;
    private Document doc;
    private String discordId;

    public NatsuhoMongo() {
        try {
            final String uri = ("mongodb+srv://Shogatsu:Thewonderwaffledg2natsuho@core-imu2f.mongodb.net/test?retryWrites=true&w=majority");
            MongoClientURI cUri = new MongoClientURI(uri);

            this.mc = new MongoClient(cUri);
            this.db = mc.getDatabase("Natsuho");
            this.col = db.getCollection("Userdata");
        } catch (MongoClientException exception) {
            exception.getCause().printStackTrace();
        } catch (MongoInterruptedException exception) {
            exception.getCause().printStackTrace();
        }
    }

    //Create an account in the mongo database with the key identifier being their unique discord id
    private void createAccount(String userId) {
        doc = new Document()
                .append("discordId", userId)
                .append("currency", 0);
        col.insertOne(doc);
        mc.close();
    }

    //Used to check if user has an account based off of discord id as key identifier
    private boolean hasAccount(String discordId) {
        BasicDBObject query = new BasicDBObject("discordId", discordId);
        doc = col.find(query).first();
        return doc != null;
    }
    public void addCurrency(int amount, CommandEvent e) {
        while (!hasAccount(e.getAuthor().getId())) {
            e.reply("Hey " + e.getAuthor().getName() + " it looks like you need an account! \nLet me make one for you!" );
            EmbedBuilder newAcc = new EmbedBuilder()
                    .setColor(Color.green)
                    .setThumbnail("http://clipart-library.com/image_gallery2/Success-PNG-Image.png")
                    .setAuthor("Account has been successfully created!", null, e.getAuthor().getAvatarUrl())
                    .setDescription("Please have fun and don't forget to vote for free rewards!")
                    .setFooter("Need some help? Do 'help for more info!", null);
            e.reply(newAcc.build());

            try {
                createAccount(e.getAuthor().getId());
            } catch (MongoException exception) {
                exception.getCause().printStackTrace();
            } catch (IllegalStateException exception) {
                System.out.println("Illegal state " + exception.getMessage());
            }
        }
        BasicDBObject updatedDoc = new BasicDBObject().append("$inc", new BasicDBObject().append("currency", amount));
        col.updateOne(new BasicDBObject().append("discordId", e.getAuthor().getId()), updatedDoc);

        //Currently a test command to add stuff
        EmbedBuilder addC = new EmbedBuilder()
                .setTitle("Added Currency to account")
                .setDescription("Amount added is " + amount);
        e.reply(addC.build());
        mc.close();

    }
    public void removeCurrency(int amount, CommandEvent e) {
        while (!hasAccount(e.getAuthor().getId())) {
            e.reply("Hey " + e.getAuthor().getName() + " it looks like you need an account!");
            e.reply("Let me make one for you!");

            EmbedBuilder newAcc = new EmbedBuilder()
                    .setColor(Color.green)
                    .setThumbnail("http://clipart-library.com/image_gallery2/Success-PNG-Image.png")
                    .setAuthor("Account has been successfully created!", null, e.getAuthor().getAvatarUrl())
                    .setDescription("Please have fun and don't forget to vote for free rewards!")
                    .setFooter("Need some help? Do 'help for more info!", null);
            e.reply(newAcc.build());
            createAccount(e.getAuthor().getId());
        }
        /*
        Body of the command
         */
    }

    public int getCurrency() {
        doc = col.find(new BasicDBObject("discordId", discordId)).projection(Projections.fields(Projections.include("currency"), Projections.excludeId())).first();
        int currency = doc.getInteger("currency");
        return currency;
    }
}
