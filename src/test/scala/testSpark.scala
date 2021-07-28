import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @auther: zhaoguangyue
 * @date: 2021/7/27
 * @description:
 */
object testSpark {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("sql").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    //    val rdd: RDD[String] = sc.textFile("/Users/rick/sogoRepo/people.txt")
    val df = spark.read.json("/Users/rick/sogoRepo/people.json")
    val schema = df.schema
    println(schema)
  }
}
