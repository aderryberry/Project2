import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PosAvg {

	private String stID;
	private int indexOfStation;
	private int linesDescribingTXTdoc=3;
	private int beginIndex=1;
	private int endIndex=5;
	String[] stationList;
	
	public PosAvg(String stID) {
		// TODO Auto-generated constructor stub
		this.stID=stID;
	}

	public int indexOfStation() throws IOException {
		// TODO Auto-generated method stub
		int countStationsToIndex=0;
		createStationList();
		while (!stID.equals(stationList[countStationsToIndex])) {
			countStationsToIndex++;
		}
		indexOfStation=countStationsToIndex+1;
		return indexOfStation;
	}

	
	// Method to create the station list by cycling through the txt document
	public void createStationList() throws IOException {
		int numberOfStations=0;
		
		BufferedReader br=new BufferedReader(new FileReader("Mesonet.txt"));
		while (br.readLine()!=null) {
			numberOfStations++;
		}
		numberOfStations=numberOfStations-linesDescribingTXTdoc;
		
		
		stationList=new String[numberOfStations];
		BufferedReader reader=new BufferedReader(new FileReader("Mesonet.txt"));
		for (int i=0; i<linesDescribingTXTdoc;i++) {
			reader.readLine();
		}
		
		for (int i=0; i<numberOfStations; i++) {
			stationList[i]=reader.readLine();
			stationList[i]=stationList[i].substring(beginIndex, endIndex);

		}
	}

	@Override
	public String toString() {
		return String.format("This index is average of %s and %s, %s and %s, and so on."
				, stationList[indexOfStation-2], stationList[indexOfStation]
				, stationList[indexOfStation-3], stationList[indexOfStation+1]);
	}
	
}
