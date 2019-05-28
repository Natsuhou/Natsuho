package Commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Help extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        JDA core = event.getJDA();
        User author = event.getAuthor();
        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        String rawMsg = message.getContentRaw();

        if (message.equals("rHelp")) {
            EmbedBuilder help = new EmbedBuilder();
            help.setColor(Color.PINK);
            help.addField("rWeapon", "- Rolls from a set of weapons", false);
            help.addField("rGem", "- Rolls from a set of socketable gems", false);
            help.addField("rPing", "- Shows your ping!", false);
            help.addField("rDungeon", "- Shows general commands for dungeons", false);
            channel.sendMessage(help.build()).queue();
        }
    }
}
