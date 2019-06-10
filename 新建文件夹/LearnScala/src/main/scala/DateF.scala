import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
object DateF {
  def main(args: Array[String]): Unit = {

    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("test").set("spark.port.maxRetries","1000")
    val spark = SparkSession.builder().config(sparkconf).getOrCreate()

    import spark.implicits._
    val df = spark.read.json("hdfs://etc01:8020/a3/people.json")


    df.show()
    df.filter($"age" > 21).show()
    df.createOrReplaceTempView("persons")
    spark.sql("SELECT * FROM persons where age > 21").show()
    spark.stop()
  }
}