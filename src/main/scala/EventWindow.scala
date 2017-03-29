package EventWindow

import scala.collection.mutable
import scala.math._

class EventWindow(t: Int) {
  var eventList = mutable.MutableList[TimeEvent]()

  def process(event: TimeEvent): ReportLine = {
    eventList += event
    eventList = eventList.dropWhile((x: TimeEvent) => x.time < (event.time - 60))

    val t = event.time
    val v = event.price
    val n = eventList.length
    val sum = eventList.foldLeft(0.0)((x: Double, y: TimeEvent) => x + y.price)
    val minV = eventList.foldLeft(eventList(0).price)((x: Double, y: TimeEvent) => min(x, y.price))
    val maxV = eventList.foldLeft(eventList(0).price)((x: Double, y: TimeEvent) => max(x, y.price))
    //    (t, v, n, sum, minV, maxV)
    new ReportLine(t, v, n, sum, minV, maxV)
  }
}

case class TimeEvent(time: Long, price: Double)

case class ReportLine(t: Long, v: Double, n: Int, sum: Double, minV: Double, maxV: Double)


