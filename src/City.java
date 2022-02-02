import java.util.HashMap;


import java.util.Map;

public class City implements Comparable<City>{
		// Bunlar MST icindi
		/**
		 * Citynin idsi c1 ise 0, c2 ise 1dir
		 */
		private int id = 0; 
		/**
		 * Name of the city object
		 */
		private String name;
		/**
		 * Parent city object of the city
		 */
		private City parent;
		/**
		 * Shortest path from the source to this city
		 */
		private String shortestPathString = "";
		
		//Bunlar SPP
		
		public City(String name) {
			this.name = name;
		}
		
		public City(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		/**
		 * The distance from the source to this city, it is set to Integer.Max_value by default
		 */
		private Integer dstToSource = Integer.MAX_VALUE;
		/**
		 * All roads that goes from this city to the Neighbouring city and its weight as entries of a hashmap
		 */
		Map<City, Integer> neighbouringCities = new HashMap<City, Integer>();
		
		/**
		 * Adds neighCity-roadLength pair to this city's neighbouringCities hashmap
		 * @param neighCity neighbourin city of this city
		 * @param roadLength roadlength between them
		 */
		public void addRoad(City neighCity, int roadLength) {
			neighbouringCities.put(neighCity, roadLength);
		}
		
		/**
		 * Adds city c to the shortestStr of this city
		 * @param c the city that is to be included in this city's shortest path String 
 		 */
		public void addCityToSPS(City c) {
			this.shortestPathString += c.name + " ";
		}

		public String getShortestPathString() {
			return shortestPathString + this.name;
		}
		
		public void setShortestPathString(String s) {
			this.shortestPathString = s;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public City getParent() {
			return parent;
		}

		public void setParent(City parent) {
			this.parent = parent;
		}

//		public List<City> getShortestPath() {
//			return shortestPath;
//		}
//
//		public void setShortestPath(List<City> shortestPath) {
//			this.shortestPath = shortestPath;
//		}

		public Integer getDstToSource() {
			return dstToSource;
		}

		public void setDstToSource(Integer dstToSource) {
			this.dstToSource = dstToSource;
		}

		public Map<City, Integer> getNeighbouringCities() {
			return neighbouringCities;
		}

		public void setNeighbouringCities(Map<City, Integer> neighbouringCities) {
			this.neighbouringCities = neighbouringCities;
		}

		public int compareTo(City o) {
			if(this.dstToSource < o.dstToSource) {
				return -1;
			}else if(this.dstToSource> o.dstToSource) {
				return 1;
			}
			
			return 0;
		}

		@Override
		public String toString() {
			return   name;
		}
		
}
