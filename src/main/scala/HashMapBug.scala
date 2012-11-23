import io.Source

object HashMapBug {

  def main(args: Array[String]) {
    load("mobythes.aur")
  }

  def load(fileName: String) {

    val nodes = new collection.mutable.HashMap[Symbol, Integer]
    
    def chunks() = new Iterator[Symbol] {
      val lines = Source.fromFile(fileName).getLines
      def hasNext = lines.hasNext
      def next = (lines.next.split(",") map { s => Symbol(s) }).head
      // def next = Symbol(lines.next.split(",").head)
    }
      
    chunks foreach { node =>
      nodes += (node -> nodes.size)
    }
    
    // val graph = Array.ofDim[Int](nodes.size, nodes.size)
    chunks foreach { node =>
      if (!nodes.isDefinedAt(node))
        println(node)
    }
  }
}