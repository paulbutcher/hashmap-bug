import io.Source

object HashMapBug {

  def main(args: Array[String]) {
    load("mobythes.aur")
  }

  def load(fileName: String) {

    val nodes = new collection.mutable.ListBuffer[Symbol]
    
    Source.fromFile(fileName).getLines foreach { line =>
      nodes += (line.split(",") map { s => Symbol(s) }).head
    }
    
    val graph = Array.ofDim[Int](nodes.size, nodes.size)
    nodes foreach { node =>
      if (!(Symbol(node.name) eq node))
        println(node)
    }
  }
}