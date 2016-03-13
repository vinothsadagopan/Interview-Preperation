class DepthFirstSearchAdjMat {
	public void dfs(GraphMatrix G, int index) {
		G.visited[index]=true;
		System.out.println(index+1 +" is visted");
		for(int i=0;i< G.table[index].length;i++) {
			if((G.table[index][i]==1) &&(!G.visited[i])) {
				dfs(G, i);
			}
		}
	}
	public static void main(String[] args) {
		GraphMatrix G = new GraphMatrix(6, false);
		G.createEdge(1,2);
		G.createEdge(1,3);
		G.createEdge(3,4);
		G.createEdge(4,5);
		G.createEdge(4,6);
		G.createEdge(5,6);
		DepthFirstSearchAdjMat GM = new DepthFirstSearchAdjMat();
		GM.dfs(G,2);
	}
}