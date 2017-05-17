package amorfis

import scala.tools.nsc.{Global, Settings}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}
import scala.tools.nsc.reporters.Reporter

class AmorfisCompilerPlugin(val global: Global) extends Plugin {

  override val name: String = "amorfis"
  override val description: String = "My first compiler plugin"


  private val originalSettings = global.currentSettings.disable.value

  global.currentSettings.disable.appendToValue(name)

  // We need new Global instance, because when running phaseNames it registers the plugins,
  // and we don't want ours one to be really disabled
  private val phasesWithoutOurs = new Global(global.currentSettings, global.reporter).phaseNames

  global.currentSettings.disable.value = originalSettings

  override val components = for {
    phase <- phasesWithoutOurs
    if phase != "terminal"
  } yield new AmorfisPluginComponent(global, phase)

//  override val components = List(new AmorfisPluginComponent(global, "parser"))
}
