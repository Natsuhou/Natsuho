package me.Shogatsu.Managers;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import me.Shogatsu.Menu.GameMenu;
import me.Shogatsu.Menu.ErrorMenu;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

public class GameManager {
    private MongoCollection<Document> col;
    private Document doc;

    public GameManager() {
        try {
            final String uri = ("");
            final MongoClientURI cUri = new MongoClientURI(uri);
            final MongoClient mc = new MongoClient(cUri);
            final MongoDatabase db = mc.getDatabase("Core");
            this.col = db.getCollection("UserInfo");
        } catch (MongoClientException exception) {
            exception.printStackTrace();
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
    //Most methods in class are dependent on this method
    public void manageUser(User user, MessageChannel channel) {
        while(!hasAccount(user)) {
            GameMenu account = new GameMenu(user, channel);
            channel.sendMessage(account.createAccountMenu().build()).queue();
            createAccount(user.getId());
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
            channel.sendMessage(error.notEnoughCurrency("eggs").build()).queue();
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
                        Projections.excludeId()
                )
        ).first();
        assert doc != null;
        return doc.getString("description");
    }
    public void setDescription(User user, String newDescription, MessageChannel channel) {
        manageUser(user, channel);
        BasicDBObject updateQuery = new BasicDBObject("$set", new BasicDBObject("description", newDescription));
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        col.updateOne(searchQuery, updateQuery);
    }
    public void buyShopItem(User user, MessageChannel channel, String itemId, String itemName) {
        manageUser(user, channel);
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).first();
        assert doc != null;
        doc.append(itemId, itemName);
    }
    public void upgradeShopItem(User user, MessageChannel channel, String itemId, String itemName) {
        manageUser(user, channel);
        BasicDBObject updateQuery = new BasicDBObject("$set", new BasicDBObject(itemId, itemName));
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        col.updateOne(searchQuery, updateQuery);
    }
    public boolean hasShopItem(User user, MessageChannel channel, String itemId, String itemName) {
        manageUser(user, channel);
        BasicDBObject searchQueryUUID = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQueryUUID).projection(
                Projections.fields(
                        Projections.include(itemId, itemName),
                        Projections.excludeId()
                )
        ).first();
        return doc != null;
    }
    public int getFarmValue(User user, MessageChannel channel) {
        manageUser(user, channel);
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).projection(
                Projections.fields(
                        Projections.include("farmValue"),
                        Projections.excludeId()))
                .first();
        assert doc != null;
        return doc.getInteger("farmValue");
    }
    public int getTokens(User user, MessageChannel channel) {
        manageUser(user, channel);
        BasicDBObject searchQuery = new BasicDBObject("discordId", user.getId());
        doc = col.find(searchQuery).projection(
                Projections.fields(
                        Projections.include("tokens"),
                        Projections.excludeId()))
                .first();
        assert doc != null;
        return doc.getInteger("tokens");
    }
}
