package model;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class SineWave implements DataSource {

	@Override
    public String getName() {
	        return "sinewave";
    }

    @Override
    public String getUnit() {
        return "undefined";
	    }

    @Override
    public Map<LocalDate, Double> getData() {
        Map<LocalDate, Double> result = new TreeMap<>();
        for (int year = 2012; year < 2015; year++) {
        	for (int month = 1; month < 13; month++) {
	              LocalDate key = LocalDate.of(year, month, 1);
	              result.put(key, Math.sin((key.toEpochDay() - 10957.) / 80.));
	            }
	        }
	        return result;
	    } 
	
}
