import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo2_서울_11_소민지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력값을 처리할 br과 st 선언 및 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// T에 테스트 케이스의 개수를 받고 T만큼 반복하여 수행
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			
			// N, M 선언 및 값 저장
			int N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());
			
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

			// BFS에 사용할 que, 방문배열 visited 선언, 정답을 저장할 ans, 촌 수를 셀 cnt 선언 및 초기화
			Queue<int[]> que = new LinkedList<>();
			boolean[] visited;
			int ans = 0;
			int cnt = 0;
			
			// 임시 값을 담을 temp, currNode, currCnt 선언
			int[] temp;
			int currNode;
			int currCnt;

			// 사람 수 만큼 BFS 실행
			for (int i = 1; i <= N; i++) {

				// 새로운 사람으로 넘어갈 때마다 visited, cnt 초기화
				visited = new boolean[N + 1];
				cnt = 0;

				// que에 현재 사람, 촌 수를 담은 배열을 추가
				que.add(new int[] {i, 0});

				// 해당 좌표 방문처리
				visited[i] = true;

				// BFS 실행
				while (!que.isEmpty()) {
					temp = que.poll();
					// poll한 값의 첫 번째는 사람, 두 번째는 촌 수이므로 각각 저장
					currNode = temp[0];
					currCnt = temp[1];

					if (currCnt > 3) {
						// 촌 수가 3 초과일 경우 실행 중단
						break;
					}else if(currCnt == 3) {
						// 촌 수가 3일 경우 ans 증가
						ans++;
					}
					
					// i와 연결된 관계들에 대해 모두 실행
					for(int next : list[currNode]) {
						// 방문하지 않은 사람일 경우
						if (!visited[next]) {
							// next와 next에 대한 촌수를 +1하여 큐에 담음
							que.add(new int[] {next, currCnt + 1});
							// 방문 처리
							visited[next] = true;
						}
					}
				}
			}
			
			// ans는 각 관계를 중복하여 두번씩 세었으므로 /2
			ans /= 2;
			
			// 정답 출력
			System.out.println("#" + tc + " " + ans);
		}
	}
}
