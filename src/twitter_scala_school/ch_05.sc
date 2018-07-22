2 :: 1 :: "bar" :: "foo" :: Nil

def drop1[A](l: List[A]) = l.tail
drop1(List(1,2,3))

def toList[A](a: A) = List(a)

def id[T](x: T) = x
val x = id(322)
val x1 = id("hey")
val x2 = id(Array(1,2,3,4))


class Covariant[+A]
val cv: Covariant[AnyRef] = new Covariant[String]
//val cv1: Covariant[String] = new Covariant[AnyRef]

class Contravariant[-A]
val cnv: Contravariant[String] = new Contravariant[AnyRef]

class Animal { val sound = "rustle" }
class Bird extends Animal { override val sound = "call" }
class Chicken extends Bird { override val sound = "cluck" }

val getTweet: (Bird => String) = ((a: Animal) => a.sound )
val hatch: (() => Bird) = (() => new Chicken )

def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)
biophony(Seq(new Chicken, new Bird))

class Node[+T](x: T) { def sub[U >: T](v: U): Node[U] = new Node(v) }
(new Node(new Bird)).sub(new Bird)
((new Node(new Bird)).sub(new Bird)).sub(new Animal)
((new Node(new Bird)).sub(new Bird)).asInstanceOf[Node[Chicken]]
(((new Node(new Bird)).sub(new Bird)).sub(new Animal)).sub(new Chicken)


def count(l: List[_]) = l.size
//def drop1(l: List[_]) = l.tail

def hashcodes(l: Seq[_ <: AnyRef]) = l map (_.hashCode)
//hashcodes(Seq(1,2,3))
hashcodes(Seq("one", "two", "three"))
