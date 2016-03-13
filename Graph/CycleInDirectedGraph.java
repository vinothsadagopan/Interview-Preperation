import java.util.*;
class CycleInDirectedGraph {
	public boolean isCycle(Graph G) {
		Set<Vertex> whiteSet = new HashSet<Vertex>();
		Set<Vertex> greySet = new HashSet<Vertex>();
		Set<Vertex> blackSet = new HashSet<Vertex>();
		for(Vertex v: G.getAllVertices()) {
			whiteSet.add(v);
		}
		for(Vertex v : G.getAllVertices()) {
			if(dfs(v, whiteSet,greySet,blackSet)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	public boolean dfs(Vertex current, Set<Vertex> whiteSet, Set<Vertex> greySet, Set<Vertex> blackSet) {
		
		moveVertex(current, whiteSet,greySet);
		for(Vertex v: current.getAdjVertex()) {
			if(blackSet.contains(current)) {
				continue;
			}
			if(greySet.contains(current)) {
				return true;
			}

			if(dfs(v,whiteSet,greySet,blackSet)) {
				return true;
			}
			else {
				return false;
			}
		}
		moveVertex(current, greySet,blackSet);
		return false;
	}
	public void moveVertex(Vertex current, Set<Vertex> sourceSet, Set<Vertex> destinationSet ) {
		sourceSet.remove(current);
		destinationSet.add(current);
	}
	public static void main(String[] args) {
		CycleInDirectedGraph cg = new CycleInDirectedGraph();
		Graph g =new Graph(true);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(1,3);
		//g.addEdge(4,1);
		g.addEdge(5,4);
		g.addEdge(5,6);
		g.addEdge(4,6);
		System.out.println("Are the given graph is cyclic "+cg.isCycle(g));
	}
}