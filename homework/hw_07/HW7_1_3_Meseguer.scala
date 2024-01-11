object HW7_1_3_Meseguer extends App {

  def ls = 7::2::5::1::Nil
  def ls2 = 4::0::10::3::Nil
  def ls3 = 30::900::144::Nil

  // 1st Problem
  def reduce_curry(f:(Int, Int)=>Int): List[Int] => Int = {
    xs => {
      if(xs.tail.isEmpty) xs.head
      else f(xs.head, reduce_curry(f)(xs.tail))
    }
  }

  println("Test anonymous reduce_curry")
  def sum_list = reduce_curry((x, y) => x + y)
  def mult_list = reduce_curry((x, y) => x * y)
  println(sum_list(ls)) // 15
  println(mult_list(ls)) // 70
  println(sum_list(ls2)) // 17
  println(mult_list(ls2)) // 0

  def map_two_curry(f:(Int,Int)=>Int):List[Int]=>(List[Int]=>List[Int]) = {
    xs =>
      (ys => {
      if (xs.isEmpty||ys.isEmpty) Nil
      else f(xs.head, ys.head)::map_two_curry(f)(xs.tail)(ys.tail)
    })
  }

  println("Test map_two_curry")
  def sum_list_factory = map_two_curry((x, y) => x + y)
  def sum_one_list = sum_list_factory(ls)
  def mult_list_factory = map_two_curry((x, y) => x * x + y)
  def mult_one_list = mult_list_factory(ls)
  println(sum_one_list(ls))
  println(mult_one_list(ls3))

  // 3rd Problem
  def find_last(xs:List[Int], target:Int):Int = {
    def inner(index:Int, lista:List[Int]):Int =
      lista match {
        case Nil => -1
        case head::tail =>
          def result = inner(index + 1, tail)
          if (result == -1 && (head != target)) -1
          else if (result != -1) result
          else index
      }
    inner(0, xs) match {
      case -1 => -1
      case idx => idx
    }
  }

  println("Test problem 3")
  def lista1 = List(3,5,3,10,22,3,20,108)
  println(find_last(lista1, 3)) // index = 5
  def lista2 = List(7,5,3,2)
  println(find_last(lista2, 7)) // index = 0
  def lista3 = List(32,343,300)
  println(find_last(lista3, 94)) // index = -1






}









