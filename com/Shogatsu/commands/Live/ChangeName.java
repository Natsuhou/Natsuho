package com.Shogatsu.commands.Live;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.managers.AccountManager;

public class ChangeName extends Command {
    //Yoinked from DV8FromTheWorld's github
    /*manager.setName("Minn")
       .setAvatar(null)
       .queue();
manager.reset(AccountManager.NAME | AccountManager.AVATAR)
       .setName("DV8FromTheWorld")
       .setAvatar(icon)
       .queue();
       then you can use Icon.from(...) to get the avatar and set it there
       */
    AccountManager manager;
    String newName;
    Guild guild;
    public ChangeName() {
        this.name = "cn";
        this.help = "Change the name of the bot";
    }
    @Override
    protected void execute(CommandEvent e) {
        guild = e.getGuild();
        if (guild != null && !e.getAuthor().isBot()) {
            if (e.getArgs().isEmpty()) {
                e.reply("Please type a name! Ex: 'cn (name)");
            } else {
                newName = e.getArgs();

                manager = new AccountManager(e.getJDA().getSelfUser())
                        .setName(newName);
                manager.queue();
            }
        } else {
            e.reply("Either guild is null or command issuer is a bot.");
        }
    }
}
