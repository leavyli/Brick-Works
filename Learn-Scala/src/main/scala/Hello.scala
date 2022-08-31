trait Expr

case class Var(name: String) extends Expr

case class Num(number: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

def simplifyTop(expr: Expr): Unit =
  expr match
    case BinOp("+", left, right) => println(s"$expr is a binary operation")
    case _ => println(" is not a binary operation")

def isIntIntMap(x: Any) =
  x match {
    case m: Map[Int, Int] => {
      println("Map[Int, Int]")
      true
    }
    case x @ n: Number => println(s"$x")
    case _ => false
  }


@main def hello() = {
  simplifyTop(BinOp("+", Num(1), Num(2)))
  simplifyTop(Var("x"))
  isIntIntMap(Map(1 -> 2))
  isIntIntMap(Map("d" -> 2))
  isIntIntMap(2)

  val light = Light()
  light.turnOn()

  val book = Book("The Lord of the Rings", ISBNumber("I-11234"))
  println(book)
  println(Book.Prefix)
  Book.Prefix = "="
  println(Book.Prefix)



}