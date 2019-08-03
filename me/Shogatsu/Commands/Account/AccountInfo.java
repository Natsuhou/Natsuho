package me.Shogatsu.Commands.Account;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import me.Shogatsu.Managers.AccountManager;
import me.Shogatsu.Menu.AccountMenu;
import me.Shogatsu.Menu.ErrorMenu;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import java.util.List;

@CommandInfo(
        name = "Account Info",
        description = "Displays the account information"
)

public class AccountInfo extends Command {
    public AccountInfo() {
        this.name = "me";
        this.help = "Displays account information";
        this.aliases = new String[] {"profile"};
    }
    @Override
    protected void execute(CommandEvent e) {
        AccountMenu menu;
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake() && e.getArgs().isEmpty()) {
            menu = new AccountMenu(e.getAuthor(), e.getChannel());
            e.reply(menu.accountMenu().build());
        } else if (!e.getArgs().isEmpty()) {
            List<Member> mentionedUser = e.getMessage().getMentionedMembers();
            for (Member m : mentionedUser) {
                User user = m.getUser();
                if (user != null) {
                    menu = new AccountMenu(user, e.getChannel());
                    AccountManager manager = new AccountManager();
                    if (manager.hasAccount(user)) {
                        e.reply(menu.accountMenu().build());
                    } else {
                        ErrorMenu error = new ErrorMenu(user, e.getChannel());
                        e.reply(error.userDoesNotExist().build());
                    }
                }
            }
        }
    }
}
