package amorfis

import scala.tools.nsc.Global
import scala.tools.nsc.plugins.{Plugin, PluginComponent}

class AmorfisCompilerPlugin(val global: Global) extends Plugin {

  override val name: String = "amorfis"
  override val description: String = "My first compiler plugin"

  override val components: List[PluginComponent] = List(new DataPluginComponent(global))
}
