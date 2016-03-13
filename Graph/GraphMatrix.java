class GraphMatrix {
	boolean isDirected;
	int[][] table;
	boolean[] visited;
	GraphMatrix(int noOfNodes, boolean isDirected) {
		table = new int[noOfNodes][noOfNodes];
		visited= new boolean[noOfNodes];
		this.isDirected=isDirected;
	}
	public void createEdge(int source,int destination) {
		if(isDirected) {
			table[source-1][destination-1]=1;
		}
		else {
			table[destination-1][source-1]=1;
			table[source-1][destination-1]=1;
		}
	}
}