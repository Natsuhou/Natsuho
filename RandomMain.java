import Commands.*;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.security.auth.login.LoginException;

public class RandomMain {
  public static void main(String[] args) {
    try {
      String uri = "mongodb+srv://Shogatsu:Thewonderwaffledg2@cluster0-lzh9e.mongodb.net/test?retryWrites=true";
      MongoClientURI clientURI = new MongoClientURI(uri);
      MongoClient mongoClient = new MongoClient(clientURI);

      MongoDatabase mongoDatabase = mongoClient.getDatabase("Test");
      MongoCollection collection = mongoDatabase.getCollection("EpicWeapons");
      System.out.println("Database Connected");

      Document search = new Document("Name", "Shogatsu");
      Document found = (Document) collection.find(new Document("Name", "Shogatsu")).first();

      if (found != null) {
        System.out.println("Found User");
        Bson updatedvalue = new Document("Age", "25");
        Bson updateoperation = new Document("$set", updatedvalue);
        collection.updateOne(found, updateoperation);
        System.out.println("User updated");
      }

      Block<Document> printBlock = document -> System.out.println(document.toJson());
      //collection.aggregate(Arrays.asList(Aggregates.match()));
    /*
    Document document = new Document("name", "Shogatsu");
    document.append("Username", "Value");
    document.append("Age", "21");
    document.append("Race", "White");\
    collection.insertOne(document);
     */

    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      JDA core =
          new JDABuilder(AccountType.BOT).setToken("NTgyNTA3MTc1MjAxNzM0NjU2.XOu0LQ.LzXguFKMVHqyJesSKqiD8vkqXHc")
                  .addEventListener(new Help())
                  .addEventListener(new Ping())
                  .addEventListener(new WeaponRoll())
                  .addEventListener(new GemRoll())
                  .addEventListener(new Dungeon())
              .build();
      core.getPresence().setPresence(Game.playing("forging new weapons..."), true);
    } catch (LoginException e) {
      e.printStackTrace();
    }
  }
}
