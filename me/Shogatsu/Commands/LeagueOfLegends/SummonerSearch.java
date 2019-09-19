package me.Shogatsu.Commands.LeagueOfLegends;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;

@CommandInfo(
        name = "Find user",
        description = "Enter a region and find a summoner in that region by username"
)
public class SummonerSearch extends Command {
    public SummonerSearch() {
        this.name = "lolfind";
        this.aliases = new String[] {"finduser", "find", "search"};
        this.cooldown = 15;
    }
    @Override
    protected void execute(CommandEvent e) {
        /*
        if (!e.getAuthor().isFake() && !e.getAuthor().isBot()) {
            ApiConfig config = new ApiConfig().setKey();
            RiotApi api = new RiotApi(config);
            /*User types region then the username and split the string or something

            UKShogatsu
            UK = Region
            username = Shogatsu

            Only support for NA platform atm


            try {
                Summoner summoner = api.getSummonerByName(Platform.NA, e.getArgs());
                LeagueMenu leagueMenu = new LeagueMenu(e.getAuthor());
                e.reply(leagueMenu.LeagueDemo(summoner).build());
            } catch (RiotApiException exception) {
                exception.printStackTrace();
                ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
                e.reply(errorMenu.invalidLeagueAccount().build());
            }
        } else {
            ErrorMenu errorMenu = new ErrorMenu(e.getAuthor());
            e.reply(errorMenu.invalidAccount().build());
        }
        */
    }
}
