class Counter {
  private var value = 0
  def increment() { value += 1 }
  def current() = value
}

val myCounter = new Counter // Или new Counter()
myCounter.increment()
println(myCounter.current)

class Person {
  //var age = 0
  private var privateAge = 0 // Сделать приватным и переименовать
  def age = privateAge
  def age_=(newValue: Int) {
    if (newValue > privateAge) privateAge = newValue;
    // Нельзя сделать моложе
  }
}

val fred = new Person
println(fred.age)

fred.age = 21

fred.age = 10

class Counter2 {
  private var value = 0
  def increment() { value += 1 }
  def isLess(other : Counter2) = value < other.value
  // имеет доступ к приватному полю другого объекта
}