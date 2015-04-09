package domain1;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public enum Resolution {
	DAY {

		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			return d1.equals(d2);
		}
	},

	WEEK {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			WeekFields week = WeekFields.of(Locale.getDefault());

			return d1.get(week.weekOfWeekBasedYear()) == d2.get(week.weekOfWeekBasedYear());

		}

	},

	MONTH {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			
			
			return d1.getMonth().equals(d2.getMonth());
		}

	},
	QUARTER {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			
			int first = (d1.getMonthValue() -1) /3;
			int second = (d2.getMonthValue() -1) /3;
			

			return first == second;
		}

	
		


	},
	YEAR {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
		
			return d1.getYear() == (d2.getYear());

		}

	};

	public boolean isMatched(LocalDate d1, LocalDate d2) {
		// TODO Auto-generated method stub
		return false;
	}

}
