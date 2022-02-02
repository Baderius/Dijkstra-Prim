import java.util.HashSet;


import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraSP {
	/**
	 * 
	 * @param anatolianCountry the DIRECTED weighed graph 
	 * @param mecnunCity the source city
	 * @return another graph that includes the shortest path from the mecnun city to all other cities present in the graph
	 */
	public static weighedDirGraph calculateShortestPathFromSource(weighedDirGraph anatolianCountry, City mecnunCity) {
		
		PriorityQueue<City> unprcsedCities = new PriorityQueue<>();
		Set<City> prcsedCities = new HashSet<>();
		
		mecnunCity.setDstToSource(0);
		unprcsedCities.add(mecnunCity);
		
		while(unprcsedCities.size() != 0) {
			
			City currCity =	unprcsedCities.poll();
			unprcsedCities.remove(currCity);
			
			for(java.util.Map.Entry<City, Integer> neighCityNRoadLength : currCity.getNeighbouringCities().entrySet()) {
				City adjacentCity = neighCityNRoadLength.getKey();
				Integer roadLength = neighCityNRoadLength.getValue();
				if(!prcsedCities.contains(adjacentCity)) {
					calculateMinDistance(adjacentCity, roadLength, currCity);
					unprcsedCities.add(adjacentCity);
				}
			}
			
			
			prcsedCities.add(currCity);
			
			
			
		}
		
		
		
		
	return anatolianCountry;
		
	}
	/**
	 * Finally adds the neighbouring city that is closest to the shortestpath string of the this city
	 * @param neighCity 
	 * @param roadLength
	 * @param currCity
	 */
	private static void calculateMinDistance(City neighCity, Integer roadLength, City currCity) {
		Integer sourceDistance = currCity.getDstToSource();
	    if (sourceDistance + roadLength < neighCity.getDstToSource()) {
	    	neighCity.setParent(currCity);
	        neighCity.setDstToSource(sourceDistance + roadLength);

	        
	        neighCity.setShortestPathString(currCity.getShortestPathString() + " ");
	        

	    }
		
	}

}
