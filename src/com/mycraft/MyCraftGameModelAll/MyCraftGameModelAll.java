package com.mycraft.MyCraftGameModelAll;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MyCraftGameModelAll extends JavaPlugin {
	// -------- Bukkit related
	@Override
	public void onEnable() { // load MySQL
		initCommands();
		super.onEnable();
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		switch (cmd.getName()) {
		case "MyCraftGameModelAll":
			if (args.length != 1) {
				sender.sendMessage("args.length!=1");
				return false;
			}
			gamemodeAll(Integer.parseInt(args[0]));
			break;
		default:
			return false;
		}
		return true;
	}

	// -------- private methods | initialization
	private void initCommands() {
		this.getCommand("MyCraftGameModelAll").setExecutor(this);
	}

	// -------- private detail methods | response to commands
	private void gamemodeAll(int g) {
		GameMode gameMode;
		switch (g) {
		case 0:
			gameMode = GameMode.SURVIVAL;
			break;
		case 1:
			gameMode = GameMode.CREATIVE;
			break;
		case 2:
			gameMode = GameMode.ADVENTURE;
			break;
		case 3:
			gameMode = GameMode.SPECTATOR;
			break;
		default:
			gameMode = null;
			break;
		}
		for (Player p : getServer().getOnlinePlayers()) {
			p.setGameMode(gameMode);
		}
	}

}