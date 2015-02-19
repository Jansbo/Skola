package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FootballGoalsSource implements DataSurce{

	@Override
	public String getName() {
		return "antal mål per match i fotbollsallsvenskan";
	
	}

	@Override
	public String getUnit() {
		
		return "antal mål";
	}

	@Override
	public Map<Date, Double> getData() {
		UrlFetcher fetcher = new UrlFetcher();
		JsonToMapParser parser = new JsonToMapParser(fetcher.getContent());
		Map<String, Object> data = parser.getResult();
		List<Map> events = (List) data.get("events");
		
		Map <LocalDate, Double> result = new TreeMap();
		for (Map event : (List<Map>) data.get("events") ){
			LocalDate date = LocalDate.parse(event.get("startDate").toString().substring(0, 10));
			int goals = Integer.parseInt(event.get("visitingTeam").toString());
			goals+= Integer.parseInt(event.get("homeTeamScore").toString());
			addGoalsToDate(result, date, goals);
		}
		
		return null;
	}
	

	private void addGoalsToDate(Map<LocalDate, Double> result, LocalDate date,
			int goals) {
		if(!result.containsKey(date)){
			result.put(date, new Double(goals));
		} else{
			result.put(date, result.get(date) + goals);
		}
		
	}

	public static void main(String[] args){
		System.out.println(new FootballGoalsSource().getData());
		
	}

	

}
