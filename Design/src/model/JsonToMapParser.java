package model;

import java.util.Map;

import com.owlike.genson.Genson;

public class JsonToMapParser {

	private final String json;
	
	public JsonToMapParser(String jSon){
		this.json = jSon;
		
	}
	@SuppressWarnings("unchecked")
	public  Map <String, Object> getResult() {
		return new Genson().deserialize(json, Map.class);
	}
}
