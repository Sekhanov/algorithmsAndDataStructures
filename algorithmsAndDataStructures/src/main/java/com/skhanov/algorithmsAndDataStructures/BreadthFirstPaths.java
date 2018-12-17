package com.skhanov.algorithmsAndDataStructures;

import java.util.LinkedList;

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeFrom;
	private int[] pathTo;
	private int source;
	private static final int INF = Integer.MAX_VALUE;
	
	public BreadthFirstPaths(Graph graph, int source) {
		this.source = source;
		marked = new boolean[graph.vertexCount()];
		edgeFrom = new int[graph.vertexCount()];
		pathTo = new int[graph.vertexCount()];		
		for(int i = 0; i < pathTo.length; i++) {
			pathTo[i] = INF;
		}
		bfc(graph, source);
	}
	

	private void bfc(Graph graph, int source) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(source);
		marked[source] = true;
		pathTo[source] = 0;
		
		while(!queue.isEmpty()) {
			int vertex = queue.removeFirst();
			for(int v: graph.getAdjList(vertex)) {
				if(!marked[v]) {
					marked[v] = true;
					edgeFrom[v] = vertex;
					pathTo[v] = pathTo[vertex] + 1;
					queue.addLast(v);
				}
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
	
	public int distTo(int dist) {		
		return pathTo[dist];
	}
	
}
