package domain1;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public enum Resolution {
	DAY {

		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			System.out.println("DAY");
			return d1.equals(d2);
		}
	},

	WEEK {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
		
			System.out.println("WEEK");
			WeekFields week = WeekFields.of(Locale.getDefault());
//
			System.out.println(d1.get(week.weekOfWeekBasedYear()));
			System.out.println(d2.get(week.weekOfWeekBasedYear()));
		
			return d1.get(week.weekOfWeekBasedYear()) == d2.get(week.weekOfWeekBasedYear());

		}

	},

	MONTH {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			System.out.println("MONTH");
			
			return d1.getMonth().equals(d2.getMonth());
		}

	},
	QUARTER {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			System.out.println("QUARTER");
			System.out.println(d1.getMonth().toString());
			System.out.println(d2.getMonth().toString());
			boolean check;
			int first = d1.getMonthValue() /3;
			int second = d2.getMonthValue() /3;
			
//			if( first > 0 < 1 && second > 0 < 1){
//				check = true;
//				if ( first > 1 <= 1 && second > 1 <= 1 ){
//					return true;
//
//					if (first > 2 <= 3 && second > 2 <= 3 ){
//						return true;
//			}
//					if (first > 3 <= 4 && second > 3 <= 4 ){
//						return true;
//			}
			return d1.getMonth().equals(d2.getMonth());
		}

	
		


	},
	YEAR {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			System.out.println("YEAR");
			System.out.println(d1.getYear());
			System.out.println(d2.getYear());
			return d1.getYear() == (d2.getYear());

		}

	};

	public boolean isMatched(LocalDate d1, LocalDate d2) {
		// TODO Auto-generated method stub
		return false;
	}

}
