import java.util.*;
class TopologicalSort {
	public void TPS(Graph G) {
		Set<Vertex> set = new HashSet<Vertex>();
		Deque<Vertex> st = new LinkedList<Vertex>();
		for(Vertex v: G.getAllVertices()) {
			TPS_UTIL(v, set,st);
		}
		while(!st.isEmpty()) {
			Vertex v = st.removeFirst();
			System.out.print(v.getId()+" "); 
		}
	}
	public void TPS_UTIL(Vertex v, Set<Vertex> set, Deque<Vertex> st) {
		if(!set.contains(v)) {
			set.add(v);
			for(Vertex ve: v.getAdjVertex()) {
				TPS_UTIL(ve,set,st);
			}
			st.addFirst(v);
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(true);
		g.addEdge(1,3);
		g.addEdge(2,3);
		g.addEdge(2,4);
		g.addEdge(3,5);
		g.addEdge(4,6);
		g.addEdge(5,6);
		g.addEdge(6,7);
		g.addEdge(6,8);
		TopologicalSort tps = new TopologicalSort();
		tps.TPS(g);
	}
}