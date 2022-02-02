import java.util.ArrayList;
import java.util.List;

public class weighedUnGraph {
	/**
	 * Numberof cities
	 */
	private int nofCities; // number of vertices
	/**
	 * The adjecency matrix where we store the cities as integers
	 */
	int adjMatrix[][];
	
	public weighedUnGraph(int v) {
		nofCities = v;
		adjMatrix = new int[nofCities][nofCities];
		
		for(int i=0; i<nofCities; i++)
			for(int j=0; j<nofCities; j++)
				adjMatrix[i][j]=0;
	}
	
	
	
	/**
	 * Manipulates the adjacency matrix in accordance with the parameters passed in it
	 * @param c1 the city that road comes from
	 * @param c2 the city that road goes to
	 * @param w length of the road between two cities
	 */
	public void addEdgeWithWeight(City c1, City c2, int w) {
		if(adjMatrix[c1.getId()][c2.getId()] == 0) {
			adjMatrix[c1.getId()][c2.getId()]=w;
			adjMatrix[c2.getId()][c1.getId()]=w;
			
			
			
		}else if(adjMatrix[c1.getId()][c2.getId()] > w) {
			adjMatrix[c1.getId()][c2.getId()]=w;
			adjMatrix[c2.getId()][c1.getId()]=w;
			
		}
			
			
		

		
		
		
		
		
	}
	
	
	
	public List<int[]> getNeighboursWithWeight(List<City> vList, City[] arr) { //BUNU KULLANIYO USTTEKINI DEGIL
		
		List<int[]> neighbours = new ArrayList<int[]>();
		
		
		
		for(City c:vList)
			for(int i=0; i<nofCities; i++) {
				
				if (adjMatrix[c.getId()][i] > 0 && !vList.contains(arr[i])) {
					int[] x = {c.getId(),i,(int)adjMatrix[c.getId()][i]};
					neighbours.add(x);
				}
			}
		return neighbours;
		
	}
	
	public int getWeight(int v1, int v2) {
		return adjMatrix[v1][v2];
	}
	
	public int getNumberOfVertices() {
		return nofCities;
	}
	
	

}
