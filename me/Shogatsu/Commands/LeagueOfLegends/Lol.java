package me.Shogatsu.Commands.LeagueOfLegends;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.GameMode;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.LeagueMenu;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

@CommandInfo(
        name = "Get summoner info",
        description = "Gets league info like rank, level, etc displayed in embed"
)
public class Lol extends Command {
    public Lol() {
        this.name = "ss";
        this.help = "Shows league stats";
    }
    @Override
    protected void execute(CommandEvent e) {
        if (!e.getAuthor().isBot() && !e.getAuthor().isFake()) {
            Orianna.setRiotAPIKey("RGAPI-8b5c0532-4306-423d-984a-c16e9b9eb5ad");
            final Summoner summoner = Summoner.named(e.getArgs()).withRegion(Region.NORTH_AMERICA).get();
            LeagueMenu leagueMenu = new LeagueMenu(e.getAuthor());
            e.reply(leagueMenu.OriannaMenu(summoner).build());
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidAccount().build());
        }
    }
}
