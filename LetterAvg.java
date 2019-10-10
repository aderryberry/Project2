import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterAvg {

	private char letterAvg;
	private int linesDescribingTXTdoc = 3;
	private int beginIndex = 1;
	private int endIndex = 5;
	String[] sameAvgLetter;
	String[] stationList;

	public LetterAvg(char letterAvg) {
		// TODO Auto-generated constructor stub
		this.letterAvg = letterAvg;

	}

	public int numberOfStationWithLetterAvg() throws IOException {
		// TODO Auto-generated method stub
		int numStations = 0;
		int stationCounter = 0;
		createStationList();

		for (int i = 0; i < stationList.length; i++) {
			if (letterAvg == stationList[i].charAt(0)) {
				numStations++;
			}
		}
		sameAvgLetter = new String[numStations];
		for (int i = 0; i < stationList.length; i++) {
			if (letterAvg == stationList[i].charAt(0)) {
				sameAvgLetter[stationCounter] = stationList[i];
				stationCounter++;
			}
		}

		return numStations;
	}

	// Method to create the station list by cycling through the txt document
	public void createStationList() throws IOException {
		int numberOfStations = 0;

		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		while (br.readLine() != null) {
			numberOfStations++;
		}
		numberOfStations = numberOfStations - linesDescribingTXTdoc;

		stationList = new String[numberOfStations];
		BufferedReader reader = new BufferedReader(new FileReader("Mesonet.txt"));
		for (int i = 0; i < linesDescribingTXTdoc; i++) {
			reader.readLine();
		}

		for (int i = 0; i < numberOfStations; i++) {
			stationList[i] = reader.readLine();
			stationList[i] = stationList[i].substring(beginIndex, endIndex);

		}
	}

	@Override
	public String toString() {
		String returnStatement = "\nThey are:";
		for (int i = 0; i < sameAvgLetter.length; i++) {
			returnStatement = String.format(returnStatement + "\n" + sameAvgLetter[i]);
		}
		return returnStatement;
	}

}
