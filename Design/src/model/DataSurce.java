package model;

import java.util.Date;
import java.util.Map;

public interface DataSurce {

	String getName();
	
	String getUnit();
	
	Map <Date, Double> getData();

}
