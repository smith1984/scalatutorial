val numbers = List(1,2,3,4,5,6,7,8,9,10)
Set (1,1,2)
val hostPort = ("localhost", 80)
hostPort._1
hostPort._2

1-> 2

Map(1 -> 2)
Map("foo" -> "bar")

def timesTwo(i: Int): Int = {
  println("hello world")
  i * 2
}

Map(1 -> Map("foo" -> "bar"))
Map("timesTwo" -> { timesTwo(_) })

val numbers_ = Map("one" -> 1, "two" -> 2)
numbers_.get("two")
numbers_.get("three")

val result = if (numbers_.get("three").isDefined) { numbers_.get("three").get * 2 } else { 0 }
val result_ = numbers_.get("three").getOrElse(0)*2
val result_2 = numbers_.get("three") match { case Some(n) => n * 2 case None => 0 }

numbers.map((i: Int) => i * 2)
def timesTwo_(i: Int): Int = i * 2
numbers.map(timesTwo_(_))
numbers.foreach((i: Int) => i * 2)

numbers.filter((i: Int) => i % 2 == 0)
def isEven(i: Int): Boolean = i % 2 == 0
numbers.filter(isEven _)

List(1, 2, 3).zip(List("a", "b", "c"))
List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).partition(_ % 2 == 0)

numbers.find((i: Int) => i > 6).getOrElse(0)

numbers.drop(5)
numbers.dropWhile(_ % 2 != 0)

numbers.foldLeft(0)((m: Int, n: Int) => m + n)
numbers.foldLeft(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }
numbers.foldRight(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }

List(List(1, 2), List(3, 4)).flatten

val nestedNumbers = List(List(1, 2), List(3, 4))
nestedNumbers.flatMap(x => x.map(_ * 2))
nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten

def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
  numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
    fn(x) :: xs
  }
}

ourMap(numbers, timesTwo_(_))

val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)
extensions.filter((namePhone: (String, Int)) => namePhone._2 < 200)

extensions.filter({case (name, extension) => extension < 200})
