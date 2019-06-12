package com.Shogatsu.commands.Incomplete;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.core.entities.User;

@CommandInfo(
        name = "Create Account",
        description = "Command used to create a new account"
)
public class CreateAccount extends Command {
    String userId;
    MongoClient client;
    MongoDatabase db;
    MongoClientURI mcUri;
    String uri;

    public CreateAccount() {
        this.name = "create";
        this.help = "Used to create a user account";
        this.aliases = new String[]{"createAccount", "newAccount", "cAccount"};
    }

    @Override
    protected void execute(CommandEvent e) {
        userId = e.getAuthor().getId();


    }
}
