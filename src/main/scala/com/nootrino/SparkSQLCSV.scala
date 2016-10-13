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

    //println("-" * 100)
    val sqlDF = spark.sql("SELECT name, count(*) total FROM names GROUP BY name ORDER BY total DESC")
    sqlDF.show(25, false)

    spark.stop()

  }
 
}
