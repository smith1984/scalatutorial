package horstmann.ch_02
import scala.io._

object ReadConsole extends App {

  val name = StdIn.readLine("Your name: ")
  print("Your age: ")
  val age = StdIn.readInt()
  println(s"Hello, ${name}! Next year, you will be ${age + 1}.")

}
