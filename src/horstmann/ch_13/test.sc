import scala.collection.mutable.ArrayBuffer
import scala.io.Source

val coll = Seq(1, 1, 2, 3, 5, 8, 13)
val set = coll.toSet
val buffer = coll.to[ArrayBuffer]

Seq(1, 2, 3) == (1 to 3)

scala.collection.Map("Hello" -> 42)

val digits = List(4, 2)
9 :: List(4, 2)
9 :: digits

def sum(lst: List[Int]): Int =
  if (lst == Nil) 0 else lst.head + sum(lst.tail)

def sum2(lst: List[Int]): Int = lst match {
  case Nil => 0
  case h :: t => h + sum2(t) // h - это lst.head, t - это lst.tail
}

List(9, 4, 2).sum

val digits1 = Set(1, 7, 2, 9)
digits1 contains 0 // false
Set(1, 2) subsetOf digits1 // true

val primes = Set(2, 3, 5, 7)

digits1 union primes

digits1 & primes

digits1 -- primes

primes -- digits1

Vector(1, 2, 3) :+ 5

1 +: Vector(1, 2, 3)

val numbers1 = ArrayBuffer(1, 2, 3)
numbers1 += 5

var numbers = Set(1, 2, 3)
numbers += 5 // Присвоит переменной numbers новое неизменяемое множество
// numbers + 5
var numberVector = Vector(1, 2, 3)
numberVector :+= 5

Set(1, 2, 3) - 2

val names = List("Peter", "Paul", "Mary")
names.map(_.toUpperCase) // List("PETER", "PAUL", "MARY")
for (n <- names) yield n.toUpperCase

def ulcase(s: String) = Vector(s.toUpperCase(), s.toLowerCase())

names.map(ulcase)

names.flatMap(ulcase)

val buffer_ = ArrayBuffer("Peter", "Paul", "Mary")
buffer_.transform(_.toUpperCase)

names.foreach(println)

"-3+4".collect { case '+' => 1 ; case '-' => -1 }

List(1, 7, 2, 9).reduceLeft(_ - _)

List(1, 7, 2, 9).reduceRight(_ - _)

List(1, 7, 2, 9).foldLeft(0)(_ - _)

(0 /: List(1, 7, 2, 9))(_ - _)

val freq = scala.collection.mutable.Map[Char, Int]()
for (c <- "Mississippi") freq(c) = freq.getOrElse(c, 0) + 1
println(freq)

(Map[Char, Int]() /: "Mississippi") {
  (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
}

(1 to 10).scanLeft(0)(_ + _)

val prices = List(5.0, 20.0, 9.95)
val quantities = List(10, 2, 1)

prices zip quantities
(prices zip quantities) map { p => p._1 * p._2 }
((prices zip quantities) map { p => p._1 * p._2 }) sum

List(5.0, 20.0, 9.95) zip List(10, 2)
List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1)

"Scala".zipWithIndex
"Scala".zipWithIndex.max
"Scala".toUpperCase.zipWithIndex.max
"Scala".zipWithIndex.max._2

def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
val tenOrMore = numsFrom(10)
tenOrMore.tail.tail.tail
val squares = numsFrom(1).map(x => x * x)
squares.take(5).force

val words = Source.fromFile("/usr/share/dict/words").getLines.toStream
words // Stream(A, ?)
words(5) // Aachen
words // Stream(A, A's, AOL, AOL's, Aachen, ?)

val palindromicSquares = (1 to 1000000).view
  .map(x => x * x)
  .filter(x => x.toString == x.toString.reverse)

palindromicSquares.take(10).mkString(",")

import scala.collection.JavaConversions._
val props: scala.collection.mutable.Map[String, String] =
  System.getProperties()

for (i <- (0 until 100000).par) print(s" $i")

(for (i <- (0 until 100000).par) yield i) == (0 until 100000)