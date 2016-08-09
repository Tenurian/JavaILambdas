package stuff;

public class EnumFun {

	@SuppressWarnings("unused")
	private enum Weekday {
		SUNDAY,
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY;
		static {
			SUNDAY.yesterday = SATURDAY;
			MONDAY.yesterday = SUNDAY;
			TUESDAY.yesterday = MONDAY;
			WEDNESDAY.yesterday = TUESDAY;
			THURSDAY.yesterday = WEDNESDAY;
			FRIDAY.yesterday = THURSDAY;
			SATURDAY.yesterday = FRIDAY;
			
			SUNDAY.tomorrow = MONDAY;
			MONDAY.tomorrow = TUESDAY;
			TUESDAY.tomorrow = WEDNESDAY;
			WEDNESDAY.tomorrow = THURSDAY;
			THURSDAY.tomorrow = FRIDAY;
			FRIDAY.tomorrow = SATURDAY;
			SATURDAY.tomorrow = SUNDAY;
		}
		
		private Weekday tomorrow;
		private Weekday yesterday;
		
		public Weekday getYesderday(){
			return this.yesterday;
		}
		public Weekday getTomorrow(){
			return this.tomorrow;
		}
	}

	public static void main(String[] args) {

		Weekday[] week = {
				Weekday.SUNDAY,
				Weekday.MONDAY,
				Weekday.TUESDAY,
				Weekday.WEDNESDAY,
				Weekday.THURSDAY,
				Weekday.FRIDAY,
				Weekday.SATURDAY,
		};
		for(Weekday day : week){
			System.out.println("If today is " + day.toString() + ", then yesterday was " + day.yesterday.toString() + ", and tomorrow is " + day.tomorrow.toString());
		}
	}

}
