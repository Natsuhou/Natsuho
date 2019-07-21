package me.Shogatsu.Account;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;


@CommandInfo(
        name = "Update",
        description = "Add something"
)
public class UpdateAccount extends Command {
    public UpdateAccount() {
        this.name = "update";
        this.aliases = new String[]{"up", "add"};
    }

    @Override
    protected void execute(CommandEvent e) {
        NatsuhoMongo update = new NatsuhoMongo();
        update.addCurrency(15, e);
    }
}
