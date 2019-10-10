import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LetterAvg {

	// Initialize the variables needed throughout the class
	private char letterAvg;
	private int linesDescribingTXTdoc = 3;
	private int beginIndex = 1;
	private int endIndex = 5;
	private ArrayList<String> sameAvgLetter = new ArrayList<String>();
	private ArrayList<String> stationList = new ArrayList<String>();

	
	// Constructor for letter average. Calls a method to create the station list
	public LetterAvg(char letterAvg) {
		
		this.letterAvg = letterAvg;
		try {
			createStationList();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	// Method to calculate the number of stations with the same first letter as the average letter
	public int numberOfStationWithLetterAvg() throws IOException {
		// TODO Auto-generated method stub
		int numStations = 0;
		int stationCounter = 0;

		//cycle through all the stations and find the number of stations that have the same letter as the avg
		for (int i = 0; i < stationList.size(); i++) {
			if (letterAvg == stationList.get(i).charAt(0)) {
				numStations++;
			}
		}

		//cycle through the stations again and add the stations that share the same avg letter to an array list
		for (int i = 0; i < stationList.size(); i++) {
			if (letterAvg == stationList.get(i).charAt(0)) {
				sameAvgLetter.add(stationCounter, stationList.get(i));
				stationCounter++;
			}
		}

		return numStations;
	}

	// Method to create the station list by cycling through the txt document
	public void createStationList() throws IOException {
		int numberOfStations=0;
		
		// read the number of lines in the provided txt document
		BufferedReader br=new BufferedReader(new FileReader("Mesonet.txt"));
		while (br.readLine()!=null) {
			numberOfStations++;
		}
		// subtract the number of lines for the given txt document that just describe the txt
		// the lines without the stations in them
		numberOfStations=numberOfStations-linesDescribingTXTdoc;
		
		// cycle through the station list and add the stations to the array
		BufferedReader reader=new BufferedReader(new FileReader("Mesonet.txt"));
		// cycle through the first lines that do not contain stations
		for (int i=0; i<linesDescribingTXTdoc;i++) {
			reader.readLine();
		}
		// read in the stations in the txt document and only take the parts with the station name
		for (int i=0; i<numberOfStations; i++) {
			stationList.add(reader.readLine().substring(beginIndex, endIndex));

		}
	}

	
	// Zylab will not accept this to string for the test
	@Override
	public String toString() {
		String returnStatement = "\nThey are:";
		for (int i = 0; i < sameAvgLetter.size(); ++i) {
			returnStatement = returnStatement + "\n" + sameAvgLetter.get(i);
		}
		return returnStatement;
	}

}
