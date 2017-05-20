package amorfis

import scala.tools.nsc.{Global, Settings}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}
import scala.tools.nsc.reporters.Reporter

class AmorfisCompilerPlugin(val global: Global) extends Plugin {

  override val name: String = "amorfis"
  override val description: String = "My first compiler plugin"


//  private val originalSettings = global.currentSettings.disable.value

//  global.currentSettings.disable.appendToValue(name)

  // We need new Global instance, because when running phaseNames it registers the plugins,
  // and we don't want ours one to be really disabled
//  private val tmpGlobal = new Global(global.currentSettings, global.reporter)
//  private val phaseNames = tmpGlobal.phaseNames
//  private val descriptors = tmpGlobal.phaseDescriptors
//  global.currentSettings.disable.value = originalSettings

//  println(s"Phases names: $phaseNames")

//  for(d <- descriptors) {
//    println(s"Phase descriptor: ${d.phaseName}")
//    println(s"Runs before: ${d.runsBefore}")
//    println(s"Runs after: ${d.runsAfter}")
//    println(s"Runs right after: ${d.runsRightAfter}")
//  }


  override val components = List(
    new AmorfisPluginComponent("1", global, "parser", List()),
    new AmorfisPluginComponent("2", global, "typer", List())
  )
}
