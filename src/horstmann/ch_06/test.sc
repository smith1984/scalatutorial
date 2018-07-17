

object Accounts {
  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber += 1; lastNumber }
}

Accounts.newUniqueNumber()
Accounts.newUniqueNumber()
Accounts.newUniqueNumber()

class Account private (val id: Int, initialBalance: Double) {
  private var balance = initialBalance
}

object Account {
  private var lastNumber = 0
  def apply(initialBalance: Double) =
    new Account(newUniqueNumber(), initialBalance)
  private def newUniqueNumber() = { lastNumber += 1; lastNumber }
}

val acct = Account(1000.0)

abstract class UndoableAction(val description: String) {
  def undo(): Unit
  def redo(): Unit
}

object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo() {}
  override def redo() {}
}

val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)

object Hello {
  def main(args: Array[String]) {
    println("Hello, World!")
  }
}

object Hello2 extends App {
  println("Hello, World!")
}

object Hello3 extends App {
  if (args.length > 0)
    println("Hello, " + args(0))
  else
    println("Hello, World!")
}

object TrafficLightColor extends Enumeration {
  val Red, Yellow, Green = Value
}