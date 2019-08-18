package me.Shogatsu.Verification;

import me.Shogatsu.Managers.AuthManager;
import net.dv8tion.jda.core.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReactAuthentication extends ListenerAdapter {
    @Override
    public void onPrivateMessageReactionAdd(PrivateMessageReactionAddEvent e) {
        super.onPrivateMessageReactionAdd(e);
        AuthManager manager = new AuthManager(e.getUser());
        GuildJoin join = new GuildJoin();
        manager.authSuccess(join.returnGuild());
        e.getJDA().removeEventListener(new ReactAuthentication());
    }
}
