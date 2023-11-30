package thorny.grasscutters.ChestCrafter;

import emu.grasscutter.plugin.Plugin;

public final class ChestCrafter extends Plugin {
    private static ChestCrafter instance;
    public static ChestCrafter getInstance() {
        return instance;
    }
    @Override public void onLoad() {
        // Set the plugin instance.
        instance = this;
    }
    @Override public void onEnable() {

        // Register commands.
        this.getHandle().registerCommand(new thorny.grasscutters.ChestCrafter.commands.ChestCrafterCommand());

        // Log a plugin status message.
        this.getLogger().info("The ChestCrafter plugin has been enabled.");
    }

    @Override public void onDisable() {
        // Log a plugin status message.
        this.getLogger().info("How could you do this to me... ChestCrafter has been disabled.");
    }
}