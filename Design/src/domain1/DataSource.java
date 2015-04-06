package domain1;



import java.time.LocalDate;
import java.util.Map;


public interface DataSource {
	
	String getName();
	
	String getUnit();
	
	Map <LocalDate, Double> getData();

}


