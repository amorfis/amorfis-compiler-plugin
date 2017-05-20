package amorfis

import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.PluginComponent

class AmorfisPluginComponent(val name: String, val global: Global, val runAfter: String, val runBefore: List[String]) extends PluginComponent {

  override val phaseName: String = name
  override val runsAfter: List[String] = List(runAfter)
  override val runsBefore = runBefore

  override def newPhase(prev: Phase): Phase = new AmorfisPhase(prev)

  class AmorfisPhase(prev: Phase) extends StdPhase(prev) {

    override def name: String = AmorfisPluginComponent.this.name

    override def apply(unit: global.CompilationUnit): Unit = {
      println(s"I'm a phase from $name, running after $prev at ${System.currentTimeMillis()}")
      println(unit.source)
    }
  }

}
