package 기출1_4.redblue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
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
		int newRedR = 0;
		int newRedC = 0;
		int blueR = 0;
		int blueC = 0;
		int newBlueR = 0;
		int newBlueC = 0;
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
			
			for(int d1 = 0 ; d1 < 4 ; d1++) {
				int[] nextRC = new int[] {temp[0], temp[1], temp[2], temp[3], cnt + 1};

				newRedR = redR + dr[d1];
				newRedC = redC + dc[d1];
				cnt = temp[4];
				
				if(newRedR >= 0 && newRedR < n && newRedC >= 0 && newRedC < m && newRedR != blueR && newRedC != blueC 
						&& maze[newRedR][newRedC] != 5 && maze[newRedR][newRedC] != 3 && !redVisited[newRedR][newRedC]) {
					redVisited[newRedR][newRedC] = true;
					nextRC[0] = newRedR;
					nextRC[1] = newRedC;
				}
				
				for(int d2 = 0 ; d2 < 4 ; d2++) {
					newBlueR = blueR + dr[d2];
					newBlueC = blueC + dc[d2];
					
					if(newBlueR >= 0 && newBlueR < n && newBlueC >= 0 && newBlueC < m && newBlueR != newRedR && newBlueC != newRedC
							&& maze[newBlueR][newBlueC] != 5 && maze[newBlueR][newBlueC] != 4 && !blueVisited[newBlueR][newBlueC]) {
						blueVisited[newBlueR][newBlueC] = true;
						nextRC[2] = newBlueR;
						nextRC[3] = newBlueC;
					}
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
