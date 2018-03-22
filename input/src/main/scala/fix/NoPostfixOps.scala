/*
rule = "class:fix.NoPostfixOps"
 */
package fix

object NoPostfixOps_Test {

  def foo(listOfStrings: List[String]): List[String] = listOfStrings map (_.toUpperCase)

  def foo(seq1: Seq[Int], seq2: Seq[Int]): Seq[(Int, Int)] = seq1 zip (seq2)

}
