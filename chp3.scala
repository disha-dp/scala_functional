EXERCISE 2: Implement the function tail for "removing" the first element of a List. Notice the function takes constant time. What are different choices you could make in your implementation if the List is Nil? We will return to this question in the next chapter.


def tail(l:List[Int]):List[Int] = l match {
  case Nil => Nil
  case x::xs => xs
}


EXERCISE 3: Generalize tail to the function drop, which removes the first n elements from a list.

def drop(l:List[Int], n:Int):List[Int] = n match{
	case n if n<=0 => l
	case n if n>0 => drop(tail(l),n-1)
}


EXERCISE 4: Implement dropWhile, which removes elements from the List prefix as long as they match a predicate. Again, notice these functions take time proportional only to the number of elements being dropped—we do not need to make a copy of the entire List.

def dropWhile(l:List[Int])(f: Int => Boolean): List[Int] = l match {
	case Nil => Nil
	case x::xs if(f(x)) =>  dropWhile(xs)(f) 
	case _ => l
}


 EXERCISE 5: Using the same idea, implement the function setHead for replacing the first element of a List with a different value.

def setHead(l: List[Int], nval:Int) = l match{
	case Nil => Nil 
	case x::xs => nval::xs
} 


 EXERCISE 6: Not everything works out so nicely. Implement a function, init, which returns a List consisting of all but the last element of a List. So, given List(1,2,3,4), init will return List(1,2,3). Why can't this function be implemented in constant time like tail?

def init[A](l: List[A]): List[A] = l match{
 case Nil => Nil  
 case x::Nil=>  Nil
 case x::xs => x::init(xs)
}


