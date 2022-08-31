class Book(var name: String, var isbn: ISBNumber) {
  def info() = println(s"$name, $isbn")
  override def toString :String =  s"$name, $isbn"
}
end Book

object Book{
  var Prefix: String = "-"
}