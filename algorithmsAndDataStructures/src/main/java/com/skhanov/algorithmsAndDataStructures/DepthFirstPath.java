package com.skhanov.algorithmsAndDataStructures;

public class DepthFirstPath {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int source;
	
	public DepthFirstPath(Graph graph, int source) {
		marked = new boolean[graph.vertexCount()];
		edgeTo = new int[graph.vertexCount()];
		this.source = source;
		dfs(graph, source);
	}

	private void dfs(Graph graph, int source) {
		
	}
	
}
