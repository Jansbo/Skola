package domain1;

import java.time.LocalDate;


public class KeyValuePair {

	
	private final LocalDate key;
	private final double value;
	
	public KeyValuePair (LocalDate key, double value){
		this.key = key;
		this.value = value;
	}
	
	public LocalDate getKey() {
		return key;
		
	}
	
	public double getValue() {
		return value;
	}

}


