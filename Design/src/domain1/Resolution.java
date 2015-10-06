package domain1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public enum Resolution {
	DAY {

		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			return d1.equals(d2);
		}
		
		@Override
		public String formatDate(LocalDate d1) {
			return d1.toString().substring(0, 10);
		}
	},

	WEEK {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			WeekFields week = WeekFields.of(Locale.getDefault());

			return d1.get(week.weekOfWeekBasedYear()) == d2.get(week.weekOfWeekBasedYear());
		}

		@SuppressWarnings("static-access")
		@Override
		public String formatDate(LocalDate d1) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(d1.toString());
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				
				if(cal.get(cal.WEEK_OF_YEAR) < 10){
					return d1.toString().substring(0, 4) + "-"+ "W-0" + cal.get(cal.WEEK_OF_YEAR);
				}else{
					return d1.toString().substring(0, 4) + "-" + "W-" + cal.get(cal.WEEK_OF_YEAR);
				}
				
			} catch (ParseException e) {
			
			}
			return null;
		}
		
	},

	MONTH {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			
			return d1.getMonth().equals(d2.getMonth());
		}
		@Override
		public String formatDate(LocalDate d1) {
			return d1.toString().substring(0, 7);
		}

	},
	QUARTER {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
			
			int first = (d1.getMonthValue() -1) /3;
			int second = (d2.getMonthValue() -1) /3;
			
			return first == second;
		}
		@Override
		public String formatDate(LocalDate d1) {
			int month;
			month = Integer.parseInt(d1.toString().substring(5, 7));
			return d1.toString().substring(0, 4) + "-Q" + ((month + 2) / 3);
		}

	},
	YEAR {
		@Override
		public boolean isMatched(LocalDate d1, LocalDate d2) {
		
			return d1.getYear() == (d2.getYear());
		}
		@Override
		public String formatDate(LocalDate d1) {
			return d1.toString().substring(0, 4);
		}

	};

	public boolean isMatched(LocalDate d1, LocalDate d2) {
		// TODO Auto-generated method stub
		return false;
	}
	public abstract String formatDate(LocalDate d1);

}
