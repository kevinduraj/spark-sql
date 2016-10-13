Spark 2.0 - SQL on DataFrame 
============================


###Result
```
root
 |-- year: string (nullable = true)
 |-- name: string (nullable = true)
 |-- county: string (nullable = true)
 |-- sex: string (nullable = true)
 |-- count: string (nullable = true)

SELECT name, count(*) TotalByCounty FROM names GROUP BY name ORDER BY TotalByCounty DESC
+--------+-------------+                                                        
|name    |TotalByCounty|
+--------+-------------+
|EMMA    |322          |
|JACOB   |316          |
|LOGAN   |307          |
|OLIVIA  |303          |
|ISABELLA|291          |
|SOPHIA  |283          |
|MASON   |282          |
|NOAH    |279          |
|AVA     |267          |
|ETHAN   |267          |
|MADISON |259          |
|LIAM    |259          |
+--------+-------------+
only showing top 12 rows

SELECT name, sum(count) GrandTotal FROM names GROUP BY name ORDER BY GrandTotal DESC
+--------+----------+                                                           
|name    |GrandTotal|
+--------+----------+
|MICHAEL |11565.0   |
|ISABELLA|10207.0   |
|JACOB   |10008.0   |
|MATTHEW |10003.0   |
|SOPHIA  |9874.0    |
|JAYDEN  |9869.0    |
|JOSEPH  |9762.0    |
|DANIEL  |9336.0    |
|ETHAN   |9274.0    |
|ANTHONY |9235.0    |
|RYAN    |9063.0    |
|OLIVIA  |8903.0    |
+--------+----------+
only showing top 12 rows
```
