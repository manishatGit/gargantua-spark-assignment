package com.knoldus

import org.apache.spark.{SparkContext, SparkConf}
import com.typesafe.config.ConfigFactory

object AssignmentOne extends App {

  val conf = new SparkConf().setAppName("assignment_one").setMaster("local[4]")
  val sc = new SparkContext(conf)
  val inputPath = ConfigFactory.load().getString("input.directory")
  val rdd = sc.textFile(inputPath) //Q1
  rdd.take(10).foreach(println) //Q2
  val totalRecords  = rdd.count //Q3
  println("Total records in the file::: "+totalRecords)
  val englishPageCounts = rdd.filter( line => line.split(" ").apply(0).contains("en")) //Q4
  println("Total records with english pages::: "+englishPageCounts.count()) //Q5
  val pageWiseRequestCount = rdd.map(line => (line.split(" ").apply(0),line.split(" ").apply(2).toInt)).reduceByKey((a,b)=> a+b)
  val pagesWithRequestMoreThanTwoHundredThousands = pageWiseRequestCount.filter(_._2>200000).count()//Q6
  println("Total pages which were requested more than 200000::"+pagesWithRequestMoreThanTwoHundredThousands)
  sc.stop()
}
