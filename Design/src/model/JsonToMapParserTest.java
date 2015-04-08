package model;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import domain1.DataMatcher;
import domain1.DataPair;
import domain1.Resolution;

public class JsonToMapParserTest {
	SineWave sine;
	FootballGoalsSource football;
	DataMatcher matcher;
	
	
	@Before
	public void setUp() throws Exception {

	sine = new SineWave();
	football = new FootballGoalsSource();
	
	}

	@Test
	public void testSineWave(){
		
		//System.out.println(sine.getData().toString());
		//System.out.println(football.getData().toString());
		
		
	}
	@Test
	public void testMatcher(){
		Map <String, DataPair> pair = new HashMap <String, DataPair>();
		 matcher = new DataMatcher(sine, football, Resolution.YEAR);
		pair = matcher.matchData().getData();
		
			//	System.out.println("pairData test  " + matcher.matchData().getData().toString());
		//System.out.println("Pair  "  +pair.get("2014-05-01").toString());
		assertEquals(new Double(7.0), pair.get("2014-11-01").getY() );
		assertEquals(new Double(7.0), pair.get("2014-12-01").getY() );
		assertEquals(new Double(7.0), pair.get("2014-12-01").getX() );
		
		
	}
}
