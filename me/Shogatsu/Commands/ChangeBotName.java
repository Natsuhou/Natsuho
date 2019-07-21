package me.Shogatsu.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Icon;
import net.dv8tion.jda.core.managers.AccountManager;

public class ChangeBotName extends Command {
    public ChangeBotName() {
        this.name = "cn";
        this.help = "Change the name of the bot";
    }
    @Override
    protected void execute(CommandEvent e) {
        Guild guild = e.getGuild();

        if (guild != null && !e.getAuthor().isBot()) {
            if (e.getArgs().isEmpty()) {
                e.reply("Please type a name! Ex: 'cn (name)");
            } else {
                String newName = e.getArgs();

                AccountManager manager = new AccountManager(e.getJDA().getSelfUser())
                        .setName(newName);
                manager.queue();
            }
        } else {
            e.reply("Either guild is null or command issuer is a bot.");
        }
    }
}
