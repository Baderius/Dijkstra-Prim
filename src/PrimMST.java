


import java.util.ArrayList;
import java.util.List;

public class PrimMST {
	/**
	 * 
	 * @param hmGraph weighed UNDIRECTED graph
	 * @param leylaCity the source city of the graph
	 * @param hmCities all cities that are included in the graph stored in an array
	 * @return the total weight of the minimum spanning tree that can be generated using the hmGraph graph
	 */
	public static int MST(weighedUnGraph hmGraph, City leylaCity, City[] hmCities) {
		
		
		
		int numberOfVertices = hmGraph.getNumberOfVertices();
		List<int[]> MST_Prim_order = new ArrayList<int[]>();
		List<City> MST_vertices = new ArrayList<City>();
		MST_vertices.add(leylaCity);
		
		while(MST_vertices.size() < numberOfVertices) {
		
			List<int[]> currNeighbours = hmGraph.getNeighboursWithWeight(MST_vertices, hmCities);//Current neighbours dedigimiz arkadas list of int[] {idOfSourceCity, idOfDestCity, weight}
			
			
			
			int[] x = findMinWeightNeighbour(currNeighbours);
			
		
			MST_Prim_order.add(x); // id of the first city and the id of the second
			
			
			if(MST_vertices.contains(hmCities[x[0]]))
				MST_vertices.add(hmCities[x[1]]);
			else
				MST_vertices.add(hmCities[x[0]]);
		}
		
		// print MST edges
	    
	    int totalWeight = 0;
	    for(int[] v:MST_Prim_order) {
	    	
			totalWeight += hmGraph.getWeight(v[0], v[1]);
	
	    }
	    ////////////////////////////////////////
	    
	    
	    for(City town : hmCities) {
	    	if(town != null && !MST_vertices.contains(town)) {
	    		System.out.println("There is no honeymoon path that contains all d cities");
	    		break;
	    	}
	    }
	    /////////////////////////////////////////
	    return totalWeight;
	}
	
	public static int[] findMinWeightNeighbour(List<int[]> listEdges) {
		
		int minEdgeWeight = 999999;
		int[] minEdge = {-1,-1};
		
		for(int[] e:listEdges) {
		
			
			if (e[2] < minEdgeWeight) {
				minEdgeWeight = e[2];
				minEdge[0] = e[0];
				minEdge[1] = e[1];
			}
			
		}
	
		return minEdge;
	}
	
	
}
