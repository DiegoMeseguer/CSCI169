object HW8P4Meseguer extends App{
  def negs(x:Int):Boolean = x<0
  def one(x:Int):Boolean = x==1
  def empty(x:Int) = false
  //What's the type of a set?  Int=>Boolean

  //Is 7 in negs?
  println(negs(7))
  def contains(set:Int=>Boolean, value:Int):Boolean = set(value)
  println(contains(negs, 7))//Makes our code more human readable;
  // does the same thing as directly calling the set function

  def complement(set:Int=>Boolean):Int=>Boolean = { //doing HOF with anon function instead of inner
    (x:Int) => {
      !(contains(set, x))
    }
  }

  def complement2(set: Int => Boolean): Int => Boolean = {
    def inner(x: Int) = !(contains(set, x))
    inner
  }

  //Is 7 in the complement of negs??
  println(complement(negs)(7))//complement(negs) is a function, we apply that function to 7
  println(contains(complement(negs), 7))

  def union(s1:Int=>Boolean, s2:Int=>Boolean):Int=>Boolean = {
    (x: Int) => {
      contains(s1, x) || contains(s2, x)
    }
  }

  def intersection(s1: Int => Boolean, s2: Int => Boolean): Int => Boolean = {
    (x: Int) => {
      contains(s1, x) && contains(s2, x)
    }
  }
  println("Start testing union and intersection")
  println(union(negs, one)(7))
  println(contains(union(negs, one), 7))
  println(contains(intersection(negs, one), 1))
  println(intersection(negs, one)(7))
  def difference(s1: Int => Boolean, s2: Int => Boolean): Int => Boolean = {
    intersection(s1, complement(s2))
    //(x:Int) => {
    // contains(s1, x) && !contains(s2, x)//also works
    //}
  }
  def singleton(value:Int):Int=>Boolean = { //Creates sets like one
    (x: Int) => {
      x == value //Need to bundle number value represents with function returned
    }
  }

  def eight = singleton(8)
  println(contains(singleton(8), 9))

  def setlist(xs:List[Int]):Int=>Boolean = {
    target => {
      if(xs.tail.isEmpty) contains(singleton(xs.head), target)
      else contains(singleton(xs.head), target) || setlist(xs.tail)(target) //contains(setlist(xs.tail), target)
    }
  }

  println("Test setlist function")
  val ls1 = 2::3::4::5::6::30::Nil
  println(contains(setlist(ls1), 2))
  println(contains(setlist(ls1), 30))
  println(contains(setlist(ls1), 6))
  println(contains(setlist(ls1), 1))

  def filter(s: Int=>Boolean, p:Int=>Boolean): Int=>Boolean = {
    elem => {
      contains(intersection(s, p), elem)
    }
  }
  println("Test filter function")
  def predicate(x:Int):Boolean = x % 2 == 0
  def some_pairs(x:Int):Boolean = (x == 4) || (x == 10) || (x == 20)

  println(contains(filter(some_pairs, predicate), 10)) // true
  println(contains(filter(some_pairs, predicate), 4))   // true
  println(contains(filter(some_pairs, predicate), 2)) // false

  def forall(set:Int=>Boolean, prd:Int=>Boolean):Boolean = {
    def helper(counter:Int):Boolean = {
      if (counter > 1000) true
      else if (set(counter) && !prd(counter)) false
      else helper(counter + 1)
    }
    helper(-1000)
  }

  def even_negs(x:Int):Boolean = (x < 0) && ((x%2)==0)
  println("Test forall function")
  println(forall(negs, predicate))  //false
  println(forall(even_negs, predicate)) //true

}

