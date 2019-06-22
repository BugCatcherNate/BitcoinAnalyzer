import fetchers.ParseURL

object Main {

  def main(args: Array[String]): Unit = {

    val res = ParseURL.parse("https://api.coindesk.com/v1/bpi/currentprice.json")

    print(res.time + " " + res.rate.toString)

  }

}
