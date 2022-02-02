import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class project3main {

	public static void main(String[] args) throws FileNotFoundException {
		File inFile = new File(args[0]);
		File outFile = new File(args[1]);
		
		Scanner scanner = new Scanner(inFile);
		PrintStream printStream = new PrintStream(outFile);
		
		//In this part we will read the file and construct our City objects and graphs acoordingly.
		
		int threshold = scanner.nextInt();
		int nofAllCities = scanner.nextInt();
		
		// ILK kisim icin kullanacagimiz graphtir kendileri
		weighedDirGraph shrtstPathGraph = new weighedDirGraph();
		
		scanner.next();
		String leylaCity = scanner.next();
		
		//Nummber of C sehirleri
		int nofCs = Integer.parseInt(leylaCity.substring(1));
		

		//C sehirlerini bi arrayde tutuyorum
		City[] cCities = new City[nofCs];
		
		// C Cityleri adlariyla construct ediyorum
		for(int i = 0; i<nofCs; i++) {
			int n = i + 1;
			cCities[i] = new City("c" + n); 
			shrtstPathGraph.addCity(cCities[i]); // Graphe de ekliyorum olusturdugum city objelerini
		}
		
		//D sehirlerini bi arrayde tutuyorum ama idleriyle de initialize edicem
		int sizeOf = nofAllCities - nofCs + 1;
		City[] dCities = new City[sizeOf];
		
		//Leylanin sehrini de ikinci graphin arryine ekliyorum
		dCities[0] = cCities[nofCs - 1];
		
		//Diger d sehilrerini de ekliyorum arraye
		for(int i=1; i<sizeOf; i++) {
			dCities[i] = new City(i, "d" + i);
		}
		
		//////////////////////////////////////////////////////BU KISMA KADAR VARIABLELARI YARATTIM, C1 0 C2 1. INDEXTE DURUYOR D1 1 D2 2. INDEXTE
		
		for(int i=0; i<nofCs; i++) { // i is actually the id of the curr city
			String[] currLine = scanner.nextLine().split(" ");
			for(int e=1; e<currLine.length; e++) {
				if(e%2 == 0) {
					continue;
				}
				
				int idOfNeighCity = Integer.parseInt(currLine[e].substring(1)) - 1;
				
				int roadLength = Integer.parseInt(currLine[e+1]);
				cCities[i-1].addRoad(cCities[idOfNeighCity], roadLength);
				
			}
			
			
		}
		
		
		// Eger mecnun leylaya ULASAMIYORSA direkt kesiyor ve ikinci kisma gecmeden direkt -1i bastiriyor
		boolean canReach = true;
		boolean canMarry = true;
		DijkstraSP.calculateShortestPathFromSource(shrtstPathGraph, cCities[0]);
		if(cCities[nofCs-1].getDstToSource() == Integer.MAX_VALUE) {
			printStream.println(-1);
			printStream.println(-1);
			canReach = false;
		}
		
		
		
		
		
		// Eger mecnun leylaya ULASABILIYORSA pathi direkt bastiriyor, eger dst thresholddan kucuk esitse de canMarryyi true yapiyor
		else {
			printStream.println(cCities[nofCs-1].getShortestPathString()); //Pathi dosyaya bastiriyor
			if(cCities[nofCs -1].getDstToSource() > threshold) {
				canMarry = false;
				printStream.println(-1);
			}
			
		}
		
		
		if(canReach && canMarry) {
			
			
			
			
			
			int nofDs = nofAllCities - nofCs + 1; //Not the number of Ds but it is one more than the number of Ds
			
			weighedUnGraph mstGraph = new weighedUnGraph(nofDs); // mst ye vercegim arrayi olusturucam simdi
			
			for(int m=0; m<nofDs; m++) { // i is actually the id of the curr city
				String[] currLineForD = scanner.nextLine().split(" ");
				for(int e=1; e<currLineForD.length; e++) {
					if(e%2 == 0) {
						continue;
					}
					int idOfNeighCity = Integer.parseInt(currLineForD[e].substring(1));
					
					int roadLength = Integer.parseInt(currLineForD[e+1]);
					mstGraph.addEdgeWithWeight(dCities[m], dCities[idOfNeighCity], roadLength);
					
				}
				
				
			}
			
			
			//Burda biraz hile yaptik gibi oldu ama saglik olsun xddd
			try {
				int totalWeight = PrimMST.MST(mstGraph, dCities[0], dCities);
				printStream.println(totalWeight * 2);;
				
			}catch(Exception e) {
				printStream.println(-2);
			}

			
			
		}
		
		
		scanner.close();
		printStream.close();
	
	}

}
