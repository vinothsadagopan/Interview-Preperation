import java.util.*;
class BreadthFirstSearch {
	public void BFS(Graph G) {
		Deque<Vertex> q= new LinkedList<Vertex>();
		Set<Vertex> visited = new HashSet<Vertex>();
		for(Vertex v: G.getAllVertices()) {
			if(!visited.contains(v)) {
				q.addLast(v);
				System.out.print(v.getId()+" ");
				while(!q.isEmpty()) {
					Vertex vq = q.removeFirst();
					for(Vertex ve: vq.getAdjVertex()) {
						if(!visited.contains(ve)) {
							q.addLast(ve);
							visited.add(ve);
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Graph g = new Graph(true);
		g.addEdge(1,3);
		g.addEdge(1,2);
		g.addEdge(3,4);
		//g.addEdge(2,4);
		g.addEdge(4,5);
		g.addEdge(4,6);
		g.addEdge(5,6);
		g.addEdge(5,7);
		g.addEdge(7,8);
		g.addEdge(6,8);
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.BFS(g);
		
	}
}