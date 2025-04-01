package 기출1_3.clock;

class Solution {
	// 1초에 6도
	static double sSpeed = 6;
	static double mSpeed = sSpeed / 60;
	static double hSpeed = mSpeed / 12;

	public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
		int startTime = (h1 * 60 * 60) + (m1 * 60) + s1;
		double startH = hSpeed * ((h1 * 60 * 60) + (m1 * 60) + s1);
		double startM = mSpeed * ((m1 * 60) + s1);
		double startS = sSpeed * s1;
		
		int endTime = (h2 * 60 * 60) + (m2 * 60) + s2;
		double endH = hSpeed * ((h2 * 60 * 60) + (m2 * 60) + s2);
		double endM = mSpeed * ((m2 * 60) + s2);
		double endS = sSpeed * s2;

		boolean lastHourMin = startH > startM ? true : false;
		boolean lastMinSec = startM > startS ? true : false;
		boolean lastSecHour = startS > startH ? true : false;
		
		boolean currHourMin = lastHourMin;
		boolean currMinSec = lastMinSec;
		boolean currSecHour = lastSecHour;
		
		int current = startTime;
		double currH = startH;
		double currM = startM;
		double currS = startS;
		
		int alarm = 0;
		while(current <= endTime) {
			currHourMin = currH >= currM ? true : false;
			currMinSec = currM >= currS ? true : false;
			currSecHour = currS >= currH ? true : false;
			if(lastHourMin != currHourMin) {
				alarm++;
			}
			if(lastMinSec != currMinSec) {
				alarm++;
			}
			if(lastSecHour != currSecHour) {
				alarm++;
			}
			
			lastHourMin = currHourMin;
			lastMinSec = currMinSec;
			lastSecHour = currSecHour;
			
			currH += hSpeed;
			if(currH > 360) {
				currH -= 360;
			}
			
			currM += mSpeed;
			if(currM > 360) {
				currM -= 360;
			}
			
			currS += sSpeed;
			if(currS > 360) {
				currS -= 360;
			}
			
			current++;
		}
		
		if(0 == startTime) {
			alarm -= 2;
		}
		if(43200 >= startTime && 43200 <= endTime) {
			alarm -= 2;
		}
		
		return alarm;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(0, 5, 30, 0, 7, 0));
		System.out.println(solution(12, 0, 0, 12, 0, 30));
		System.out.println(solution(0, 6, 1, 0, 6, 6));
		System.out.println(solution(11, 59, 30, 12, 0, 0));
		System.out.println(solution(11, 58, 59, 11, 59, 0));
		System.out.println(solution(1, 5, 5, 1, 5, 6));
		System.out.println(solution(0, 0, 0, 23, 59, 59));
	}
}