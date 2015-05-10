package GraphDSL
import scala.collection.JavaConversions._
/**
 * @author Vladar
 */
class SimpleGraphModel extends GraphModel {
  
  def addVertex(graph: Graph, vertex: Vertex): Graph = {
    graph.addVertex(vertex)
  }
  def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph = {
    graph.addEdge(edge._1, edge._2, edge._3, isDirected)
  }
  
  
  
  def add(graph1 : Graph, graph2 : Graph) : Graph ={
    
    val dest = SimpleGraph()
    
    for(v <- graph1.getVertices()) {
      dest.addVertex(v)
    }
    for(v <- graph2.getVertices()) {
      dest.addVertex(v)
    }
    
    for (e <- graph1.getEdges()){
      if(graph1.isDirected(e)){        
        addEdge(dest, (graph1.getSource(e) , graph1.getDest(e) , e),true)
      }
      else {
        val vertices : List[Vertex] = graph1.getIncidentVertices(e)
        dest.addEdge(vertices(0) , vertices(1) , e ,false)
      } 
    }
    
    for (e <- graph2.getEdges()){
      if(graph2.isDirected(e)){        
        dest.addEdge(graph2.getSource(e) , graph2.getDest(e) , e , true)
      }
      else {
        val vertices : List[Vertex] = graph2.getIncidentVertices(e)
        dest.addEdge(vertices(0) , vertices(1) , e ,false)
      } 
    }
    
    dest
    
  }
  
  
  /*def multiply(graph : Graph, Graph : Graph) : Graph = {
    
  }
  def clone(Graph :Graph) = {
    
  }*/
}

trait DirectedGraphModel extends GraphModel {
    abstract override def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph = {
    super.addEdge(graph, edge, true)
  }
}

trait UndirectedGraphModel extends GraphModel { // useless?
    abstract override def addEdge(graph: Graph, edge: edge, isDirected: Boolean = false): Graph = {
    super.addEdge(graph, edge, false)
  }
}