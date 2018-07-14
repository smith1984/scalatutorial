
def multiply(s: String):Long = {
  var m: Long = 1
  for (ch <- s) {m = m*ch
    println(ch.toLong)}
  m
}

multiply("Hello")

