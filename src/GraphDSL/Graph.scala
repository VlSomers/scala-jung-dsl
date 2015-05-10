package GraphDSL

/**
 * @author Vladar
 */

abstract class Graph {
  var _name: String
  def name: String
  def name_= (newName: String)
  
  val graph: edu.uci.ics.jung.graph.Graph[Vertex, Edge]
  def addVertex(vertex: Vertex): Graph
  def addEdge(vertex1: Vertex, vertex2: Vertex, edge: Edge, isDirected: Boolean): Graph
}
