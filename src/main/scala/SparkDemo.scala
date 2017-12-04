import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by mgawali1 on 12/4/2017.
  */
object SparkDemo {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf()
    conf.setAppName("FSA")
    conf.setMaster("local")
    val sc=new SparkContext(conf)
    System.setProperty("hadoop.home.dir","C:\\hadoop\\bin")
    val rdd=sc.parallelize(1 to 100)
    print(rdd.count())
    print("HI")

    val sqlContext=new SQLContext(sc)
    val df=sqlContext.read.format("text").text("C:\\Users\\mgawali1\\Desktop\\MapRData\\ip\\User_details")
    df.limit(5).show()
    df.rdd.map(arg =>arg.mkString(",")).collect().foreach(println)



  }

}
