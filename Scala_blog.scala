// Databricks notebook source
//1 Scalculator

1 +2 

// COMMAND ----------

//2 Operators are methods

(1).+(2)

// COMMAND ----------

//3 Variables
var x= 1 + 2 
println(x)

// COMMAND ----------

//4 Final Variables
val x = 3 * 4
println(x)

// COMMAND ----------

//5 Printing values
println("Hello World!!")

// COMMAND ----------

//6 String interpolation
import scala.math._
val tau = Pi * 2
println(s"Happy $tau Day")

// COMMAND ----------

//7 String formatting
printf("Now you have %.16f problems.", Math.nextAfter(2.0, 3))

// COMMAND ----------

//8 Useful operations
//Number operations

val range = 1 to 10
val range1 = 1 until 10
val range2 = 1 until 10 by 3

println(range2.toList)

// COMMAND ----------

//8 
//Number convinience methods 

val num = -5
val absNum = num.abs
val max5or7 = absNum.max(7)
val min5or7 = absNum.min(7)
println(absNum)
println(max5or7)
println(min5or7)

// COMMAND ----------

//8 
//String operations

val reverse = "Scala".reverse
println(reverse)

val cap = "scala".capitalize
println(cap)

val multi = "Scala!" * 7
println(multi)

val int = "123".toInt
println(int)



// COMMAND ----------

//8  Useful methods on collections

val morethan4 = range.filter(_ >4)
println(morethan4)

val doubleIt = range1.map( x=> x* x)
println(doubleIt)


// COMMAND ----------

//9 Method Definition

def mult(x:Int, y:Int) :Int = {
  return x * y
}

println(mult(40,15))

// COMMAND ----------

//10 Method definition 2

def add(x:Int, y:Int) = {
   x + y
}

println(add(154,160))


// COMMAND ----------

//11 Method definition 3

def add(x:Int, y:Int) = x+y

println(add(140,890))

// COMMAND ----------

//12 Anonymous Functions
def doWithOneAndTwo(f: (Int, Int) => Int) = {  
  f(1, 2)  
}  


//Explicit type declaration  
val call1 = doWithOneAndTwo((x: Int, y: Int) => x + y)

//The compiler expects 2 ints so x and y types are inferred  
val call2 = doWithOneAndTwo((x, y) => x + y)  

//Even more concise syntax  
val call3 = doWithOneAndTwo(_ + _)  

println(call1, call2, call3)  

// COMMAND ----------

//13 Anonymous Functions 2

//method
def add1(x:Int, y:Int) = x + y  

  //anonymous function 
  val add2 = (x:Int, y:Int) => x + y  

   //alternate way 
  val add3:(Int,Int)=>Int = _ + _  

  //alternate way, rare 
  val add4 = (_ + _):(Int,Int)=>Int   
    
println(add1(42,13))  
println(add2(42,13))  
println(add3(42,13))  
println(add4(42,13)) 

// COMMAND ----------

//14  Return multiple variables

def swap(x:String, y:String) = (y, x)
val (a,b) = swap("hello","world")
println(a, b)

// COMMAND ----------

//15 Declare multiple variables

var x, y, z = 0
var c, python, java = false

// COMMAND ----------

//16 Assign multiple variables

var (x, y, z, c, python, java) = (1, 2, 3, true, false, "no!")
println(x, y, z, c, python, java)

// COMMAND ----------

//17 Loops using while

var i, sum = 0  
while ( i < 10) {  
  sum += i  
  i+=1  
}  
println(sum)

// COMMAND ----------

//18 Loops using for

var sum = 0
for(i<- 0 until 10){
  sum = sum + i
}
println(sum)

// COMMAND ----------

//19 Loops without loops

(0 until 10).sum

// COMMAND ----------

//20 IF

if (true)   
  println("no braces on a single expression")

if (1 + 1 == 2) {  
  println("multiple")  
  println("statements")  
  println("require")  
  println("braces")  
} else {  
  println("new math is found!")  
  println("or your CPU went crazy")  
}  

val likeEggs = false  
val breakfast =  
  if (likeEggs) "scrambled eggs"  
  else "Apple"  

println(breakfast)

// COMMAND ----------

//21  Match as a Switch

val choice = "Four"
choice match{
  case "One" => println("You selected Option1")
  case "Two" => println("You selected Option2")
  case "Three" => println("You selected Option3")
  case "Four" => println("You selected Option4")
  case _ => println("Invalid Choice selected!")
}

// COMMAND ----------

//22 Arrays

def printArray[K](array:Array[K]) = array.mkString("(", ", ", ")")

// COMMAND ----------

val array1 = Array(1, 2, 3)
printArray(array1)



// COMMAND ----------

val array2 = Array("a", 2, true)
printArray(array2)

// COMMAND ----------

val array3 = Array("a", "b", "c")

// COMMAND ----------

printArray(array3)

// COMMAND ----------

val itemAtIndex0 = array3(1)

// COMMAND ----------

array3(0) = "d"
printArray(array3)

// COMMAND ----------

val concat = "prepend" +: (array1 ++ array2 ++ array3) :+ "append"
printArray(concat)

// COMMAND ----------

array3.indexOf("c")

// COMMAND ----------

val diffarray = Array(1,2,3,4,5,6).diff(Array(3,4,5))
printArray(diffarray)

// COMMAND ----------

val personArray = Array(("Alice",1), ("Bob",2), ("Carol",3))
def findByName(name:String) = personArray.find(_._1 == name).getOrElse(("David",4))

// COMMAND ----------

val findBob = findByName("Bob")

// COMMAND ----------

val findEli = findByName("Eli")

// COMMAND ----------

val bobFound = findBob._2

// COMMAND ----------

val eliFound = findEli._2

// COMMAND ----------

// 23 Lists

val list1 = List(1,2,3)
var list2 = List("a",2,true)
val firslListItem = list1(1)


// COMMAND ----------

list1 ::: list2

// COMMAND ----------

"prepend" +: list1

// COMMAND ----------

list1 :+ "append"

// COMMAND ----------

val concatenated = 1 :: list1 ++ list2  :+ "d"

// COMMAND ----------

val difflist =List(2,3,4,5,6) diff List(4,5)

// COMMAND ----------

val animalList = List(("Tiger",1),("Lion",2),("Elephant",3),("Giraffe",4))

def findByName(animal:String) = animalList.find(_._1 == animal).getOrElse(("Animal not in List",0))

val findLion= findByName("Lion")
val findYak = findByName("Yak")

// COMMAND ----------

findLion._2

// COMMAND ----------

findYak._2

// COMMAND ----------

// 24 Sets

val set1= Set(1,2,3,4)
val set2= Set("mango",45,false)
val oneExists = set1(1)
val fourExists = set2("a")


println(Set(1,3,2,4,5,6,5,5,4,5,8))


// COMMAND ----------

import collection.mutable

val mset = mutable.HashSet("a","b","c","e","z")

mset("a") = false
mset -="z"
println(mset)

// COMMAND ----------

val concat = set1 ++ set2 ++ mset

// COMMAND ----------

mset +="n"
mset ++= Set("j","k")

// COMMAND ----------

val diffSet = Set(7,8,4,5) diff Set(5,3,7,9)

// COMMAND ----------

val birdSet = Set(("Pigeon",1),("Peacock",2),("Dove",3),("Eagle",4))

def findSetByName (bird:String) = birdSet.find(_._1 == bird).getOrElse(("Bird Not in List",0))

// COMMAND ----------

val foundPeacock = findSetByName("Peacock")
val notFoundBird = findSetByName("hawk")

// COMMAND ----------

println(foundPeacock._2)
println(notFoundBird._2)

// COMMAND ----------

// 25  Maps

val map1 = Map("one" -> 1, "two" ->2, "three" -> 3)
val map2 = Map(true -> "simple","mix" -> 4,5 -> "name")

// COMMAND ----------

import collection.mutable

val mmap = mutable.HashMap(("a" -> 1), ("b" -> 2),("c" -> 3),("d" -> 4))



// COMMAND ----------

println(Map("a" -> 1,"a" -> 2))

// COMMAND ----------

val one = map1("one")

// COMMAND ----------

val fourExistsOption = map1.get("four")
println(fourExistsOption.isDefined)

// COMMAND ----------

mmap("e") = 5
println(mmap)

// COMMAND ----------

val concatmap = map1 ++ map2 ++ mmap
println(concatmap)

// COMMAND ----------

mmap -= "c"

// COMMAND ----------

mmap += "f" -> 6

// COMMAND ----------

mmap ++= Map("g" -> 7,"h"-> 8)

// COMMAND ----------

val carMap = Map(("Ferrari" -> 1),("Volkswagen" -> 2),("Porsche" -> 3),("Ford") -> 4)

def FindCarMap (car:String) = carMap.getOrElse("Car not in options", 99)

// COMMAND ----------

val findPorsche = FindCarMap("Ferrari")

// COMMAND ----------

val carNotFound = FindCarMap("Chevrolet")

// COMMAND ----------

println(findPorsche)

// COMMAND ----------

println(carNotFound)

// COMMAND ----------

// 26 Mutable Collections

import collection.mutable

val arrayBuffer = mutable.ArrayBuffer(1,2,3)
val listBuffer = mutable.ListBuffer("mango", "apple", "orange")

val hashSet = mutable.Set(81.4,25.6,31.0)
val hashmap = mutable.Map("Africa" ->1, "North America"->2)


// COMMAND ----------

// 27 Mutable Collections Operations

import collection.mutable

val arrayBuffer= mutable.ArrayBuffer(4,5,6)
val listBuffer = mutable.ListBuffer("summer","winter","autumn")
val hashmap = mutable.Map(("Austria"-> 1),("Germany")-> 2,("Italy")-> 3)

// COMMAND ----------

arrayBuffer += 1
listBuffer -= "winter"
hashmap += "USA" -> 4

// COMMAND ----------

arrayBuffer ++= List(1,2,8)
hashmap ++= Map("Canada" -> 5,"Japan" -> 7)
hashmap --= Set("Italy","Austria")

// COMMAND ----------

import collection.mutable

var immutableSet = Set(1,2,3)

// COMMAND ----------

immutableSet += 4

// COMMAND ----------

val mutableSet = mutable.Set(1,2,3)



// COMMAND ----------

mutableSet += 4

// COMMAND ----------

println(immutableSet,mutableSet)

// COMMAND ----------

// 29 Classes

class person(fname:String, mname:String, lname:String)
val person1 = new person("Paul","M","Schaeffer")

// COMMAND ----------

class address(street:String, city:String, state:String){
  def stay = " You stay at $string $city $state !"
}
val add1 = new address("50 Jefferson Avenue","Jersey City","NJ")
println(add1.stay)

// COMMAND ----------

class address(fname:String, lname:String, street:String, city:String, state:String){
  val name1 = s"$fname $lname"
  val address1 = s"$street $city $state"
  def stay = s"Hi! $name1 You stay at $address1 !"
}

val r1 = new address("Bradley","Cooper","47 Park Avenue","New York","NY")
println(r1.stay)


// COMMAND ----------

class Person4(val fname:String, var lname:String)
val p4 = new Person4("Dave", "Matthews") {  
     
  override def toString = s"$fname $lname"   
}  
println(p4.fname)  
println(p4.lname)  

// COMMAND ----------

p4.lname = "Chapelle"
println(p4)

// COMMAND ----------

class JPerson() {  
  var _name: String = null  
  def this(_name:String) = {  
     this()
         this._name = _name  
  }  
    
  def name_=(_name:String) = this._name = _name  
  def name = this._name  
    
   
  def getName() = name  
  def setName(name:String) = this.name = name  
}  

   
import beans._  
class SPerson(@BeanProperty var name:String)  


val jp = new JPerson("Java Style")  
val sp = new SPerson("Scala Style")  

println(jp.name)  
println(sp.name)  

jp.name += " sucks!"  
sp.name += " rocks!"  

println(jp.getName)  
println(sp.getName)  


// COMMAND ----------


