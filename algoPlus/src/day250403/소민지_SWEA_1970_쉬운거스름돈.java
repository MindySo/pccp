package day250403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소민지_SWEA_1970_쉬운거스름돈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringBuilder sb = new StringBuilder();
			int[] arr = new int[] { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
			int cnt;
			
			for(int bill : arr) {
				cnt = N / bill;
				N %= bill;
				sb.append(cnt).append(" ");
			}
			System.out.println("#" + tc);
			System.out.println(sb);
		}
	}
}
