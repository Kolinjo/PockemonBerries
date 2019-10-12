package marko.kozic;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import jdk.nashorn.api.scripting.JSObject;

public class BerryUtillities {
	
	private static String rootURL = "https://pokeapi.co/api/v2/berry";
	
	
	public static String makingConnection (String URL) throws IOException {
		URL request = new URL(URL);
		InputStream openStream = request.openStream();
		String response = IOUtils.toString(openStream, "UTF-8");
		return response;
	}
	

	public static ArrayList<Berry> collectingBerries () throws IOException{
		JSONObject root = new JSONObject(makingConnection(rootURL));
		int numberOfBerries = (int) root.get("count");
		int count = 1;
		
		ArrayList<Berry> berries = new ArrayList<Berry>();
		for (int i = 0; i < numberOfBerries; i++) {
			String url = rootURL + "/" + count + "/";
			
						
			JSONObject root1 = new JSONObject(makingConnection(url));
			
			String name = root1.getString("name");
			int growthTime = root1.getInt("growth_time");
			int size = root1.getInt("size");
			
			berries.add(new Berry(name, size, growthTime));
			count++;
			
		}
		return berries;					
	}
	
	 public static int findMinGrowthTime(ArrayList<Berry> berries) {

         return berries.stream().min(Comparator.comparingInt(Berry :: getGrowthTimeOfBerry)).get().getGrowthTimeOfBerry();

 }
	 public static String findBerryWithMaxSize (ArrayList<Berry> berries) {
		 
		 int berryWithMinTime = findMinGrowthTime(berries);
		 
		return berries.stream().filter(berry-> berry.getGrowthTimeOfBerry() == berryWithMinTime)
				.max(Comparator.comparingInt(Berry :: getSizeOfBerry)).get().getNameOfBerry();
		 
	 }
	

	public static void main(String[] args) throws IOException {
		ArrayList<Berry> berries = collectingBerries();
		
		System.out.println(berries);
		System.out.println(findMinGrowthTime(berries));
		System.out.println("The largest berry that can grow in the shortest time is berry " + 
		findBerryWithMaxSize(berries) );

	}
}
