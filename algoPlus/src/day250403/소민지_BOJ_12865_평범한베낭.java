package day250403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소민지_BOJ_12865_평범한베낭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] W = new int[N + 1];
		int[] V = new int[N + 1];
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N + 1][K + 1];
		for(int j = W[1] ; j <= K ; j++) {
			dp[1][j] = V[1];
		}
		
		for(int i = 2 ; i <= N ; i++) {
			for(int j = W[i] ; j <= K ; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - W[i]] + V[i]);
//				dp[i][j] = Math.max(i-1번째 물건까지 고려해서 최대(현재물건 x), i-1번째에서 현재 물건 뺀 만큼 무게에서 최대 + 현재물건);
			}
		}
		System.out.println(dp[N][K]);
	}
}
