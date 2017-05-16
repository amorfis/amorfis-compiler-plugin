package amorfis

import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.PluginComponent

class AmorfisPluginComponent(val global: Global) extends PluginComponent {

  override val phaseName: String = "amorfis"
  override val runsAfter: List[String] = List("parser")


  override def newPhase(prev: Phase): Phase = new AmorfisPhase(prev)

  class AmorfisPhase(prev: Phase) extends StdPhase(prev) {

    override def name: String = "amorfis"

    override def apply(unit: global.CompilationUnit): Unit = global.reporter.error(unit.position(0), "not implemented yet")
  }

}
