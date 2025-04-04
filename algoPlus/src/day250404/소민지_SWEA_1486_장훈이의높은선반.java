package day250404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 소민지_SWEA_1486_장훈이의높은선반 {
	static List<Integer> height;
	static int B;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			height = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			for (int i = 0; i < N; i++) {
				height.add(arr[i]);
				if (arr[i] > B) {
					break;
				}
			}
			ans = Integer.MAX_VALUE;
				comb(0, 0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void comb(int sum, int idx) {
		if(sum >= B && ans > sum - B) {
			ans = sum - B;
		}
		if(idx >= height.size()) {
			return;
		}
		
		comb(sum, idx + 1);
		comb(sum + height.get(idx), idx + 1);
	}

}
