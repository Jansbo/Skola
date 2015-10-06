package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JsonToMapParserTest {
	JsonToMapParser parser;

	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testEmptyMap() {

		parser = new JsonToMapParser("{}");
		assertEquals(parser.getResult().size(), 0);
	}

	@Test
	public void testInsertOneObjectInMap() {
		parser = new JsonToMapParser("{ \"keyOne\":\"valueOne\"}");
		assertEquals(parser.getResult().size(), 1);
	}

	@Test
	public void testInsertFiveObjectsInMap() {
		parser = new JsonToMapParser(
				"{ \"keyOne\":\"valueOne\",\"keyTwo\":\"valueTwo\",\"keyThree\":\"valueThree\",\"keyFour\":\"valueFour\""
						+ ",\"keyFive\":\"valueFive\"}");
		assertEquals(parser.getResult().size(), 5);

	}

	@Test
	public void testFindValueInMap() {
		parser = new JsonToMapParser(
				"{ \"keyOne\":\"valueOne\",\"keyTwo\":\"valueTwo\",\"keyThree\":\"valueThree\"}");
		assertEquals("valueTwo", parser.getResult().get("keyTwo"));
	}

}
