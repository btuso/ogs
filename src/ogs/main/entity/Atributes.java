package ogs.main.entity;

public class Atributes {

		private int defense;
		private int endurance;
		private int intelligence;
		private int power;
		
		public Atributes() {
			// TODO Auto-generated constructor stub
		}
		
		public int getDefense() {
			return defense;
		}

		public void increaseDefenseBy(int defense) {
			this.defense = defense;
		}

		public void increaseDefense() {
			increaseDefenseBy(1);
		}
		
		
		public int getEndurance() {
			return endurance;
		}

		public void increaseEnduranceBy(int endurance) {
			this.endurance = endurance;
		}

		public void increaseEndurance() {
			increaseEnduranceBy(1);
		}
		
		
		public int getIntelligence() {
			return intelligence;
		}

		public void increaseIntelligenceBy(int intelligence) {
			this.intelligence = intelligence;
		}

		public void increaseIntelligence() {
			increaseIntelligenceBy(1);
		}
		
		
		public int getPower() {
			return power;
		}

		public void increasePowerBy(int power) {
			this.power = power;
		}
		
		public void increasePower() {
			increasePowerBy(1);
		}
		
}
