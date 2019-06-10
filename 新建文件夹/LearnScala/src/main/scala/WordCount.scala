import  org.apache.spark.{SparkConf,SparkContext}
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setMaster("local[*]").setAppName("wordcount");

    val sc =new SparkContext(conf);
    sc.textFile("D:\\789.txt")
      .flatMap(_.split(" "))
      .map((_,1))
      .reduceByKey(_+_,1)
      .saveAsTextFile("D:\\1123");

    sc.stop()
  }
}
