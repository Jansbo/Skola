package domain1;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

public class DataMatcherTest {

	LocalDate date1;
	LocalDate date2;
	DataMatcher matcher;

	private DataSource source1 = new DataSource() {
		@Override
		public String getName() {
			return "First Data Name";
		}

		@Override
		public String getUnit() {
			return "First Data Unit";
		}

		@Override
		public Map<LocalDate, Double> getData() {

			Map<LocalDate, Double> result = new HashMap<>();
			LocalDate local1 = LocalDate.parse("2012-11-11");
			LocalDate local2 = LocalDate.parse("2012-10-11");
			LocalDate local3 = LocalDate.parse("2012-09-11");
			LocalDate local4 = LocalDate.parse("2011-01-03");
			result.put(local1, 2.2);
			result.put(local2, 2.2);
			result.put(local3, 2.2);
			result.put(local4, 2.2);

			return result;
		}
	};

	private DataSource source2 = new DataSource() {

		@Override
		public String getName() {
			return "Second Data Name";
		}

		public String getUnit() {
			return "Second Data Unit";
		}

		@Override
		public Map<LocalDate, Double> getData() {
			Map<LocalDate, Double> result = new HashMap<LocalDate, Double>();
			LocalDate local1 = LocalDate.parse("2012-11-11");
			LocalDate local2 = LocalDate.parse("2012-10-11");
			LocalDate local3 = LocalDate.parse("2012-09-11");
			LocalDate local4 = LocalDate.parse("2011-01-05");
			result.put(local1, 1.2);
			result.put(local2, 1.2);
			result.put(local3, 1.2);
			result.put(local4, 1.2);
			return result;
		}
	};

	@Before
	public void setUp() throws Exception {
		matcher = new DataMatcher(source1, source2, Resolution.DAY);

	}

	//@Test
	public void testMatching() {

		System.out.println("source1 " + source1.getData().keySet().toString());
		System.out.println("source2 " + source2.getData().keySet().toString());

		Map<String, DataPair> pair = matcher.matchData().getData();
		System.out.println("storlek restultat Test " + pair.size());
		assertEquals(new Double(1.2), pair.get("2012-11-11").getY());
		assertEquals(new Double(2.2), pair.get("2012-11-11").getX());

		assertEquals(new Double(1.2), pair.get("2012-09-11").getY());
		assertEquals(new Double(2.2), pair.get("2012-09-11").getX());
	}

	@Test
	public void testResolutionWeek() {
		matcher = new DataMatcher(source1, source2, Resolution.WEEK);
		assertTrue(matcher.isMatching(LocalDate.parse("2012-01-02"), LocalDate.parse("2012-01-07")));
		assertFalse(matcher.isMatching(LocalDate.parse("2013-02-02"), LocalDate.parse("2013-02-20")));

	}
	
	@Test
	public void testResolutionMonth(){
		matcher = new DataMatcher(source1, source2, Resolution.MONTH);
		assertTrue(matcher.isMatching(LocalDate.parse("2012-02-02"), LocalDate.parse("2012-02-07")));
		assertFalse(matcher.isMatching(LocalDate.parse("2013-06-02"), LocalDate.parse("2013-08-20")));
	}
	
	@Test 
	public void testResolutionYear(){
		matcher = new DataMatcher(source1, source2, Resolution.YEAR);
		assertTrue(matcher.isMatching(LocalDate.parse("2012-02-02"), LocalDate.parse("2012-02-07")));
		assertFalse(matcher.isMatching(LocalDate.parse("2013-06-02"), LocalDate.parse("2014-08-20")));
	}
}