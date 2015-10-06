package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import domain1.DataSource;

public class FootballGoalsSource implements DataSource {

	@Override
	public String getName() {
		return "antal mål per match i fotbollsallsvenskan";

	}

	@Override
	public String getUnit() {

		return "antal mål";
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<LocalDate, Double> getData() {

		UrlFetcher fetcher = new UrlFetcher(
				"http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=20");
		JsonToMapParser parser = new JsonToMapParser(fetcher.getContent());
		Map<String, Object> data = parser.getResult();
		List<Map> events = (List<Map>) data.get("events");

		Map<LocalDate, Double> result = new TreeMap<LocalDate, Double>();

		for (Map event : (List<Map>) events) {
	
			LocalDate date = LocalDate.parse(event.get("startDate").toString()
					.substring(0, 10));
			int goals = Integer.parseInt(event.get("visitingTeamScore").toString());
		
			goals += Integer.parseInt(event.get("homeTeamScore").toString());

			addGoalsToMap(result, date, goals);
			
		}

		return result;
	}

	private void addGoalsToMap(Map<LocalDate, Double> result, LocalDate date,
			int goals) {
		if (!result.containsKey(date)) {
			result.put(date, new Double(goals));
		} else {
			result.put(date, new Double(goals) );
		}

	}

	public static void main(String[] args) {
	
		System.out.println(new FootballGoalsSource().getData());

	}

}
