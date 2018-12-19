package com.skhanov.algorithmsAndDataStructures;

import java.util.LinkedList;

public class DepthFirstPath {
	
	private boolean[] marked;
	private int[] edgeFrom;
	private int source;
	
	public DepthFirstPath(Graph graph, int sourceVertex) {
		marked = new boolean[graph.vertexCount()];
		edgeFrom = new int[graph.vertexCount()];
		this.source = sourceVertex;
		dfs(graph, sourceVertex);
	}

	private void dfs(Graph graph, int sourceVertex) {
		marked[sourceVertex] = true;
		for (int vertex : graph.getAdjList(sourceVertex)) {
			if(!marked[vertex]) {
				edgeFrom[vertex] = sourceVertex;
				dfs(graph, vertex);
			}
		}
	}
	
	public boolean hasPathTo(int dist) {
		return marked[dist];
	}
	
	public LinkedList<Integer> pathTo(int dist) {
		if(!hasPathTo(dist)) {
			return null;
		}
		LinkedList<Integer> result = new LinkedList<>();
		int vertex = dist;
		while(vertex != source) {
			result.add(vertex);
			vertex = edgeFrom[vertex];
		}
		return result;
	}
}
