// Databricks notebook source
def addition(x:Int, y:Int) : Int = {
  return x + y
}

// COMMAND ----------

addition(45,87)

// COMMAND ----------

def floatAddition(a:Float, b:Float) : Float = {
  return a + b
}

// COMMAND ----------

floatAddition(34, 56)

// COMMAND ----------

var square = (x:Int) => x*x

// COMMAND ----------

square(9)

// COMMAND ----------

def square(x:Int) : Int = {
  return x* x
}

// COMMAND ----------

square(30)

// COMMAND ----------

//Class Creations
class Arithmetic_operations() 
{ def addition(a: Int, b: Int): Unit = {
  println("addition method:",a+b)        
}
 def sub(a: Int, b: Int): Unit = {
  println("Subtraction method:",a-b)
}
 def multiply(a: Int, b:Int): Unit = {
   println("Multiplication Method:",a * b)
 }
}

// COMMAND ----------

val a1 = new Arithmetic_operations()

// COMMAND ----------

a1.addition(45,67)

// COMMAND ----------

val myList = 1 to 100

// COMMAND ----------

val evenList = scala.collection.mutable.ListBuffer.empty[Int]


// COMMAND ----------

val oddList = scala.collection.mutable.ListBuffer.empty[Int]

// COMMAND ----------

for (i <- myList){
  if(i%2==0){
    evenList +=i
  }else{
    oddList += i
  }
}

// COMMAND ----------

evenList

// COMMAND ----------

oddList

// COMMAND ----------

val divisibleTwo = scala.collection.mutable.ListBuffer.empty[Int]
val divisibleThree = scala.collection.mutable.ListBuffer.empty[Int]
val divisibleFour = scala.collection.mutable.ListBuffer.empty[Int]
val divisibleFive = scala.collection.mutable.ListBuffer.empty[Int]
val divisibleOther = scala.collection.mutable.ListBuffer.empty[Int]

// COMMAND ----------

for (j <- myList) {
  if(j%2==0){
    divisibleTwo +=j
  }else if(j%3==0){
    divisibleThree +=j
  }else if(j%4==0){
    divisibleFour +=j
  }else if(j%5 ==0){
    divisibleFive +=j
  }else{
    divisibleOther +=j
  }
}

// COMMAND ----------

divisibleTwo

// COMMAND ----------

divisibleThree

// COMMAND ----------

divisibleFour

// COMMAND ----------

divisibleFive

// COMMAND ----------

divisibleOther

// COMMAND ----------


  myList match{
  case 1 => println("Divisible by two")
  case 2 => println("Divisible by three")
  case 3 => println("Divisible by four")
  case 4 => println("Divisible by five")
  case _ => println("Divisible by any other number")
               }

                     

// COMMAND ----------

//

// COMMAND ----------

sc


// COMMAND ----------

val rdd = sc.parallelize(List(1,3,5,7))

// COMMAND ----------

val mult_rdd = rdd.map(x => x*x)

// COMMAND ----------

mult_rdd.collect()

// COMMAND ----------

val add_rdd = rdd.map(y => y+y)

// COMMAND ----------

add_rdd.collect()

// COMMAND ----------

rdd.count()

// COMMAND ----------

add_rdd.take(2)

// COMMAND ----------

add_rdd.count()

// COMMAND ----------

val rdd_a = sc.parallelize(1 to 10)

// COMMAND ----------

rdd_a.collect()

// COMMAND ----------

val rdd_b = rdd_a.filter(x => x % 3 == 0)

// COMMAND ----------

rdd_b.collect()

// COMMAND ----------

val mult_rdd2 = rdd_b.map(x => x * x)


// COMMAND ----------

mult_rdd2.collect()

// COMMAND ----------

val rdd = sc.parallelize(1 to 100)

// COMMAND ----------

rdd.collect()

// COMMAND ----------

val rdd_two = rdd.filter(y => y%2 == 0 )

// COMMAND ----------

rdd_two.collect()

// COMMAND ----------

val rdd_three = rdd.filter(y => y%3 == 0 )

// COMMAND ----------

rdd_three.collect()

// COMMAND ----------

val rdd_four = rdd.filter(y => y%4 == 0 )

// COMMAND ----------

rdd_four.collect()

// COMMAND ----------

// Class Notes 01/09/2018 

sc

// COMMAND ----------

val rdd = sc.parallelize(List(1,2,3,4))

// COMMAND ----------

val rdd = sc.parallelize(List(1,2,3,4))

// COMMAND ----------

val mutl_rdd = rdd.map(x => x*x)

// COMMAND ----------

mutl_rdd.collect()

// COMMAND ----------

val sum_of_rdd = rdd.map(x => x * x).reduce((x,y)=>x+y)

// COMMAND ----------

val sum_of_rdd = rdd.map(x => x * x).reduce(_+_)

// COMMAND ----------

val rdd_a = sc.parallelize(1 to 10, 3)
val rdd_b = rdd_a.filter(x => x % 3 == 0)
rdd_b.collect()

// COMMAND ----------

val rdd_c = sc.parallelize(List("John", "Jack", "Mike", "Jack"))
val dist_rdd = rdd_c.distinct()
dist_rdd.collect()

// COMMAND ----------

val rdd_x = sc.parallelize(1 to 12)
val rdd_y = sc.parallelize(5 until 20)
val rdd_z = rdd_x.intersection(rdd_y)
rdd_z.collect()

// COMMAND ----------

val rdd_a = sc.parallelize(3 to 7, 1)
val rdd_b = sc.parallelize(7 to 9, 1)
val rdd_c = rdd_a.union(rdd_b)
rdd_c.collect()

// COMMAND ----------

val rdd_a = sc.parallelize(List("animal", "human", "bird", "rat", "Desktop", "penguin"), 3)
val rdd_b = rdd_a.map(_.length)
val rdd_c = rdd_a.zip(rdd_b)
rdd_c.collect()

// COMMAND ----------

val rdd_a = sc.parallelize(1 to 5, 4)
//val map_rdd = rdd_a.map(x =>1 to x)
val map_rdd = rdd_a.map(1 to _)
map_rdd.collect
val flat_map = rdd_a.flatMap(1 to _)
flat_map.collect

// COMMAND ----------

sc.parallelize(List(5, 10, 20), 2).map(x => List(x, x, x)).collect


// COMMAND ----------

sc.parallelize(List(5, 10, 20), 2).flatMap(x => List(x, x, x)).collect

// COMMAND ----------

val rdd_a = sc.parallelize(List("Monkey","Giraffe","Lion","Tiger","Elephant","Kangaroo","Crocodile"),2)
val rdd_b = rdd_a.map(x => (x.length,x))
rdd_b.collect
//rdd_b.keys.collect
//rdd_b.values.collect

// COMMAND ----------

rdd_b.keys.collect

// COMMAND ----------

rdd_b.values.collect

// COMMAND ----------

val rdd_x = sc.parallelize(List(45,24,67,34,15))
val rdd_y = sc.parallelize(List(98,75,46,84,34))
rdd_x.cartesian(rdd_y).collect()

// COMMAND ----------

val rdd_a = sc.parallelize(List("animal", "human", "bird", "rat", "cat", "rabbit", "sheep", "lion", "peacock"), 3)
val rdd_b = rdd_a.map(_.length)
val rdd_c = rdd_b.zip(rdd_a)
rdd_c.collect
rdd_c.groupByKey.collect

// COMMAND ----------

val rdd_a = sc.parallelize(List("black", "blue", "white", "green", "grey","Violet","Cyan"), 2)
val rdd_b = rdd_a.map(x => (x.length, x))
rdd_b.collect

// COMMAND ----------

val reduce_by_key_result = rdd_b.reduceByKey(_ + _)
reduce_by_key_result.collect

// COMMAND ----------

val rdd_a = sc.parallelize(List("black", "blue", "white", "orange"), 2)
val rdd_b = rdd_a.map(x => (x.length, x))
rdd_b.collect
val rdd_c = rdd_b.reduceByKey(_ + _).collect

// COMMAND ----------

val x= sc.parallelize(List(2, 3, 4)).count()
val y = sc.parallelize(List(2, 3, 4)).first()
val z = sc.parallelize(List(2, 3, 4)).take(2)

// COMMAND ----------


