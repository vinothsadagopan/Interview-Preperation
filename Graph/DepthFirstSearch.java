import java.util.*;
class DepthFirstSearch {
	public void DFS(Graph G) {
		Set<Vertex> visited = new HashSet<Vertex>();
		for(Vertex vertex: G.getAllVertices()) {
			DFSUtil(vertex,visited);
		}
	}
	public void DFSUtil(Vertex vertex, Set<Vertex> visited) {
		if(!visited.contains(vertex)) {
			visited.add(vertex);
			System.out.println(vertex.getId());
			for(Vertex v: vertex.getAdjVertex()) {
				DFSUtil(v,visited);
			}
		}
	}
	public static void main(String[] args) {
		Graph graph= new Graph(false);
		 graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
    //  graph.addEdge(5, 1);
        graph.addEdge(5,3);
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.DFS(graph);
	}
}