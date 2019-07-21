package me.Shogatsu.Account;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import net.dv8tion.jda.core.EmbedBuilder;

@CommandInfo(
        name = "Account Info",
        description = "Displays the account information"
)

public class AccountInfo extends Command {
    public AccountInfo() {
        this.name = "me";
        this.help = "Displays your account information";
        this.aliases = new String[]{"info", "information", "profile"};
    }

    @Override
    protected void execute(CommandEvent e) {
        NatsuhoMongo mongo = new NatsuhoMongo();

        EmbedBuilder profile = new EmbedBuilder()
                .setTitle(e.getAuthor().getName() + "'s profile", e.getAuthor().getAvatarUrl());
    }
}
