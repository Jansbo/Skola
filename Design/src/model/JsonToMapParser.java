package model;

import java.util.Map;

public class JsonToMapParser {

	private final String json;
	
	public JsonToMapParser(String jSon){
		this.json = jSon;
		
	}
	public  Map <String, Object> getResult() {
		return new Genson().deserialize(json, Map.class);
	}
}
