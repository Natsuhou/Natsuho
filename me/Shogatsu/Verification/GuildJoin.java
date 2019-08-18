package me.Shogatsu.Verification;

import me.Shogatsu.Managers.AuthManager;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildJoin extends ListenerAdapter {
    private Guild guild;
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        super.onGuildMemberJoin(e);
        this.guild = e.getGuild();
        AuthManager manager = new AuthManager(e.getUser());
        manager.messageAuth();
    }
    public Guild returnGuild() {
        return guild;
    }
}
