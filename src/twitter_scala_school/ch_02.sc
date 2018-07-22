
class Foo {}

object FooMaker {
  def apply() = new Foo
}

class Bar {
  def apply() = 0
}

val bar = new Bar
bar()

object Timer {
  var count = 0

  def currentCount(): Long = {
    count += 1
    count
  }
}

Timer.count
Timer.currentCount()

class Bar_(foo: String)

object Bar_ {
  def apply(foo: String) = new Bar_(foo)
}

val bar_ = Bar_("smithyy")

/*
object  addOne extends Function1 [Int, Int]{
  def apply(v1: Int): Int = v1+ 1
}
*/
object addOne extends ((Int) => Int) {
  override def apply(v1: Int): Int = v1 + 1
}

addOne(3)

val plusOne = addOne(_)
plusOne(5)

val times = 1

times match {
  case 1 => "one"
  case 2 => "two"
  case _ => "some other number"
}

times match {
  case i if i == 1 => "one"
  case i if i == 2 => "two"
  case _ => "some other number"
}

def bigger(o: Any): Any = {
  o match {
    case i: Int if i < 0 => i - 1
    case i: Int => i + 1
    case d: Double if d < 0.0 => d - 0.1
    case d: Double => d + 0.1
    case text: String => text + "s"
  }
}

case class Calculator(brand: String, model: String) {
  def add(m: Int, n: Int): Int = m + n

}

val hp20b = Calculator("HP", "20b")
val hp20B = Calculator("HP", "20b")

hp20b == hp20B
hp20B.brand
hp20b.model
/*
def calcType(calc: Calculator) = calc match {
  case calc.brand == "HP" && calc.model == "20B" => "financial"
  case calc.brand == "HP" && calc.model == "48G" => "scientific"
  case calc.brand == "HP" && calc.model == "30B" => "business"
  case _ => "unknown"
}*/
def calcType(calc: Calculator) = calc match {
  case Calculator("HP", "20B") => "financial"
  case Calculator("HP", "48G") => "scientific"
  case Calculator("HP", "30B") => "business"
  case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
}

