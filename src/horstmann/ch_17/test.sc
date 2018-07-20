import java.time._

import scala.concurrent._
import ExecutionContext.Implicits.global
Future {
  Thread.sleep(10000)
  println(s"This is the future at ${LocalTime.now}")
}
println(s"This is the present at ${LocalTime.now}")

Future { for (i <- 1 to 100) { print("A"); Thread.sleep(10) } }
Future { for (i <- 1 to 100) { print("B"); Thread.sleep(10) } }

val f1 = Future {
  Thread.sleep(10000)
  42
}

val f2 = Future {
  if (LocalTime.now.getHour > 12)
    throw new Exception("too late")
  42
}

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._
val f3 = Future { Thread.sleep(10000); 42 }
//val result = Await.result(f3, 10.seconds)
Await.ready(f3, 10.seconds)
val Some(t) = f3.value



import scala.concurrent._
import scala.util._
import ExecutionContext.Implicits.global
val f = Future { Thread.sleep(10000)
  if (Random.nextDouble() < 0.5) throw new Exception
  42
}
f.onComplete {
  case Success(v) => println(s"The answer is $v")
  case Failure(ex) => println(ex.getMessage)
}
