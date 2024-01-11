object HW8P12Meseguer extends App{

  val l1 = 1::2::3::4::Nil
  val l2 = 7::8::9::10::11::12::Nil

  // Problem 1
  def alternating(xs:List[Int], ys:List[Int]):List[Int] = {
    (xs, ys) match {
      case (Nil, Nil) => Nil
      case (x::xtail, Nil) => x::alternating(xtail, Nil)
      case (Nil, y::ytail) => y::alternating(Nil, ytail)
      case (x::xtail, y::ytail) => x::y::alternating(xtail, ytail)
    }
  }

  println("Test problem 1")
  println(alternating(l1, l2))

  // Problem 2
  def reduce[T<:AnyRef](f:(T, T)=>T, xs:List[T]): T = {
    xs match {
      case x::Nil => x
      case x::xtail => f(x, reduce(f, xtail))
    }
  }

  println("Test problem 2")
  def ls = "h"::"e"::"l"::"l"::"o"::Nil
  def add(x: String, y: String) = x + y
  println(reduce(add, ls)) // hello

  
}


