package various;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class ReadingsRetrieval {
	
	private static SortedMap<Long, Float> readingsTree = new TreeMap<>();
	//private static Map<Integer, Float> readingsLinked = new LinkedHashMap<>();
	
	public static void addReading(long time, float value) {
		if(time > 0) {
			readingsTree.put(time, value);
			//readingsLinked.put(time, value);
		}
	}
	
	public static List<Float> getReadings(long from, long to) {
		List<Float> results = new ArrayList<>();
		//boolean inRange = false;
		
		for(Float value : readingsTree.subMap(from, to).values()) {
			results.add(value);
		}
		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addReading(Calendar.getInstance().getTimeInMillis(), 2.2f);
		
		long timeHere = Calendar.getInstance().getTimeInMillis()+300;
		addReading(timeHere, 2.12f);
		addReading(Calendar.getInstance().getTimeInMillis()+400, 3.3f);
		addReading(Calendar.getInstance().getTimeInMillis()+500, 2.4f);
		addReading(Calendar.getInstance().getTimeInMillis()+600, 2.5f);
		long timeThere = Calendar.getInstance().getTimeInMillis()+700;
		addReading(timeThere, 2.6f);
		addReading(Calendar.getInstance().getTimeInMillis()+800, 2.8f);
		
		List<Float> results = getReadings(timeHere, timeThere+1);
		
		System.out.println(String.valueOf(results));
		
	}
	
	

}
