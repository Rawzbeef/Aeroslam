package fr.aeroslam.objet;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Destination {

	private int codeD;
	private String paysD;
	private String villeD;

	public Destination(int codeD, String villeD, String paysD) {
		this.setCodeD(codeD);
		this.setPaysD(paysD);
		this.setVilleD(villeD);
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
	
	public Element toXml() {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("destination");
		root.addElement("code").addText("" + this.codeD);
		root.addElement("pays").addText(this.paysD);
		root.addElement("ville").addText(this.villeD);
		return root;
	}

}
