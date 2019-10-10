

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
		
		charCalcs=new int[numberOfCalcs];
		double AsciiCalc=0;
		
		for (int i=0; i<charValue.length; i++) {
			AsciiCalc+=charValue[i];
		}
		AsciiCalc=AsciiCalc/charValue.length;
		
		charCalcs[0]=(int) Math.ceil(AsciiCalc);
		charCalcs[1]=(int) Math.floor(AsciiCalc);
		charCalcs[2]=(int) Math.round(AsciiCalc);
	}

}
