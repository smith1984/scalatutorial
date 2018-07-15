val nums = new Array[Int](10)
var a = new Array[String](10)
val s = Array("Hello", "World")
s(0) = "GoodBye"

import scala.collection.mutable.ArrayBuffer
val b = ArrayBuffer[Int]()
b += 1
b += (1, 2, 3, 5)
b ++=Array(8, 13, 21)

b.trimEnd(5)
println(b)

b.insert(2, 6)
b.insert(2, 7, 8, 9)
println(b)

b.remove(2)
b.remove(2, 3)

println(b)

b.toArray

b.toBuffer

for (i <- a.length-1 until -1 by -1)
  println(s"$i: ${a(i)}")

for (i <- 0 until a.length)
  println(s"$i: ${a(i)}")

for (i <- a.indices)
  println(s"$i: ${a(i)}")

for (i <- a)
  println(i)

val c = Array(2, 3, 5, 6, 8, 7, -9, -11, 13, 15, 17, 19)
val result = for (elem <- c) yield 2 * elem
for (elem <- c if elem % 2 == 0) yield 2 * elem

c.filter(_ % 2 == 0).map(2 * _)
c.filter { _ % 2 == 0 } map { 2 * _ }

var d = c.toBuffer
var n = d.length
var i = 0
while (i < n) {
  if (d(i) >= 0) i += 1
  else {d.remove(i); n -= 1 }
}
println(d)

val result2 = for (elem <- c if elem >= 0) yield elem
val positionsToRemove = for (i <- c.indices if c(i) < 0) yield i
d = c.toBuffer
for (i <- positionsToRemove.reverse) d.remove(i)
println(d)

d = c.toBuffer
val positionsToKeep = for (i <- d.indices if d(i) >= 0) yield i
for (j <- positionsToKeep.indices) d(j) = d(positionsToKeep(j))
d.trimEnd(d.length - positionsToKeep.length)

Array(1, 7, 2, 9).sum
ArrayBuffer("Mary", "had", "a", "little", "lamb").max
val e = ArrayBuffer(1, 7, 2, 9)
val eSorted = e.sorted.reverse
println(eSorted)
println(e.sortWith(_<_))

val a1 = Array(1, 7, 2, 9)
scala.util.Sorting.quickSort(a1)

a1.mkString(" and ")

a1.mkString("<", ",", ">")

val matrix = Array.ofDim[Double](3, 4)

val triangle = new Array[Array[Int]](10)
for (i <- triangle.indices)
  triangle(i) = new Array[Int](i + 1)

import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.mutable.ArrayBuffer
val command = ArrayBuffer("ls", "-al", "/home/cay")
val pb = new ProcessBuilder(command)

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
val cmd : Buffer[String] = pb.command()

val n1 = 15
val a2 = new Array[Int](n1)
for (i <- 0 until n1) {
  println(i)
  a2(i) = i }

val a3 = Array(1, -5, 0, 4, -3, 0, 0, 2, 3, 4, 5)
val a4 = a3.toBuffer

(for (i <- 0 until(a3.length) if a3(i) > 0) yield a3(i)).toBuffer ++= (for (i <- 0 until(a3.length) if a3(i) <= 0) yield a3(i)).toBuffer
for (i <- 0 until(a3.length) if i % 2 != 0) {
  val tmp = a3(i)
a3(i) = a3(i-1)
a3(i-1) = tmp}

for (e <- a3) println(e)


val posNegative = (for (i <- 0 until(a4.length) if a4(i) < 0) yield i).reverse
for (j <- 0 until(posNegative.length -1)) a4.remove(posNegative(j))
println(a4)

a3.toSet.toArray

val timezone : Array[String] = (java.util.TimeZone.getAvailableIDs).filter(_.contains("America/")).flatMap(_.split("/")).filter(!_.contains("America")).toSet.toArray.sorted

for (e <- timezone) println(e)