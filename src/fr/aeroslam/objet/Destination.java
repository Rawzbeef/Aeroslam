package fr.aeroslam.objet;

public class Destination {

	private String paysD;
	private String villeD;

	public Destination(String paysD, String villeD) {
		this.setPaysD(paysD);
		this.setVilleD(paysD);
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
