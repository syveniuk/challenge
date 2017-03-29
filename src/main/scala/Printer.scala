package Printer

import EventWindow.ReportLine

class Printer() {
  
  val headerFormat: String = "%-10s %-9s %-3s %-9s %-9s %-9s"
  
  def printHeader() = {
    val header: String = headerFormat.format("T", "V", "N", "RS", "min", "max")
    println(header)
    println("-" * header.length)
  }
  
  def printLine(line: ReportLine) = {
    val lineFormat = "%-10d %-9.5f %-3d %-9.5f %-9.5f %-9.5f"
    println(lineFormat.format(line.t, line.v, line.n, line.sum, line.minV, line.maxV))
  }
}

