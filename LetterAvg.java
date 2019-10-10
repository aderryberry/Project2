import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

	}

	// Method to calculate the number of stations with the same first letter as the average letter
	public int numberOfStationWithLetterAvg() throws IOException {
		// TODO Auto-generated method stub
		int numStations = 0;
		int stationCounter = 0;

		createStationList();
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
	public ArrayList<String> createStationList() throws IOException {
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
		return stationList;
	}
	
	// Whole method is combining createStation method and numberOfStationsWithLetterAvg station
	// This lets all the tests on zybooks work
	public ArrayList<String> stationsThatMatch() throws IOException {
		ArrayList<String> tempStationList = new ArrayList<String>();
		ArrayList<String> tempStationMatch = new ArrayList<String>();
		
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
			tempStationList.add(reader.readLine().substring(beginIndex, endIndex));

		}
		
		int numStations = 0;
		int stationCounter = 0;

		createStationList();
		//cycle through all the stations and find the number of stations that have the same letter as the avg
		for (int i = 0; i < tempStationList.size(); i++) {
			if (letterAvg == tempStationList.get(i).charAt(0)) {
				numStations++;
			}
		}

		//cycle through the stations again and add the stations that share the same avg letter to an array list
		for (int i = 0; i < tempStationList.size(); i++) {
			if (letterAvg == tempStationList.get(i).charAt(0)) {
				tempStationMatch.add(stationCounter, tempStationList.get(i));
				stationCounter++;
			}
		}
		
		return tempStationMatch;
	}
	
	
	
	// Zylab will not accept this to string for the test
	@Override
	public String toString() {
		ArrayList<String> returnArray = new ArrayList<String>();
		try {
			returnArray=stationsThatMatch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String returnStatement = "\nThey are:";
		for (int i = 0; i < returnArray.size(); ++i) {
			returnStatement = returnStatement + "\n" + returnArray.get(i);
		}
		return returnStatement;
	}

}
