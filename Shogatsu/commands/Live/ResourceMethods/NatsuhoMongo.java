package me.Shogatsu.commands.Live.ResourceMethods;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;

public class NatsuhoMongo {
    MongoClientURI cUri;
    MongoCollection<Document> col;
    MongoDatabase db;
    MongoClient mc;
    Document doc;

    //Figure out how this works
    public NatsuhoMongo() {
        final String uri = "mongodb+srv://Shogatsu:Thewonderwaffledg2@cluster0-lzh9e.mongodb.net/test?retryWrites=true";

        this.cUri = new MongoClientURI(uri);
        this.mc = new MongoClient(cUri);
        this.db = mc.getDatabase("Natsuho");
        this.col = db.getCollection("UserInfo");
    }
    public void createAccount(String userId) {
        doc = new Document()
                .append("discordID", userId)
                .append("currency", 0);
        col.insertOne(doc);
        mc.close();
    }
    public boolean hasAccount(String discordId) {
        col = db.getCollection("UserInfo");
        col.createIndex(Indexes.text("discordID"));
        long matches = col.countDocuments(Filters.text(discordId));
        System.out.println("Matches = " + matches);
        return false;
    }
}
