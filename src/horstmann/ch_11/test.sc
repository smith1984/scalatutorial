class Fraction(val n: Int,val d: Int) {

  def *(other: Fraction) = new Fraction(n * other.n, d * other.d)
}
object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)
  def unapply(input: Fraction) =
    if (input.d == 0) None else Some((input.n, input.d
    ))
}
val res = Fraction(3,4)*Fraction(5,6)
res.n
res.d

//var Fraction(a, b) = Fraction(3, 4) * Fraction(2, 5)

object Name {
  /*def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }*/

  def unapplySeq(input: String): Option[Seq[String]] =
    if (input.trim == "") None else Some(input.trim.split("\\s+"))
}

val author = "Cay Horstmann"
val Name(first, last) = author

import scala.language.dynamics
class DynamicProps(val props: java.util.Properties) extends Dynamic {
  def updateDynamic(name: String)(value: String) {
    props.setProperty(name.replaceAll("_", "."), value)
  }
  def selectDynamic(name: String) =
    props.getProperty(name.replaceAll("_", "."))

  def applyDynamicNamed(name: String)(args: (String, String)*) {
    if (name != "add") throw new IllegalArgumentException
    for ((k, v) <- args)
      props.setProperty(k.replaceAll("_", "."), v)
  }
}

val sysProps = new DynamicProps(System.getProperties)
sysProps.username = "Fred"
sysProps.add(username="Fred", password="Secret")
val home = sysProps.java_home