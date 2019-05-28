package Commands;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {
  @Override
  public void onMessageReceived(MessageReceivedEvent messageEvent) {
    JDA core = messageEvent.getJDA();

    User eventAuthor = messageEvent.getAuthor();
    MessageChannel eventChannel = messageEvent.getChannel();
    Message eventMsg = messageEvent.getMessage();
    String rawMsg = eventMsg.getContentRaw();

    if (eventMsg.getContentRaw().equals("rPing")) eventChannel.sendMessage("pong! " + eventAuthor.getJDA().getPing()).queue();
  }
}
