package domain1;

import java.util.Map;

import domain1.DataPair;

public class MatchedData {
	private final String yUnit;
	private final String xUnit;
	private final String name;
	private final Map <String, DataPair> collection;
	
	public MatchedData (String y, String x, String name, Map<String, DataPair> collection){
		this.yUnit = y;
		this.xUnit = x;
		this.name = name;
		this.collection = collection;
	}

	public String getName(){
		return name;
		
	}
	public String getXUnit(){
		return xUnit;
		
	}
	public String getYUnit(){
		return yUnit;
		
	}
	public Map <String, DataPair>getData(){
	return collection;	
	}

}
