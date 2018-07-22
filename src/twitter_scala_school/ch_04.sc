def addUmm(x: String) = x + " umm"
def addAhem(x: String) = x + " ahem"
val ummThenAhem = addAhem _ compose addUmm _
ummThenAhem("well")
val ahemThenUmm = addAhem _ andThen addUmm _
ahemThenUmm("well")

val one: PartialFunction[Int, String] = { case 1 => "one"}
one.isDefinedAt(1)
one.isDefinedAt(2)
one(1)
val two: PartialFunction[Int, String] = { case 2 => "two"}
val three: PartialFunction[Int, String] = { case 3 => "three" }
val wildcard: PartialFunction[Int, String] = { case _ => "something else" }
val partial = one orElse two orElse three orElse wildcard
partial(5)
partial(3)
partial(2)
partial(1)
partial(0)

case class PhoneExt(name: String, ext: Int)
val extensions = List(PhoneExt("steve", 100), PhoneExt("robey", 200))
extensions.filter { case PhoneExt(name, extension) => extension < 200 }

