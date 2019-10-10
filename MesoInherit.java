

public class MesoInherit extends MesoAbstract {

	private MesoStation mesoStation;
	int[] charValue;
	int[] charCalcs;
	int numberOfCalcs=3;
			
	public MesoInherit(MesoStation mesoStation) {
		// TODO Auto-generated constructor stub
		this.mesoStation=mesoStation;
		createCharValues();
	}

	public int[] calAverage() {
		// TODO Auto-generated method stub
		createCharCalc();
		
		return charCalcs;
	}

	public MesoStation getMesoStation() {
		return mesoStation;
	}
	
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
