package day250403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소민지_BOJ_14916_거스름돈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		if (N == 1 || N == 3) {
			System.out.println(-1);
			return;
		}

		int cnt;

		if (N % 5 == 0) {
			cnt = N / 5;
		} else if (N % 5 % 2 == 1) {
			cnt = N / 5 - 1;
			cnt += (N - 5 * cnt) / 2;
		} else {
			cnt = N / 5;
			cnt += (N % 5) / 2;
		}

		System.out.println(cnt);
	}
}
