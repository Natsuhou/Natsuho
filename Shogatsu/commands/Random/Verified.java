package me.Shogatsu.commands.Random;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;

public class Verified extends Command {
    public Verified() {
        this.name = "verified";
        this.help = "verify a user?";
        this.ownerCommand = true;
        this.userPermissions = new Permission[] {Permission.ADMINISTRATOR};
    }

    @Override
    protected void execute(CommandEvent e) {
        //I presume you finished the part where you created the command !verify and the part where you added a role to the person that did the comnmand


        Guild guild = e.getGuild();
        for (MessageChannel channel : guild.getTextChannels()) {
            if (channel.getId() == "id") {
                channel.sendMessage("Verified").queue();
            }
        }
    }
}
