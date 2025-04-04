package day250404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소민지_SWEA_5656_벽돌깨기 {

	static int N;
	static int W;
	static int H;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = Integer.MAX_VALUE;
			DFS(map, 1);
			System.out.println(ans);
		}
	}

	static void DFS(int[][] map, int idx) {
		if (idx > N) {
			System.out.println("count" + countBrick(map));
			ans = Math.min(ans, countBrick(map));
			return;
		}

		System.out.print(idx + "dfs ");
		DFS(shoot(map), idx + 1);
	}

	static int[][] shoot(int[][] map) {
		int[][] newMap = null;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap = copyMap(map);
				crush(newMap, i, j);
				collapse(newMap);
			}
		}

		return newMap;
	}

	static int[][] copyMap(int[][] originMap) {
		int[][] newMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = originMap[i][j];
			}
		}
		return newMap;
	}

	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	static void crush(int[][] map, int i, int j) {
		int range = map[i][j];
		int r;
		int c;
		map[i][j] = 0;
		for (int dir = 0; dir < 4; dir++) {
			for (int d = 0; d < range; d++) {
				r = i + dr[dir] * d;
				c = j + dc[dir] * d;
				if (r >= 0 && r < H && c >= 0 && c < W) {
					crush(map, r, c);
				}
			}
		}
	}

	static void collapse(int[][] map) {
		Queue<Integer> que = new LinkedList<Integer>();
		int h = 0;
		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 0; j--) {
				if (map[j][i] != 0) {
					que.add(map[j][i]);
					map[j][i] = 0;
				}
			}
			h = 0;
			while (!que.isEmpty()) {
				map[i][h] = que.poll();
			}
		}
	}

	static int countBrick(int[][] map) {
		int cnt = 0;
		for (int[] arr : map) {
			for (int i : arr) {
				if (i != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
