package day250403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소민지_BOJ_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		if(N == 3) {
			System.out.println(1);
			return;
		}
		if(N == 4) {
			System.out.println(-1);
			return;
		}

		int[] cnts = new int[N + 1];
		cnts[1] = -1;
		cnts[2] = -1;
		cnts[3] = 1;
		cnts[4] = -1;
		cnts[5] = 1;

		int cnt;
		for (int i = 6; i <= N; i++) {
			cnt = 5000;
			if(cnts[i - 3] > 0) {
				cnt = cnts[i - 3] + 1;
			}
			if(cnts[i - 5] > 0) {
				cnt = Math.min(cnt, cnts[i - 5] + 1);
			}
			cnts[i] = (cnt > 0 && cnt != 5000) ? cnt : -1;
		}

		System.out.println(cnts[N]);
	}
}
