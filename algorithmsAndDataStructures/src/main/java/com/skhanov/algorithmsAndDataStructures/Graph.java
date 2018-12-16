package com.skhanov.algorithmsAndDataStructures;

import java.util.LinkedList;

public class Graph {
	
	private int vertexCount;
	private int edgeCount;
	private LinkedList<Integer>[] adjLists;
	
	@SuppressWarnings({ "unchecked", "unused" })
	public Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		adjLists = new LinkedList[vertexCount];
		for (LinkedList<Integer> linkedList : adjLists) {
			linkedList = new LinkedList<>();
		}
	}
	
	public int vertexCount() {
		return vertexCount;
	}
	
	public int edgeCount() {
		return edgeCount;
	}
	
	public void addEdge(int v1, int v2) {
		adjLists[v1].add(v2);
		adjLists[v2].add(v1);
	}
	
	public LinkedList<Integer> getAdjList(int v) {
		return adjLists[v];   
	}
}
