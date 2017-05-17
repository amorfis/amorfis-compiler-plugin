package amorfis

import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.PluginComponent

class AmorfisPluginComponent(val global: Global, val runAfter: String, val runBefore: String) extends PluginComponent {

  override val phaseName: String = "amorfis"
  override val runsAfter: List[String] = List(runAfter)
  override val runsBefore = List(runBefore)

  override def newPhase(prev: Phase): Phase = new AmorfisPhase(prev)

  class AmorfisPhase(prev: Phase) extends StdPhase(prev) {

    override def name: String = "amorfis"

    override def apply(unit: global.CompilationUnit): Unit = {
      println(s"I'm a phase, running after $prev")
      println(unit.source)
    }
  }

}
