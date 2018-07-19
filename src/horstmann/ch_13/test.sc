import scala.collection.mutable.ArrayBuffer

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
