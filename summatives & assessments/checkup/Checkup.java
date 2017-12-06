import static java.lang.System.out;

public class Checkup {
	
	private int patientNumber, systoli, diastolic, ldl, hdl;
	private double lastRatio;
	
	public Checkup() {
		patientNumber = 0;
		systoli = 0;
		diastolic = 0;
		ldl = 0;
		hdl = 0;
		lastRatio = 0;
	}

	public int getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(int patientNumber) {
		this.patientNumber = patientNumber;
	}

	public int getSystoli() {
		return systoli;
	}

	public void setSystoli(int systoli) {
		this.systoli = systoli;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public int getLdl() {
		return ldl;
	}

	public void setLdl(int ldl) {
		this.ldl = ldl;
	}

	public int getHdl() {
		return hdl;
	}

	public void setHdl(int hdl) {
		this.hdl = hdl;
	}
	
	public void computeRatio() {
		lastRatio = ldl / hdl;
	}
	
	public void display() {
		out.println("Patient #" + patientNumber + ":");
		out.println("> Blood pressure: " + systoli + "/" + diastolic);
		out.println("> Cholesterol ratio: " + lastRatio);
	}

}
