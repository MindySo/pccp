package 기출1_1.bandage;

class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {
		int answer = health;

		int maxHealth = health;
		int healCycle = bandage[0];
		int heal = bandage[1];
		int healPlus = bandage[2];
		int tryNum = 0;

		int idx = 0;
		int attackIdx = 0;
		int attackTime;
		int damage;

		while (true) {
			if (attackIdx >= attacks.length) {
				break;
			}
			attackTime = attacks[attackIdx][0];
			damage = attacks[attackIdx][1];

			if (idx == attackTime) {
				answer -= damage;
				if (answer <= 0) {
					answer = -1;
					break;
				}
				
				tryNum = 0;
				attackIdx++;
			} else {
				answer += heal;
				tryNum++;

				if (tryNum == healCycle) {
					answer += healPlus;
					tryNum = 0;
				}

				if (answer > maxHealth) {
					answer = maxHealth;
				}
			}
			idx++;
		}

		return answer;
	}
}