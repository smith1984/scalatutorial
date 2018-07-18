import scala.io.Source


var source = Source.fromFile("/home/ito/scalaprojects/scalatutorial/myfile.txt", "UTF-8")
val lineIterator = source.getLines()
for (l <- lineIterator) println(l)

source = Source.fromFile("/home/ito/scalaprojects/scalatutorial/myfile.txt", "UTF-8")
val lines = source.getLines.toArray
for (i <- lines.indices) println(lines(i))

source = Source.fromFile("/home/ito/scalaprojects/scalatutorial/myfile.txt", "UTF-8")
val linesBuff = source.getLines.toBuffer
for (lb <- linesBuff) println(lb)

source = Source.fromFile("/home/ito/scalaprojects/scalatutorial/myfile.txt", "UTF-8")
val contents = source.mkString

source = Source.fromFile("/home/ito/scalaprojects/scalatutorial/myfile.txt", "UTF-8")
for (c <- source) print(c)

/* преобразование строки в числа
val tokens = source.mkString.split("\\s+")
val numbers = for (w <- tokens) yield w.toDouble

val numbers1 = tokens.map(_.toDouble)
*/
source.close()

//print("How old are you? ")
//val age = scala.io.StdIn.readInt()

val source1 = Source.fromURL("http://horstmann.com", "UTF-8")
val source2 = Source.fromString("Hello, World!")
//val source3  = Source.stdin

import java.io._
val file = new File("/home/ito/scalaprojects/scalatutorial/myfile.txt")
val in = new FileInputStream(file)
val bytes = new Array[Byte](file.length.toInt)
in.read(bytes)
in.close()

val out = new PrintWriter("numbers.txt")
for (i <- 1 to 100) out.println(i)
out.close()