// This class is not apart of the API.
// It is just an example of how to use the Config API
// It uses my CommandAPI (not my public one)
// This is not a part of the API and is not required to use the API

package lol.vifez.config.example;

import lol.vifez.config.chat.CC;
import lol.vifez.config.command.annotation.CommandAlias;
import lol.vifez.config.command.annotation.CommandPermission;
import lol.vifez.config.command.annotation.DefaultCommand;
import lol.vifez.config.command.annotation.Subcommand;
import lol.vifez.config.config.ConfigAPI;
import org.bukkit.command.CommandSender;

@CommandAlias("example")
@CommandPermission("example.permission")
public class ExampleCommand {

    private final ExampleConfig config;

    public ExampleCommand(ConfigAPI configAPI) {
        this.config = configAPI.fromFile("messages", ExampleConfig.class);
    }

    @DefaultCommand
    public void onDefault(CommandSender sender, String[] args) {
        sender.sendMessage(config.defaultMessage);
    }

    @Subcommand("greet")
    public void onGreet(CommandSender sender, String[] args) {
        String message = config.greetMessage.replace("{name}", sender.getName());
        sender.sendMessage(message);
    }
}