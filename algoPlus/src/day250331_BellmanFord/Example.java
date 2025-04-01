package day250331_BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example {
	static class Edge {
		int s, e, cost;

		public Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	}

	static int V;
	static int E;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);
		V = sc.nextInt();
		E = sc.nextInt();

		List<Edge> edges = new ArrayList<>();
		dist = new int[V];

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new Edge(s, e, cost));
		}

		bellmanFord(edges);

	}

	// V : 전체 정점의 개수
	// start : 시작 정점
	// edges : 간선의 배열
	private static void bellmanFord(List<Edge> edges) {
		// dist 배열 초기화
		Arrays.fill(dist, INF);
		dist[E] = 0; // 시작점만 0으로 바꾼다

		// 1. 모든 간선을 (V-1)번 반복 -> Relaxatoin 작업 수행
		for (int i = 0; i < V - 1; i++) {
			for (Edge edge : edges) {
				// 갱신
				if (dist[edge.s] != INF && dist[edge.s] + edge.cost < dist[edge.e]) {
					dist[edge.e] = dist[edge.s] + edge.cost;
				}
			}
		}// 완화작업 끝
	
		// 2. 음수 사이클 체크
		boolean negCycle = false;
		for(Edge edge : edges) {
			if(dist[edge.s] != INF && dist[edge.s] + edge.cost < dist[edge.e]) {
				// 조건문 만족 : 음의 사이클이 존재한다
				negCycle = false;
				break;
			}
		}
		
		// 3. 결과 확인
		if(negCycle) {
			System.out.println("음의 사이클");
		}else {
			System.out.println(Arrays.toString(dist));
		}
	}

	// 음의 사이클 X
	static String input1 = "6 7\r\n" + "0 1 4\r\n" + "0 2 5\r\n" + "1 3 -2\r\n" + "2 4 8\r\n" + "3 5 7\r\n"
			+ "4 2 -3\r\n" + "4 5 6";

	// 음의 사이클 O
	static String input2 = "4 4\r\n" + "0 1 5\r\n" + "1 2 -8\r\n" + "2 1 3\r\n" + "2 3 6";

}
