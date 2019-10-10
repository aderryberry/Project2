import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class PosAvg {

	// Initialize the variables needed throughout the class
	private String stID;
	private int stationIndex;
	private int linesDescribingTXTdoc=3;
	private int beginIndex=1;
	private int endIndex=5;
	private ArrayList<String> stationList = new ArrayList<String>();
	

	public PosAvg(String stID) {
		this.stID=stID;
	}

	// method to find the station index
	public int indexOfStation() throws IOException {

		stationIndex=0;
		// must create the stationlist by calling the method first
		createStationList();
		stationIndex=stationList.indexOf(stID)+1;
		return stationIndex;
	}

	
	// Method to create the station list by cycling through the txt document
	public void createStationList() throws IOException {
		int numberOfStations=0;
		
		// read the number of lines there are
		BufferedReader br=new BufferedReader(new FileReader("Mesonet.txt"));
		while (br.readLine()!=null) {
			numberOfStations++;
		}
		// subtract the lines that do not have stations on them
		numberOfStations=numberOfStations-linesDescribingTXTdoc;
		
		
		// cycle through the txt document again and add the objects to the array list
		BufferedReader reader=new BufferedReader(new FileReader("Mesonet.txt"));
		// skip the lines that do not have stations on them
		for (int i=0; i<linesDescribingTXTdoc;i++) {
			reader.readLine();
		}
		// cycle through the txt document and save the objects at the correct index
		for (int i=0; i<numberOfStations; i++) {
			stationList.add(reader.readLine().substring(beginIndex, endIndex));

		}
	}

	// Recreated the indexOfStation to work on zylabs test
	@Override
	public String toString() {
		String returnString="";
		try {
			indexOfStation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnString= "This index is average of "+stationList.get(stationIndex - 2)+
				" and "+stationList.get(stationIndex)+", "+stationList.get(stationIndex-3)+" and "
				+stationList.get(stationIndex+1)+", and so on.";
		return returnString;
	}
	
}
