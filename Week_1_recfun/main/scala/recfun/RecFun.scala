package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {  
    if (c == 0 || c == r) 1  
    else pascal(c, r - 1) + pascal(c - 1, r - 1)  
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceRec(acc: Int, chars: List[Char]): Int = {
      if (chars.isEmpty || acc < 0)  acc
      else if (chars.head == '(') balanceRec(acc + 1, chars.tail)
      else if (chars.head == ')') balanceRec(acc - 1, chars.tail)
      else balanceRec(acc, chars.tail)
    }
    balanceRec(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {  
    if(money==0 ) 1  
    else if(coins.isEmpty || money < 0) 0  
    else countChange(money, coins.tail) + countChange(money-coins.head, coins)  
  }
