package com.Shogatsu.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.CommandInfo;


public class Debug extends Command {
    public Debug() {
        this.name = "debug";
        this.aliases = new String[] {"alias1", "alias2"};
        this.help = "Debug command for developers";
    }
    @Override
    protected void execute(CommandEvent event) {
        event.reply("You just used the debug command. Check console for errors");
    }
}
