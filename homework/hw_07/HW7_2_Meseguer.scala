object HW7_2_Meseguer extends App{

println("Test the primary, string, and default constructor")
def ls = 4::5::6::Nil
val b1 = new Biguint("123")
val b2 = new Biguint(ls)
val b3 = new Biguint
println(b1.internalNum)
println(b1.num)
println(b2.internalNum)
println(b2.num)
println(b3.internalNum)
println(b3.num)

println("Test the sum function")
val b4 = new Biguint("123")
val b5 = new Biguint("275")
val suma1 = b4 + b5
println(suma1.num)  //  398
val b6 = new Biguint("1472")
val suma2 = b6 + b4
println(suma2.num)  // 1595
val b7 = new Biguint("9932")
val b8 = new Biguint("98")
val suma3 = b7 + b8
println(suma3.num)  // 10030
val b9 = new Biguint("99999")
val b10 = new Biguint("1")
val suma4 = b9 + b10
println(suma4.num)  // 100000

}

class Biguint(xs:List[Int]) {
  val internalNum = xs.reverse
  val num = xs

  def this(s:String) = this(
    {
      def convert(s:String):List[Int] = {
        if(s.isEmpty) Nil
        else convert(s.tail):::List((s.head-'0'))
      }
      convert(s).reverse
    })

  def this() = this(0::Nil)

  def +(ys:Biguint):Biguint = {
    def combine_sum(ls1:List[Int], ls2:List[Int], c:Int):List[Int] = {
      if(ls1.isEmpty && ls2.isEmpty) {
        if(c == 1) 1::combine_sum(Nil,Nil,0)
        else Nil
      }
      else {
        if(ls1.isEmpty) {
          if(carry(ls2.head, c)) (0)::combine_sum(Nil, ls2.tail, 1)
          else (ls2.head)::combine_sum(Nil, ls2.tail, 0)
        }
        else if(ls2.isEmpty) {
          if(carry(ls1.head, c)) (0)::combine_sum(ls1.tail, Nil, 1)
          else (ls1.head)::combine_sum(ls1.tail, Nil, 0)
        }
        else {
          val current_sum = ls1.head + ls2.head + c
          if(current_sum >= 10) (current_sum - 10)::combine_sum(ls1.tail, ls2.tail, 1)
          else (current_sum)::combine_sum(ls1.tail, ls2.tail, 0)
        }
      }
    }
    def carry(x:Int, y:Int):Boolean = if(x+y>=10) true else false
    val result = combine_sum(this.internalNum, ys.internalNum, 0).reverse
    new Biguint(result)
  }

//  def sum(ys: Biguint): Biguint = {
//    def combine_sum(ls1: List[Int], ls2: List[Int]): List[Int] = {
//      if (ls1.isEmpty && ls2.isEmpty) Nil
//      else {
//        if (ls1.isEmpty) (ls2.head) :: combine_sum(Nil, ls2.tail)
//        else if (ls2.isEmpty) (ls1.head) :: combine_sum(ls1.tail, Nil)
//        else (ls1.head + ls2.head) :: combine_sum(ls1.tail, ls2.tail)
//      }
//    }
//
//    def add_carry(x: Int, y: Int): Int = if (x + y >= 10) 1 else 0
//
//    val result = combine_sum(this.internalNum, ys.internalNum).reverse
//    new Biguint(result)
//  }

}














