package day250403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소민지_BOJ_1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		if(N == 1) {
			System.out.println(0);
			return;
		}
		if(N == 2) {
			System.out.println(1);
			return;
		}

		int[] cnts = new int[N + 1];
		cnts[1] = 0;
		cnts[2] = 1;
		cnts[3] = 1;

		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			cnt = cnts[i - 1] + 1;
			if (i % 3 == 0) {
				cnt = Math.min(cnt, cnts[i / 3] + 1);
			}
			if (i % 2 == 0) {
				cnt = Math.min(cnt, cnts[i / 2] + 1);
			}
			cnts[i] = cnt;
		}

		System.out.println(cnts[N]);
	}
}
