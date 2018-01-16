// Databricks notebook source
// What is RDD?

// RDD stands for Resilient Distributed Dataset.
//Data is plit into different machines and they are fault-tolerant(which allows for recovery in case of data-loss due to partial data received/data loss etc.,)
//Data loss is usually recovered using the lineage graph from the parent node. 
//It also ensures that the lost branch is only replicated rather than the entire branch.

// COMMAND ----------

// what are operation on rdd?

//a) Transformations
//b) Actions

// COMMAND ----------

// what are transformation ?
//Transformations are something when an operation on an RDD gives another RDD

// Some sample transformations are map, flatmap, filter, distinct, interscection, union, unionall, zip, cartesian, group_by_key, reduce_by_key
// Map
val rdd_a = sc.parallelize(List("Monkey","Giraffe","Lion","Tiger","Elephant","Kangaroo","Crocodile"),2)
val rdd_b = rdd_a.map(x => (x.length,x))




// COMMAND ----------

// intersection

val rdd_x = sc.parallelize(1 to 12)
val rdd_y = sc.parallelize(5 until 20)
val rdd_z = rdd_x.intersection(rdd_y)


// COMMAND ----------

// Actions on RDD
// Actions are something when an operation on an RDD gives a result.

//Sample actions are collect, count, first, take

val x= sc.parallelize(List(2, 3, 4)).count()
val y = sc.parallelize(List(2, 3, 4)).first()
val z = sc.parallelize(List(2, 3, 4)).take(2)


// COMMAND ----------

val rdd_a = sc.parallelize(List("Monkey","Giraffe","Lion","Tiger","Elephant","Kangaroo","Crocodile"),2)
val rdd_b = rdd_a.map(x => (x.length,x))

rdd_b.collect

// COMMAND ----------

//Difference Between Map and Flatmap?

// Map collates the group of strings/numbers into separate arrays as in original file.
//Flatmap collates the entire original file into one big array

val rdd_new = sc.parallelize(1 to 9,5)
val map_rdd = rdd_new.map(x => 1 to x)
map_rdd.collect


// COMMAND ----------

val flatmap_rdd = rdd_new.flatMap(1 to _)

flatmap_rdd.collect

// COMMAND ----------

// Difference between group by key and reduce by key?

// Group by key separates by key and displays them as separate arrays much like map
// Reduce by key also separates by key but displays identical keys as one array and not separate similar to flatMap

val rdd_a = sc.parallelize(List("animal", "human", "bird", "rat", "cat", "rabbit", "sheep", "lion", "peacock"), 3)
val rdd_map = rdd_a.map(_.length)
val rdd_zip = rdd_map.zip(rdd_a)
rdd_zip.collect
rdd_zip.groupByKey.collect

// COMMAND ----------

val rdd_b = rdd_a.map(x => (x.length,x))
val reduce_by_key_result = rdd_b.reduceByKey(_ + _)
reduce_by_key_result.collect

// COMMAND ----------

// 20 Newsgroup Assignnment

// Word Count of the 20 newsgroup -> compgraphics -> 39676.txt

val news_rdd = sc.textFile("/FileStore/tables/39676")

// COMMAND ----------

news_rdd.take(4)

// COMMAND ----------

val news_words = news_rdd.flatMap(line => line.split(" "))

// COMMAND ----------

val news_split = news_words.map(word => (word,1))

// COMMAND ----------

val news_wordCount = news_split.reduceByKey((x,y) => x + y )

// COMMAND ----------

news_wordCount.collect

// COMMAND ----------

// Words with wordcount > 2


//Ignore this please! Its just for my own understanding!! 
//val new_filtermorethan2 = news_wordCount.filter(_._2 > 2)
//new_filtermorethan2.collect()



// COMMAND ----------

val news_sample = news_rdd.flatMap(line => line.split(" "))
news_sample.collect()


// COMMAND ----------

val news_a = news_sample.map(x => (x.length, x))
news_a.collect


// COMMAND ----------

val new_filtermorethan2 = news_a.filter(_._1 > 2)
new_filtermorethan2.collect

// COMMAND ----------

//  Sales Database


val sales_rdd = sc.textFile("/FileStore/tables/sales.txt").map(line=>line.split(",")).map(record =>(record(0), record(1), record(2)))

// COMMAND ----------

sales_rdd.collect

// COMMAND ----------

val numPurchases = sales_rdd.count()

// COMMAND ----------

// unique Users

val uniqueUsers = sales_rdd.map{ case (user, product, price) => user }.distinct().count()

// COMMAND ----------

//Sum of Revenue

val totalRevenue = sales_rdd.map{ case (user, product, price) => price.toFloat }.sum()

// COMMAND ----------

// Most Popular product

val productsByPopularity = sales_rdd.map{ case (user, product, price) => (product, 1) }.reduceByKey(_ +_).collect().sortBy(-_._2)

// COMMAND ----------

// Do not work separately
