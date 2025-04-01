import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo3_서울_11_소민지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력값을 처리할 br과 st 선언 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// T에 테스트 케이스의 개수를 받고 T만큼 반복하여 수행
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			// N, M, P 선언 및 값 저장
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			// 관계 리스트 배열 list 선언
			List<Integer>[] list = new ArrayList[N + 1];

			// 배열 크기만큼 리스트 초기화
			for (int i = 0; i < N + 1; i++) {
				list[i] = new ArrayList<>();
			}

			// 입력값을 저장할 temp1, temp2 선언
			int temp1;
			int temp2;

			// M만큼 입력값을 받음
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				temp1 = Integer.parseInt(st.nextToken());
				temp2 = Integer.parseInt(st.nextToken());

				// temp1의 관계 리스트에 temp2 저장
				list[temp1].add(temp2);
				// temp2의 관계 리스트에 temp1 저장
				list[temp2].add(temp1);
			}

			// BFS에 사용할 que, 방문배열 visited, 정답을 저장할 ans, 거리 최댓값을 저장할 max 선언 및 초기화
			Queue<int[]> que = new LinkedList<>();
			boolean[] visited = new boolean[N + 1];
			int ans = 0;
			int max = 0;
			
			// 임시 값을 담을 temp, currNode, currCnt 선언
			int[] temp;
			int currNode;
			int currCnt;

			// que에 {P, 거리} 배열을 추가
			que.add(new int[] { P, 0 });

			// P 방문처리
			visited[P] = true;

			// BFS 실행 : que가 빌 때까지
			while (!que.isEmpty()) {
				temp = que.poll();
				// poll한 값의 첫 번째는 node, 두 번째는 거리이므로 각각 저장
				currNode = temp[0];
				currCnt = temp[1];

				// 거리가 최댓값을 갱신했을 경우 max값 갱신 및 ans 초기화
				if (currCnt > max) {
					max = currCnt;
					ans = 0;
				}

				// 겹치는 최댓값이 max 이상일 경우 ans 증가
				if (currCnt >= max) {
					ans++;
				}

				// 현재 노드와 연결된 노드들에 대해 모두 실행
				for (int next : list[currNode]) {
					// 방문하지 않은 노드일 경우
					if (!visited[next]) {
						// next, 거리 + 1을 큐에 담음
						que.add(new int[] { next, currCnt + 1 });
						// 방문 처리
						visited[next] = true;
					}
				}
			}
			
			// 정답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}
