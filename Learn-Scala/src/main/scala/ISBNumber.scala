class ISBNumber(val isbn:String) extends AnyVal {
  def shortNumber = isbn.replace("I-", "")
}
