package com.Shogatsu.commands.Incomplete;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.SelfUser;
import net.dv8tion.jda.core.entities.impl.JDAImpl;
import net.dv8tion.jda.core.entities.impl.SelfUserImpl;
import net.dv8tion.jda.core.managers.AccountManager;

public class Profile extends Command {
    /*manager.setName("Minn")
       .setAvatar(null)
       .queue();
manager.reset(AccountManager.NAME | AccountManager.AVATAR)
       .setName("DV8FromTheWorld")
       .setAvatar(icon)
       .queue();
       then you can use Icon.from(...) to get the avatar and set it there
       */


    public Profile() {
        this.name = "changeName";
        this.help = "Change the name of the bot";
    }
    @Override
    protected void execute(CommandEvent e) {
        //SelfUser selfUser = new SelfUserImpl();
        AccountManager accountManager = new AccountManager(e.getSelfUser());
        accountManager.setName("Shogatrs");
        accountManager.queue();

    }
}
