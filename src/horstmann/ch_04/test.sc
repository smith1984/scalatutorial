//val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

// val scores = new scala.collection.mutable.HashMap[String, Int]

//val bobsScore = scores("Bob")
//val bobsScore = if (scores.contains("Bob")) scores("Bob") else 0

val bobsScore = scores.getOrElse("Bob", 0)

val scores1 = scores.withDefaultValue(0)
val zeldasScore1 = scores1.get("Zelda")

val scores2 = scores.withDefault(_.length)
val zeldasScore2 = scores2.get("Zelda")

scores.put("Fred", 7)
scores.put("Bob", 10)
scores += ("Mick" -> 15)

println(scores)

scores += ("Bob" -> 11, "Fred" -> 17)
scores -= "Alice"

println(scores)

val newScores = scores + ("Bob" -> 10, "Fred" -> 7)
scores += ("Alice" -> 9)

scores.keySet
for (v <- scores.values) println(v)

for ((k, v) <- scores) yield (v, k)

val scoresTree = scala.collection.immutable.SortedMap("Alice" -> 10,
  "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)

val months = scala.collection.mutable.LinkedHashMap("January" -> 1,
  "February" -> 2, "March" -> 3, "April" -> 4, "May" -> 5)

import scala.collection.JavaConversions.mapAsScalaMap

val scoresJava: scala.collection.mutable.Map[String, Int] =
  new java.util.TreeMap[String, Int]

import scala.collection.JavaConversions.propertiesAsScalaMap

val props: scala.collection.Map[String, String] = System.getProperties()

import scala.collection.JavaConversions.mapAsJavaMap
import java.awt.font.TextAttribute._
val attrs = Map(FAMILY -> "Serif", SIZE -> 12)
val font = new java.awt.Font(attrs)

val t = (1, 3.14, "Fred")
val second = t._2

val (first2, second2, third2) = t
val (first3, second3, _) = t

"New York".partition(_.isUpper)

val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)
for ((s, n) <- pairs) Console.print(s * n)