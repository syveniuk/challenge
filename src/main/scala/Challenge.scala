import scala.io.Source
import Printer.Printer
import EventWindow.{EventWindow, TimeEvent}

object Challenge {
  def main (args: Array[String]) {
    
    if (args.length< 1) {
      println("Please provide file path")
      System.exit(1)
    }
    val path = args(0)
    val lines = Source.fromFile(path, "utf-8").getLines
    val windowSize = 60

    val timeWindow = new EventWindow(windowSize)
    val printer = new Printer
    printer.printHeader()

    while (lines.hasNext) {
      val split: Array[String] = lines.next().split("\\s+")
      val time = split(0).toLong
      val price = split(1).toDouble
      val event = TimeEvent(time, price)
      val reportLine = timeWindow.process(event)
      printer.printLine(reportLine)
    }
  }
}
