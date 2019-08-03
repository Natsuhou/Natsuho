package me.Shogatsu.Commands.Shop;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.menu.Menu;
import me.Shogatsu.Managers.AccountManager;
import me.Shogatsu.Menu.ErrorMenu;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

public class Buy extends Command {
    public Buy() {
        this.name = "b";
        this.aliases = new String[] {"buy"};
    }

    @Override
    protected void execute(CommandEvent e) {
        AccountManager manager = new AccountManager();
        ErrorMenu error = new ErrorMenu(e.getAuthor(), e.getChannel());

        if (e.getAuthor().isFake() && e.getAuthor().isBot()) {
            e.reply(error.invalidAccount().build());
        } else if (e.getArgs().isEmpty()) {
            e.reply(error.noArgs("Please enter an item from the shop!").build());
        }
        switch (e.getArgs()) {
            case "Sword":
                manager.minusCurrency(e.getAuthor(), -15, e.getChannel());
            case "Shield":
                manager.minusCurrency(e.getAuthor(), -15, e.getChannel());
        }

    }
}
