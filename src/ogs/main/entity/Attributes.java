package ogs.main.entity;

public class Attributes {

		public static final String ATTRIBUTE = "Attribute";
	
		private int defense;
		private int endurance;
		private int intelligence;
		private int power;
		//TODO make attribute a different class
		public Attributes(int defense, int endurance, int intelligence, int power) {
			this.defense = defense;
			this.endurance = endurance;
			this.intelligence = intelligence;
			this.power = power;
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
		
		public static enum Attribute {
			DEFENSE(0),
			ENDURANCE(1),
			INTELLIGENCE(2),
			POWER(3);
			
			private int type;
			
			private Attribute(int type) {
				this.type = type;
			}
			
			public int getAttribute() {
				return type;
			}
		}
}
