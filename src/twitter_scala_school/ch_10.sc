val hello = new Thread(new Runnable {
  def run() {
    println("hello world")
  }
})
hello.start()

/*
import java.net.{Socket, ServerSocket}
import java.util.concurrent.{Executors, ExecutorService}
import java.util.Date

class NetworkService(port: Int, poolSize: Int) extends Runnable {
  val serverSocket = new ServerSocket(port)

  def run() {
    while (true) {
      // Здесь будет блокировка, пока не произойдет соединение.
      val socket = serverSocket.accept()
      //(new Handler(socket)).run()
      (new Thread(new Handler(socket))).start()
    }
  }
}

class Handler(socket: Socket) extends Runnable {
  def message = (Thread.currentThread.getName() + "\n").getBytes

  def run() {
    socket.getOutputStream.write(message)
    socket.getOutputStream.close()
  }
}

(new NetworkService(2020, 2)).run
*/

import java.net.{ServerSocket, Socket}
import java.util.concurrent._

class NetworkService(port: Int, poolSize: Int) extends Runnable {
  val serverSocket = new ServerSocket(port)
  val pool: ExecutorService = Executors.newFixedThreadPool(poolSize)

  def run() {
    try {
      while (true) {
        // This will block until a connection comes in.
        val socket = serverSocket.accept()
        pool.execute(new Handler(socket))
      }
    } finally {
      pool.shutdown()
    }
  }
}

class Handler(socket: Socket) extends Runnable {
  def message = (Thread.currentThread.getName() + "\n").getBytes

  def run() {
    socket.getOutputStream.write(message)
    socket.getOutputStream.close()
  }
}

//(new NetworkService(2020, 2)).run

class Person(var name: String) {
  def set(changedName: String) {
    this.synchronized {
      name = changedName
    }
  }
}

class Person1(@volatile var name: String) {
  def set(changedName: String) {
    name = changedName
  }
}

import java.util.concurrent.atomic.AtomicReference

class Person2(val name: AtomicReference[String]) {
  def set(changedName: String) {
    name.set(changedName)
  }
}

val doneSignal = new CountDownLatch(2)
//doAsyncWork(1)
//doAsyncWork(2)

doneSignal.await()
println("both workers finished!")