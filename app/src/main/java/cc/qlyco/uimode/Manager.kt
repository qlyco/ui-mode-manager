package cc.qlyco.uimode

import android.content.res.Configuration
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin
import org.godotengine.godot.plugin.UsedByGodot

class Manager(godot: Godot) : GodotPlugin(godot) {
    override fun getPluginName(): String {
        return "UIModeManager"
    }

    @UsedByGodot
    private fun get_mode(): String {
        return when (godot.context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> "DARK_MODE"
            Configuration.UI_MODE_NIGHT_NO -> "LIGHT_MODE"
            Configuration.UI_MODE_NIGHT_UNDEFINED -> "UNDEFINED_MODE"
            else -> "UNKNOWN_MODE_ERROR"
        }
    }
}