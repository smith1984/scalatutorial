List(1, 2, 3)
1 :: 2 :: 3 :: Nil
Set(1, 1, 2)
Seq(1, 1, 2)
Map('a' -> 1, 'b' -> 2)
Map(1 -> 2).toArray
Map(("a", 2), ("b", 2))
IndexedSeq(1, 2, 3)
for (i <- 1 to 3) { println(i) }
(1 to 3).map { i => i }
Iterable(1, 2)
Seq(1, 2)
val numbers = collection.mutable.Map(1 -> 2)
numbers.get(1)
numbers.getOrElseUpdate(2, 3)
numbers
numbers += (4 -> 1)

import scala.collection.JavaConversions._
val sl = new scala.collection.mutable.ListBuffer[Int]
val jl : java.util.List[Int] = sl
val sl2 : scala.collection.mutable.Buffer[Int] = jl
assert(sl eq sl2)