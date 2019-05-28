package Commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Dungeon extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User author = event.getAuthor();
        MessageChannel channel = event.getChannel();
        Message message = event.getMessage();
        String rawMsg = message.getContentRaw();

        if (rawMsg.equals("rRaid")) {
            channel.sendMessage("Who would you like to put inside the battle?").queue();
            channel.sendMessage("").queue();
        }
    }
}
