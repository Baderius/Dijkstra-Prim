import java.util.HashSet;
import java.util.Set;

public class weighedDirGraph {
	
	/**
	 * Set of all cities that are present in this graph
	 */
	private Set<City> cities = new HashSet<City>();
	
	
	
	/**
	 * Adds the city c to the graph
	 * @param c city that is to be added to the graph
	 */
	public void addCity(City c) {
		cities.add(c);
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}
