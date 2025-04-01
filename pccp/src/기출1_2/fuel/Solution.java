package 기출1_2.fuel;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public static int solution(int[][] land) {

		int N = land.length;
		int M = land[0].length;
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();

		int[] temp;
		int r;
		int c;
		int[] dr = new int[] { -1, 0, 0, 1 };
		int[] dc = new int[] { 0, -1, 1, 0 };

		int[] ground = new int[M];
		int minC;
		int maxC;
		int chunkSize;
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (land[i][j] == 1 && !visited[i][j]) {
					minC = 501;
					maxC = -1;
					que.add(new int[] { i, j });
					visited[i][j] = true;
					chunkSize = 0;

					while (!que.isEmpty()) {
						temp = que.poll();
						minC = Math.min(minC, temp[1]);
						maxC = Math.max(maxC, temp[1]);
						chunkSize++;
						for (int d = 0; d < 4; d++) {
							r = temp[0] + dr[d];
							c = temp[1] + dc[d];
							if (r >= 0 && r < N && c >= 0 && c < M && land[r][c] == 1 && !visited[r][c]) {
								que.add(new int[] { r, c });
								visited[r][c] = true;
							}
						}
					}
					for (int k = minC; k <= maxC; k++) {
						ground[k] += chunkSize;
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < M; i++) {
			max = Math.max(max, ground[i]);
		}
		return max;
	}
}