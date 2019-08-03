package me.Shogatsu.Commands.Account;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.Shogatsu.Managers.AccountManager;

public class CreateAccount extends Command {
    public CreateAccount() {
        this.name = "create";
        this.cooldown = 50000;
        this.aliases = new String[] {"ca"};
    }

    @Override
    protected void execute(CommandEvent e) {
        AccountManager manager = new AccountManager();
        manager.manageUser(e.getAuthor(), e.getChannel());
    }
}
