package domain1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

		Map<String, DataPair> dateMap = new HashMap();

		for (LocalDate date1 : source1.getData().keySet()) {

			for (LocalDate date2 : source2.getData().keySet()) {
				if (isMatching(date1, date2)) {
					System.out.println("matchad");

					DataPair pair1 = new DataPair(source1.getData().get(date1),
							source2.getData().get(date2));

					dateMap.put(date1.toString(), pair1);
					System.out.println("date i Paret efter matchning"
							+ date1.toString());

					System.out.println("storlek Par " + dateMap.size());

				}

			}
		}

		MatchedData matched = new MatchedData("", source1.getUnit(),
				source2.getUnit(), dateMap);
		return matched;
	}

}
