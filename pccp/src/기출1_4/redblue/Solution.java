package 기출1_4.redblue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static int solution(int[][] maze) {
		int n = maze.length;
		int m = maze[0].length;

		boolean[][] redVisited = new boolean[n][m];
		boolean[][] blueVisited = new boolean[n][m];

		Queue<int[]> que = new LinkedList<>();
		int[] temp;
		int redR = 0;
		int redC = 0;
		int blueR = 0;
		int blueC = 0;
		int cnt;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(maze[i][j] == 1) {
					redR = i;
					redC = j;
				}
				if(maze[i][j] == 2) {
					blueR = i;
					blueC = j;
				}
			}
		}
		
		int turn = 0;
		int[] dr = new int[] {-1, 0, 0, 1};
		int[] dc = new int[] {0, -1, 1, 0};
		
		que.add(new int[] {redR, redC, blueR, blueC, 0});
		redVisited[redR][redC] = true;
		blueVisited[blueR][blueC] = true;
		
		while(!que.isEmpty()) {
			temp = que.poll();
			redR = temp[0];
			redC = temp[1];
			blueR = temp[2];
			blueC = temp[3];
			cnt = temp[4];
			if(maze[redR][redC] == 3 && maze[blueR][blueC] == 4) {
				turn = cnt;
				break;
			}
			
			for(int d = 0 ; d < 4 ; d++) {
				redR = temp[0] + dr[d];
				redC = temp[1] + dc[d];
				blueR = temp[2] + dr[d];
				blueC = temp[3] + dc[d];
				cnt = temp[4];
				
				int[] nextRC = new int[] {temp[0], temp[1], temp[2], temp[3], cnt + 1};
				if(maze[redR][redC] != 3 && redR >= 0 && redR < n && redC >= 0 && redC < m && maze[redR][redC] != 5 && !redVisited[redR][redC]) {
					redVisited[redR][redC] = true;
					nextRC[0] = redR;
					nextRC[1] = redC;
				}
				if(maze[blueR][blueC] != 4 && blueR >= 0 && blueR < n && blueC >= 0 && blueC < m && maze[blueR][blueC] != 5 && !blueVisited[blueR][blueC]) {
					blueVisited[blueR][blueC] = true;
					nextRC[2] = blueR;
					nextRC[3] = blueC;
				}
				que.add(nextRC);
			}
		}

		return turn;
	}
	
	public static void main(String[] args) {
		int[][] test = new int[][]	{{1, 4}, {0, 0}, {2, 3}};
		solution(test);
	}
}
