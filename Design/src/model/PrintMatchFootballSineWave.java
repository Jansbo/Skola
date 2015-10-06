package model;


import domain1.DataMatcher;
import domain1.MatchedData;
import domain1.Resolution;

public class PrintMatchFootballSineWave {
	
		public static void main(String[] args) {
			
			FootballGoalsSource football = new FootballGoalsSource();
			SineWave sineWave = new SineWave();
			
			System.out.println("DataSource from FootballGoals :" + football.getData());
			System.out.println("DataSource from SineWave :" + sineWave.getData());
	
			
			DataMatcher dayMatcher = new DataMatcher(football, sineWave, Resolution.DAY);
			MatchedData matchedData = dayMatcher.matchData();
			System.out.println("Source Match on Day:");
			System.out.println(matchedData.getData().toString());
	
			
			DataMatcher weekMatcher = new DataMatcher(football, sineWave, Resolution.WEEK);
			MatchedData matchedData2 = weekMatcher.matchData();
			System.out.println("Source Match on Week:");
			System.out.println(matchedData2.getData().toString());
			
	
			DataMatcher monthMatcher = new DataMatcher(football, sineWave, Resolution.MONTH);
			MatchedData matchedData3 = monthMatcher.matchData();
			System.out.println("Source Match on Month:");
			System.out.println(matchedData3.getData().toString());
		
	
			DataMatcher quarterMatcher = new DataMatcher(football, sineWave, Resolution.QUARTER);
			MatchedData matchedData4 = quarterMatcher.matchData();
			System.out.println("Source Match on Quarter:");
			System.out.println(matchedData4.getData().toString());
			
		
			DataMatcher yearMatcher = new DataMatcher(football, sineWave, Resolution.YEAR);
			MatchedData matchedData5 = yearMatcher.matchData();
			System.out.println("Source Match on Year:");
			System.out.println(matchedData5.getData().toString());
		}
		
	}


