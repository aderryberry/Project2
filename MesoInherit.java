

public class MesoInherit extends MesoAbstract {

	private MesoStation mesoStation;
	int[] charValue;
	int[] charCalcs;
	int numberOfCalcs=3;
			
	// constructor and create the array of the character values
	public MesoInherit(MesoStation mesoStation) {
		this.mesoStation=mesoStation;
		createCharValues();
	}

	// Call the method to perform calculations on the character calculation array
	public int[] calAverage() {
		createCharCalc();
		
		return charCalcs;
	}

	// getter for the mesostation
	public MesoStation getMesoStation() {
		return mesoStation;
	}
	// method to create the charValues array
	public void createCharValues() {
		charValue=new int[mesoStation.getStID().length()];
		for (int i=0; i<mesoStation.getStID().length();i++) {
			charValue[i]= (int) getMesoStation().getStID().charAt(i);
		
		}
	}
	
	
	@Override
	public char letterAverage() {
		// TODO Auto-generated method stub
		createCharCalc();
		return (char) charCalcs[2];
	}
	
	// Method to create the array of the calculations for the characters
	// This was added because zylab would not pass all the tests
	public void createCharCalc() {
		
		// create the int array with the correct number of calculations done
		charCalcs=new int[numberOfCalcs];
		// create a double to be able to perform calculations with decimals and rounding
		double AsciiCalc=0;
		
		// cycle through the charValue array and add their double values
		for (int i=0; i<charValue.length; i++) {
			AsciiCalc+=charValue[i];
		}
		// find the average
		AsciiCalc=AsciiCalc/charValue.length;
		
		// assign each part of the array to the correct value.
		charCalcs[0]=(int) Math.ceil(AsciiCalc);
		charCalcs[1]=(int) Math.floor(AsciiCalc);
		charCalcs[2]=(int) Math.round(AsciiCalc);
	}

}
