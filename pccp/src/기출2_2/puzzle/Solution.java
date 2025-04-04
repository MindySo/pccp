package 기출2_2.puzzle;
import java.util.*;

class Solution {
    public static int solution(int[] diffs, int[] times, long limit) {
        // [diff, time_cur, time_prev]
        PriorityQueue<int[]> que = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[]o2){
                return o2[0] - o1[0];
            }
        });
        
        long spentTime = times[0];
        que.add(new int[] {diffs[0], times[0]});
        
        for(int i = 1 ; i < diffs.length ; i++){
            que.add(new int[] {diffs[i], times[i] + times[i-1]});
            spentTime += times[i];
        }

        int[] next = que.poll();
        long level = next[0];
        
        int cre = 0;
        int next_diff = next[0];
        int next_time = next[1];

        while(level > 0){
//    		System.out.println("level : " + level);
//    		System.out.println("cre : " + cre);
//    		System.out.println("spentTime : " + spentTime);
//    		System.out.println("next : " + next[0] + ", " + next[1]);
//    		System.out.println();
        	
        	if(spentTime + cre > limit){
        		break;    
        	}
        	
        	spentTime += cre;
        	while(!que.isEmpty() && next_diff == level) {
        		cre += next_time;
        		next = que.poll();
        		next_diff = next[0];
        		next_time = next[1];
        	}
        	level--;
        }
        
        return (int)(level + 1);
    }
    public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 5, 3}, new int[] {2, 4, 7}, 30));
		System.out.println("-----------------------------------------");
		System.out.println(solution(new int[] {1, 4, 4, 2}, new int[] {6, 3, 8, 2}, 59));
		System.out.println("-----------------------------------------");
		System.out.println(solution(new int[] {1, 99999, 100000, 99995}, new int[] {9999, 9001, 9999, 9001}, 3456789012l));
		System.out.println("-----------------------------------------");
    	System.out.println(solution(new int[] {1, 100000}, new int[] {1, 1}, 3));
    	System.out.println("-----------------------------------------");
	}
}