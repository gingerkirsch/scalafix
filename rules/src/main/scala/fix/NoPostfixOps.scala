package fix

import scalafix._
import scala.meta._

final case class NoPostfixOps(index: SemanticdbIndex)
  extends SemanticRule(index, "NoPostfixOps") {

  override def fix(ctx: RuleCtx): Patch =  {
    ctx.tree.collect{
      case term: Term.ApplyInfix =>
        val newTree = Term.Apply(Term.Select(term.lhs, term.op), term.args)
        ctx.replaceTree(term, newTree.syntax)
    }.asPatch
  }

}
