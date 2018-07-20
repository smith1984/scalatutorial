class Pair[T, S](val first: T, val second: S)

val p = new Pair(42, "String")
val p2 = new Pair[Any, Any](42, "String")

def getMiddle[T](a: Array[T]) = a(a.length / 2)

getMiddle(Array("Mary", "had", "a", "little", "lamb"))

class Pair1[T <: Comparable[T]](val first: T, val second: T) {
  def smaller = if (first.compareTo(second) < 0) first else second
}

val p1 = new Pair1("Fred", "Brooks")
println(p1.smaller)