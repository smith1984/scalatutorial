implicit def strToInt(x: String) = x.toInt
"123"
val y: Int = "123"
math.max("123", 111)
class Container[A <% Int] { def addIt(x: A) = 123 + x }
(new Container[String]).addIt("123")
(new Container[Int]).addIt(123)
//(new Container[Float]).addIt(123.2F)

class Container1[A](value: A) { def addIt(implicit evidence: A =:= Int) = 123 + value }
(new Container1(123)).addIt
//(new Container1("123")).addIt

//class Container2[A](value: A) { def addIt(implicit evidence: A <%< Int) = 123 + value }
//(new Container2("123")).addIt

List(1,2,3,4).min
List(1,2,3,4).min(new Ordering[Int] { def compare(a: Int, b: Int) = b compare a })
//def foo[A](implicit x: Ordered[A]) {}
def foo[A : Ordered] {}

trait Container2[M[_]] { def put[A](x: A): M[A]; def get[A](m: M[A]): A }
val container = new Container2[List] { def put[A](x: A) = List(x); def get[A](m: List[A]) = m.head }
container.put("hey")
container.put(123)

implicit val listContainer = new Container2[List] { def put[A](x: A) = List(x); def get[A](m: List[A]) = m.head }
implicit val optionContainer = new Container2[Some] { def put[A](x: A) = Some(x); def get[A](m: Some[A]) = m.get }

def tupleize[M[_]: Container2, A, B](fst: M[A], snd: M[B]) = {
  val c = implicitly[Container2[M]]
  c.put(c.get(fst), c.get(snd))
  }

tupleize(Some(1), Some(2))
tupleize(List(1), List(2))

trait Container3[A <: Container3[A]] extends Ordered[A]

class MyContainer extends Container3[MyContainer] {
  def compare(that: MyContainer) = 0
}
List(new MyContainer, new MyContainer, new MyContainer)
List(new MyContainer, new MyContainer, new MyContainer).min
class YourContainer extends Container3[YourContainer] { def compare(that: YourContainer) = 0 }
List(new MyContainer, new MyContainer, new MyContainer, new YourContainer)
//List(new MyContainer, new MyContainer, new MyContainer, new YourContainer).min

def foo(x: { def get: Int }) = 123 + x.get
foo(new { def get = 10 })
trait Foo { type A; val x: A; def getX: A = x }
(new Foo { type A = Int; val x = 123 }).getX

trait Foo1[M[_]] { type t[A] = M[A] }
val x: Foo1[List]#t[Int] = List(1)

class MakeFoo[A](implicit manifest: Manifest[A]) { def make: A = manifest.erasure.newInstance.asInstanceOf[A] }
(new MakeFoo[String]).make


