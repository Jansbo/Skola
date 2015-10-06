package domain1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class DataMatcher {

	private final DataSource source1;
	private final DataSource source2;
	private final Resolution resolution;

	public DataMatcher(DataSource source1, DataSource source2,
			Resolution resolution) {
		this.source1 = source1;
		this.source2 = source2;
		this.resolution = resolution;
	}

	protected boolean isMatching(LocalDate d1, LocalDate d2) {
		return resolution.isMatched(d1, d2);
	}

	public MatchedData matchData() {

		Map<String, DataPair> dateMap = new HashMap<String, DataPair>();
		Map<LocalDate, Double> dataSource1 = source1.getData();
		Map<LocalDate, Double> dataSource2 = source2.getData();
		for (LocalDate date1 : dataSource1.keySet()) {

			for (LocalDate date2 : dataSource2.keySet()) {
				if (isMatching(date1, date2)) {
					DataPair dataPair = new DataPair(averageCalcWhenMultipleMatches(dataSource1, date1),
						averageCalcWhenMultipleMatches(dataSource2, date2));

					dateMap.put(resolution.formatDate(date1), dataPair);
				}
			}
		}
		MatchedData matched = new MatchedData("", source1.getUnit(),
				source2.getUnit(), dateMap);
		return matched;
	}
	
	private Double averageCalcWhenMultipleMatches(Map<LocalDate, Double> data, LocalDate date){
		int extraMatchCounter = 0;
		Double value = 0.0;
		for (LocalDate date1 : data.keySet()) {
			if (isMatching(date1, date)) {
				value += data.get(date1);
				extraMatchCounter++;
			}
		}		
		return value / extraMatchCounter;
	}

}
