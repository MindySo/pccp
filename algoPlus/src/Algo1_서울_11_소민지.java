import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_서울_11_소민지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력값을 처리할 br과 st 선언 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// T에 테스트 케이스의 개수를 받고 T만큼 반복하여 수행
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			// N에 색종이의 개수를 담음
			int N = Integer.parseInt(br.readLine().trim());

			// 30 x 30 사이즈로 배열 선언
			int[][] map = new int[30][30];

			// 색종이의 좌표를 담을 r, c선언
			int r;
			int c;

			// 겹치는 최댓값을 담을 max, 정답을 저장할 ans 선언 및 초기화
			int max = 0;
			int ans = 0;

			for (int n = 0; n < N; n++) {
				// N만큼 반복하여 입력값을 받아 색종이의 위치를 저장
				st = new StringTokenizer(br.readLine());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				// 오른쪽, 아래로 다섯칸만큼 반복
				for (int i = r; i < r + 5; i++) {
					for (int j = c; j < c + 5; j++) {
						// map의 좌표를 증가하여 색종이가 겹치는 수 저장
						map[i][j]++;

						// 겹치는 최댓값을 갱신했을 경우 max값 갱신 및 ans 초기화
						if (map[i][j] > max) {
							max = map[i][j];
							ans = 0;
						}

						// 겹치는 최댓값이 max 이상일 경우 ans 증가
						if (map[i][j] >= max) {
							ans++;
						}
					}
				}
			}
			
			// 정답 출력
			System.out.println("#" + tc + " " + max + " " + ans);
		}
	}
}
