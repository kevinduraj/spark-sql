package com.nootrino
 
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

/**
  * Spark SQL with JDBC Example 
  */
object SparkSQLCSV {
 
  def main(args: Array[String]) {

    val spark = SparkSession.builder().appName("SparkSQLCSV").config("spark.some.config.option", "kduraj").getOrCreate()
    import spark.implicits._

    val df = spark.read.format("csv").option("header", "true").load("Baby_Name__Beginning_2007.csv") 

    df.printSchema()
    //df.registerTempTable("names")
    df.createOrReplaceTempView("names")

    val sql1 = "SELECT name, count(*) TotalByCounty FROM names GROUP BY name ORDER BY TotalByCounty DESC"
    println(sql1)
    val sqlDF1 = spark.sql(sql1)
    sqlDF1.show(12, false)

    val sql2 = "SELECT name, sum(count) GrandTotal FROM names GROUP BY name ORDER BY GrandTotal DESC"
    println(sql2)
    val sqlDF2 = spark.sql(sql2)
    sqlDF2.show(12, false)

    spark.stop()

  }
 
}
