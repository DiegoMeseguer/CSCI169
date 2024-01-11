object HW5Meseguer extends App{

  // Problem 1
  def is_prime(x:Int):Boolean = {
    def remainder(x:Int, y:Int):Int = x % y
    def helper(test:Int):Boolean = {
      if(x == 0 || x == 1) false
      else if(test - 1 == 1) true
      else if (remainder(x, test - 1) == 0) false
      else helper(test - 1)
    }
    helper(x)
  }

  println("Test Problem 1")
  println(is_prime(0))  // false
  println(is_prime(1))  // false
  println(is_prime(2))  // true
  println(is_prime(3))  // true
  println(is_prime(4))  // false
  println(is_prime(10)) // false
  println(is_prime(17)) // true
  println(is_prime(23)) // true

  // Problem 2
  def add_third(x:Int):Int = {
    if (x < 1) 0
    else x + add_third(x - 3)
  }

  def add_second(x: Int): Int = {
    if (x < 1) 0
    else x + add_second(x - 2)
  }

  def add_fth(f:Int=>Int, x:Int):Int = {
    if (x < 1) 0
    else f(x)
  }

  println("Test Problem 2")
  println(add_fth(add_third, 10)) // 22
  println(add_fth(add_third, 13)) // 35
  println(add_fth(add_second, 10)) // 30
  println(add_fth(add_second, 12)) // 42

  // Problem 3
  println("Test Problem 3")

  def apply_combine(f:Int => Int, x:Int, g:(Int, Int) => Int):Int = {
    if (x == 1) f(x)
    else g(f(x), apply_combine(f, x - 1, g))
    //else g(f(x), combine(f(x-1), g))
    //else f(x) + combine(f(x-1), g)
  }

  def add(x: Int, y: Int): Int = x + y
  def square(x: Int): Int = x * x
  println(apply_combine(square, 4, add))  //30
  def mult(x: Int, y: Int): Int = x * y
  def identity(x: Int) = x
  println(apply_combine(identity, 4, mult)) //24

}

