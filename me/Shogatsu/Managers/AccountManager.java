package me.Shogatsu.Managers;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import me.Shogatsu.Menu.AccountMenu;
import me.Shogatsu.Menu.ErrorMenu;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

public class AccountManager {
    private MongoCollection<Document> col;
    private Document doc;

    public AccountManager() {
        try {
            final String uri = ("");
            final MongoClientURI cUri = new MongoClientURI(uri);
            MongoClient mc = new MongoClient(cUri);
            MongoDatabase db = mc.getDatabase("Core");
            this.col = db.getCollection("UserInfo");
        } catch (MongoClientException exception) {
            exception.getCause().printStackTrace();
        }
    }
    private void createAccount(String discordId) {
        doc = new Document()
                .append("discordId", discordId)
                .append("currency", 0)
                .append("description", "Change me with 'cd [arguements]!");
        col.insertOne(doc);
    }
    public boolean hasAccount(@NotNull User user) {
        BasicDBObject query = new BasicDBObject("discordId", user.getId());
        doc = col.find(query).first();
        return doc != null;
    }
    public void manageUser(User user, MessageChannel channel) {
        while(!hasAccount(user)) {
            try {
                AccountMenu account = new AccountMenu(user, channel);
                channel.sendMessage(account.createAccountMenu().build()).queue();
                createAccount(user.getId());
            } catch (MongoException exception) {
                exception.getCause().printStackTrace();
            }
        }
    }
    public void addCurrency(User user, int amount, MessageChannel channel) {
        manageUser(user, channel);
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        BasicDBObject updateQuery = new BasicDBObject("$inc", new BasicDBObject("currency", amount));
        col.updateOne(searchQuery, updateQuery);
    }
    public void minusCurrency(User user, int cost, MessageChannel channel) {
        manageUser(user, channel);
        ErrorMenu error = new ErrorMenu(user);

        if (getCurrency(user, channel) >= Math.abs(cost)) {
            BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
            BasicDBObject updateQuery = new BasicDBObject("$inc", new BasicDBObject("currency", cost));
            col.updateOne(searchQuery, updateQuery);
        } else {
            channel.sendMessage(error.notEnoughCurrency().build()).queue();
        }
    }
    public int getCurrency(User user, MessageChannel channel) {
        manageUser(user, channel);
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).projection(
                Projections.fields(
                        Projections.include("currency"),
                        Projections.excludeId()))
                .first();
        assert doc != null;
        return doc.getInteger("currency");
    }
    public String getDescription(User user, MessageChannel channel) {
        manageUser(user, channel);
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).projection(
                Projections.fields(
                        Projections.include("description"),
                        Projections.excludeId())).first();
        assert doc != null;
        return doc.getString("description");
    }
    public void setDescription(User user, String newDescription, MessageChannel channel) {
        manageUser(user, channel);
        BasicDBObject updateQuery = new BasicDBObject("$set", new BasicDBObject("description", newDescription));
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        col.updateOne(searchQuery, updateQuery);
    }
}
