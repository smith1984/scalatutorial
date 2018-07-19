
object Test{
  def function(d: Double): Double = {
    d * d
  }
}

import scala.math._
val num = 3.14
val fun = ceil _

val fun2 = Test.function(_:Double)

val fun4 = (x:Double) => Test.function(x)

val fun3: (Double) => Double = Test.function(_)

fun(num)


Array(3.14, 1.42, 2.0).map(fun2)
Array(3.14, 1.42, 2.0).map(fun)

(x: Double) => 3 * x
val triple = (x: Double) => 3 * x
def triple(x: Double) = 3 * x

val triple1 = triple _

Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)
Array(3.14, 1.42, 2.0).map{ (x: Double) => 3 * x }
Array(3.14, 1.42, 2.0) map { (x: Double) => 3 * x }

def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

valueAtOneQuarter(ceil _)
valueAtOneQuarter(sqrt _)

def mulBy(factor : Double) = (x : Double) => factor * x

val quintuple = mulBy(5)
quintuple(20)

valueAtOneQuarter((x: Double) => 3 * x)
valueAtOneQuarter((x) => 3 * x)
valueAtOneQuarter(x => 3 * x)

valueAtOneQuarter(3 * _)

// val fun01 = 3 * _ // Ошибка: невозможно вывести тип
val fun02 = 3 * (_: Double) // OK
val fun03: (Double) => Double = 3 * _ // OK, потому что указан тип fun

(1 to 9).map(0.1 * _)

(1 to 9).map("*" * _).foreach(println _)

(1 to 9).filter(_ % 2 == 0)

(1 to 9).reduceLeft(_ * _)

"Mary had a little lamb".split(" ").sortWith(_.length < _.length)

val triple_ = mulBy(3)
val half = mulBy(0.5)
println(triple_(14) + " " + half(14)) // Выведет 42 7

def mul(x: Int, y: Int) = x * y

def mulOneAtATime(x: Int) = (y: Int) => x * y
mulOneAtATime(5)(7)

def mulOneAtATime1(x: Int) (y: Int) = x * y

val mulOneAtATime2 = (x: Int) => (y: Int) => x * y

def until(condition: => Boolean)(block: => Unit) {
  if (!condition) {
    block
    until(condition)(block)
  }
}

var x = 10
until (x == 0) {
  x -= 1
  println(x)
}

def indexOf(str: String, ch: Char): Int = {
  var i = 0
  until (i == str.length) {
    if (str(i) == ch) return i
    i += 1
  }
  return -1
}

