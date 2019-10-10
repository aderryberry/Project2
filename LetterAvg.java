import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LetterAvg {

	private char letterAvg;
	private int linesDescribingTXTdoc = 3;
	private int beginIndex = 1;
	private int endIndex = 5;
	private ArrayList<String> sameAvgLetter = new ArrayList<String>();
	private ArrayList<String> stationList = new ArrayList<String>();

	public LetterAvg(char letterAvg) {
		// TODO Auto-generated constructor stub
		this.letterAvg = letterAvg;
		try {
			createStationList();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public int numberOfStationWithLetterAvg() throws IOException {
		// TODO Auto-generated method stub
		int numStations = 0;
		int stationCounter = 0;

		for (int i = 0; i < stationList.size(); i++) {
			if (letterAvg == stationList.get(i).charAt(0)) {
				numStations++;
			}
		}

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
		String returnStatement = "\nThey are:";
		for (int i = 0; i < sameAvgLetter.size(); ++i) {
			returnStatement = returnStatement + "\n" + sameAvgLetter.get(i);
		}
		return returnStatement;
	}

}
