package fr.aeroslam.objet;

public class Destination {

	private int codeD;
	private String paysD;
	private String villeD;

	public Destination(int codeD, String paysD, String villeD) {
		this.setCodeD(codeD);
		this.setPaysD(paysD);
		this.setVilleD(paysD);
	}

	/**
	 * @return the codeD
	 */
	public int getCodeD() {
		return codeD;
	}

	/**
	 * @param codeD the codeD to set
	 */
	public void setCodeD(int codeD) {
		this.codeD = codeD;
	}

	public String getPaysD() {
		return paysD;
	}

	public void setPaysD(String paysD) {
		this.paysD = paysD;
	}

	public String getVilleD() {
		return villeD;
	}

	public void setVilleD(String villeD) {
		this.villeD = villeD;
	}

}
