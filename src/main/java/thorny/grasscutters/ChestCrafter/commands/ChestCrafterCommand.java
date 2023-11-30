package thorny.grasscutters.ChestCrafter.commands;

import java.util.List;

import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.command.Command.TargetRequirement;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.scripts.SceneScriptManager;
import emu.grasscutter.scripts.data.SceneGadget;

// Command usage
@Command(label = "chest", aliases = "ch", usage = "[rare|gift|<chest id>] \n\nChest ids can be found in the GM Handbook under gadgets, they are typically SceneObj."
		+ " \n\nFair warning: Many chests do not yet have handlers and will not open!", targetRequirement = TargetRequirement.PLAYER)
public class ChestCrafterCommand implements CommandHandler {
	public int level;

	@Override
	public void execute(Player sender, Player targetPlayer, List<String> args) {
		var ssm = targetPlayer.getScene().getScriptManager();

		if (!(args.size() < 1)) {
			try {
				switch (args.get(0)) {
					case "gift" -> makeChest(targetPlayer, 70211163, ssm);
					case "rare" -> makeChest(targetPlayer, 70211011, ssm);
					default -> customChest(sender, targetPlayer, args, ssm);
				} // switch
			} catch (Exception e) {
				this.sendUsageMessage(sender);
				return;
			}
		} else
			this.sendUsageMessage(sender);
	}// execute

	private void customChest(Player sender, Player targetPlayer, List<String> args, SceneScriptManager ssm) {
		// User might put a gadget that isn't a chest, but don't bother checking now
		int customId = 0;
		try {
			// Check that it is an id
			customId = Integer.parseInt(args.get(0));
		} catch (Exception e) {
			CommandHandler.sendMessage(targetPlayer,
					"Invalid id! Please make sure you're putting either rare, gift, or a chest id from the GM Handbook.");
			return;
		}

		// User-specified chest
		makeChest(targetPlayer, customId, ssm);
	}

	private void makeChest(Player targetPlayer, int id, SceneScriptManager ssm) {
		SceneGadget customChest = new SceneGadget();
		customChest.gadget_id = id; // Chest id
		customChest.config_id = 64209;
		customChest.isOneoff = false; // Probably not needed
		customChest.level = 1;
		customChest.pos = targetPlayer.getPosition(); // Where player is standing
		customChest.rot = targetPlayer.getRotation(); // Where player is facing

		// Using same ids may eventually cause issues, but seems to work fine for now
		ssm.addEntity(ssm.createGadget(69420, 42069, customChest)); // Spawn chest
	}
} // setLevelCommand