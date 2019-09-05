package me.Shogatsu.LeagueOfLegends;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.rithms.riot.api.RiotApi;


public class LeagueDemo extends Command {
    public LeagueDemo() {
        this.name = "lold";
        this.aliases = new String[] {"loldemo"};
    }
    @Override
    protected void execute(CommandEvent e) {
        RiotApi apikey = new RiotApi();

    }
}
