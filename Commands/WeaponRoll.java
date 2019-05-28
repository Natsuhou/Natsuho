package Commands;

import net.dv8tion.jda.client.events.message.group.react.GroupMessageReactionAddEvent;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class WeaponRoll extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        JDA core = event.getJDA();

    }

    @Override
    public void onGroupMessageReactionAdd(GroupMessageReactionAddEvent event) {
        JDA core = event.getJDA();
    }
}
