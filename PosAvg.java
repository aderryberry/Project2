import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class PosAvg {

	private String stID;
	private int stationIndex;
	private int linesDescribingTXTdoc=3;
	private int beginIndex=1;
	private int endIndex=5;
	private ArrayList<String> stationList = new ArrayList<String>();
	
	public PosAvg(String stID) {
		// TODO Auto-generated constructor stub
		this.stID=stID;
	}

	public int indexOfStation() throws IOException {
		// TODO Auto-generated method stub
		stationIndex=0;
		createStationList();
		stationIndex=stationList.indexOf(stID)+1;
		return stationIndex;
	}

	
	// Method to create the station list by cycling through the txt document
	public void createStationList() throws IOException {
		int numberOfStations=0;
		
		BufferedReader br=new BufferedReader(new FileReader("Mesonet.txt"));
		while (br.readLine()!=null) {
			numberOfStations++;
		}
		numberOfStations=numberOfStations-linesDescribingTXTdoc;
		
		BufferedReader reader=new BufferedReader(new FileReader("Mesonet.txt"));
		for (int i=0; i<linesDescribingTXTdoc;i++) {
			reader.readLine();
		}
		
		for (int i=0; i<numberOfStations; i++) {
			stationList.add(reader.readLine().substring(beginIndex, endIndex));

		}
	}

	@Override
	public String toString() {
		String returnString="";
		returnString= String.format("This index is average of %s and %s, %s and %s, and so on."
					, stationList.get(stationIndex - 2), stationList.get(stationIndex)
					, stationList.get(stationIndex - 3), stationList.get(stationIndex +1));
		return returnString;
	}
	
}
