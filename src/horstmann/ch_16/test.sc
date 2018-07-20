import java.io.{FileInputStream, InputStreamReader}
import java.net.URL

import scala.xml._
import scala.xml.transform.{RewriteRule, RuleTransformer}

val doc = <html>
  <head>
    <title>Fred's Memoirs</title>
  </head> <body>
    <img alt="San Jose' State University Logo"
         src="http://www.sjsu.edu/publicaffairs/pics/sjsu_logo_color_web.jpg"/>
  </body>
</html>

val items = <li>Fred</li> <li>Wilma</li>

val elem = <a href="http://scala-lang.org">The
  <em>Scala</em>
  language</a>
val url = elem.attributes("href")

val elem1 = <a>The
  <em>Scala</em>
  language</a>

val url1 = elem1.attributes.get("href").getOrElse(Text(""))

val items1 = new NodeBuffer
items1 += <li>Fred</li>
items1 += <li>Wilma</li>
val nodes: NodeSeq = items

val image = <img alt="San Jose' State University Logo"
                 src="http://www.sjsu.edu/publicaffairs/pics/sjsu_logo_color_web.jpg"/>
val alt = image.attributes("alt").text

val map = image.attributes.asAttrMap

val code = """if (temp < 0) alert("Cold!")"""
val js = <script>
  {PCData(code)}
</script>

val n2 = Unparsed("<&>")

val g1 = <xml:group>
  <li>Item 1</li> <li>Item 2</li>
</xml:group>
val g2 = Group(Seq(<li>Item 1</li>, <li>Item 2</li>))

val items2 = <li>Item 1</li> <li>Item 2</li>
for (n <- <xml:group>
  {items2}
</xml:group>) yield n
// Вернет два элемента li
for (n <- <ol>
  {items2}
</ol>) yield n
// Вернет один элемент ol

val list =
  <dl>
    <dt>Java</dt> <dd>Gosling</dd> <dt>Scala</dt> <dd>Odersky</dd>
  </dl>
val languages = list \ "dt"

doc \ "body" \ "_" \ "li"

doc \ "head" \ "title"

doc \\ "title"


{image \ "@alt"}.text

for (n <- doc \\ "img") println(n \ "@src")


val list1 = <ul><li>Fred</li><li>Wilma</li></ul>
val list2 = list1.copy(label = "ol")

list1.copy(child = list1.child ++ <li>Another item</li>)

val image_ = <img src="hamster.jpg"/>
val image2_ = image_ % Attribute(null, "alt", "An image of a hamster", Null)

val image3 = image_ % Attribute(null, "alt", "An image of a frog",
  Attribute(null, "src", "frog.jpg", Null))

val rule1 = new RewriteRule {
  override def transform(n: Node) = n match {
    case e @ <title>{_*}</title> => e.asInstanceOf[Elem].copy(label = "ol")
    case _ => n
  }
}

val transformed = new RuleTransformer(rule1).transform(doc)

val root = XML.loadFile("./scalaprojects/scalatutorial/myfile.xml")
val root2 = XML.load(new FileInputStream("myfile.xml"))
val root3 = XML.load(new InputStreamReader(
  new FileInputStream("myfile.xml"), "UTF-8"))
val root4 = XML.load(new URL("http://horstmann.com/index.html"))

XML.save("./scalaprojects/scaltutorial/myfile2.xml", root4)