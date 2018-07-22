def addUmm(x: String) = x + " umm"
def addAhem(x: String) = x + " ahem"
val ummThenAhem = addAhem _ compose addUmm _
ummThenAhem("well")
val ahemThenUmm = addAhem _ andThen addUmm _
ahemThenUmm("well")

