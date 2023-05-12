package hashing;

import java.util.Arrays;

public class ShortestPath {
	public static void main(String[] args) {
		int[][] graph = {
				{0,4,2,0,0},
				{1,0,1,5,0},
				{2,1,0,8,10},
				{0,5,8,0,2},
				{0,0,10,2,0}
		};
		int source = 0;
		int[] distance = dijkstra(graph, source);
		System.out.println("Shortest distances from vertex "+source);
		int count = 0;
		for(int i: distance) {
			System.out.println("Vertex: "+count+": "+i);
		}
	}
	private static int[] dijkstra(int[][] graph, int source) {
		int n = graph.length;
		int distances[] = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(visited,false);
		distances[source] = 0;
		for(int i=0;i<n-1;i++) {
			int minVertex = findMinVertex(distances, visited);
			visited[minVertex] = true;
			for(int j=0;j<n;j++) {
				if(graph[minVertex][j]!=0 && !visited[j]) {
					int newDist = distances[minVertex] + graph[minVertex][j];
					if(newDist < distances[j]) {
						distances[j] = newDist;
					}
				}
			}
		}
		return distances;
	}
	private static int findMinVertex(int[] distances, boolean[] visited) {
		int minVertex = -1;
		for(int i=0;i<distances.length;i++) {
			if(!visited[i] && (minVertex==-1 || distances[i]<distances[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}
}
