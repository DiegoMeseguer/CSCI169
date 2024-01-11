object HW6Meseguer extends App {

  // 1st Problem
  def reduce(f:(Int,Int)=>Int,xs:List[Int]):Int = {
    if(xs.tail.isEmpty) xs.head
    else f(xs.head, reduce(f, xs.tail))
  }

  println("Test 1st problem")
  def ls = 7::2::5::1::Nil
  def ls2 = 4::0::10::3::Nil
  def add(x:Int, y:Int) = x+y
  def mult(x:Int, y:Int) = x*y
  println(reduce(add, ls))  // 15
  println(reduce(mult, ls)) // 70
  println(reduce(add, ls2)) // 17
  println(reduce(mult, ls2)) // 0

  // 2nd Problem
  def map_two(xs:List[Int], ys:List[Int], f:(Int,Int)=>Int):List[Int] = {
    if(xs.isEmpty || ys.isEmpty) Nil
    else f(xs.head, ys.head)::map_two(xs.tail, ys.tail, f)
  }
  println("Test 2nd problem")
  def ls3 = 10::20::30::100::400::500::Nil
  println(map_two(ls, ls2, (x,y)=>x+y))
  println(map_two(ls, ls3, (x,y)=>x+y))
  println(map_two(ls, ls2, (x,y)=>x*x+y))

  // 3rd Problem
  def reduce_curry(f:(Int, Int) => Int):List[Int]=>Int = {
    def inner(xs:List[Int]):Int = {
      if(xs.tail.isEmpty) xs.head
      else f(xs.head, inner(xs.tail))
    }
    inner
  }
  println("Test 3rd problem")
  def sum_list = reduce_curry((x,y) => x + y)
  def mult_list = reduce_curry((x, y) => x * y)
  println(sum_list(ls)) // 15
  println(mult_list(ls)) // 70
  println(sum_list(ls2)) // 17
  println(mult_list(ls2)) // 0

  // 4rd Problem
  def map_two_curry(f:(Int, Int) => Int): (List[Int], List[Int]) => List[Int] = {
    def inner(xs:List[Int], ys:List[Int]):List[Int] = {
      if(xs.isEmpty || ys.isEmpty) Nil
      else f(xs.head, ys.head)::inner(xs.tail, ys.tail)
    }
    inner
  }

  println("Test 4th problem")
  def sum_two_lists = map_two_curry((x, y) => x + y)
  def mult_two_lists = map_two_curry((x, y) => x * x + y)
  println(sum_two_lists(ls, ls2))
  println(sum_two_lists(ls, ls3))
  println(mult_two_lists(ls, ls2))

  // 5th Problem
  def map_two_curry_curry(f:(Int, Int)=>Int):List[Int] => (List[Int] => List[Int]) = {
    def inner_1(xs:List[Int], ys:List[Int]):List[Int] = {
      if(xs.isEmpty || ys.isEmpty) Nil
      else f(xs.head, ys.head)::inner_1(xs.tail, ys.tail)
    }
    def inner_2(xs: List[Int]):List[Int] => List[Int] = {
      def inner_3(ys:List[Int]): List[Int] = inner_1(xs, ys)
      inner_3
    }
    inner_2
  }

  def sum_list_factory = map_two_curry_curry((x, y) => x + y)
  def sum_one_list = sum_list_factory(ls)
  def mult_list_factory = map_two_curry_curry((x, y) => x * x + y)
  def mult_one_list = mult_list_factory(ls)

  println("Test 5th problem")
  println(sum_one_list(ls2))
  println(mult_one_list(ls3))



}









