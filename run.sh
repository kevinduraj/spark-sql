#!/bin/bash

sbt clean && sbt package &&                 \
spark-submit                                \
    --class "com.nootrino.SparkSQLCSV"      \
    --master local[8]                       \
    ./target/scala-2.11/spark-sql_2.11-1.0.jar
