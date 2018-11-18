package fr.aeroslam.vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.aeroslam.controleur.action.ActionCreerVol;
import fr.aeroslam.modele.FormatterSqlDate;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.objet.Avion;
import fr.aeroslam.objet.Destination;

@SuppressWarnings("serial")
public class VueCreerVol extends JPanel {
	
	private JLabel jlDate;
	private JDatePickerImpl jdpiDate;
	
	private JLabel jlAvion;
	private JComboBox<String> jcbAvion;
	
	private JLabel jlDestination;
	private JComboBox<String> jcbDestination;

	private JButton jbCreer;
	private JRadioButton jrbCourrier;
	private JRadioButton jrbCommercial;
	private ButtonGroup bgVol;

	public VueCreerVol(Aeroport aero, VueInfo vueInfo) {
		vueInfo.reset();

		this.jlDate = new JLabel("Date de départ : ");
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Aujourd'hui");
		p.put("text.month", "Mois");
		p.put("text.year", "Année");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		this.jdpiDate = new JDatePickerImpl(datePanel, new FormatterSqlDate());
		 
		this.jrbCourrier = new JRadioButton("Courrier");
		this.jrbCommercial = new JRadioButton("Commercial");
		this.bgVol = new ButtonGroup();
		this.bgVol.add(jrbCourrier);
		this.bgVol.add(jrbCommercial);
		
		this.jlAvion = new JLabel("Avion :");
		ArrayList<Avion> lesAvions = aero.getLesAvions();
		String[] tableA = new String[aero.getLesAvions().size()];
		String[] tableD = new String[aero.getLesDestinations().size()];
		int i = 0;
		for(Avion avion : lesAvions) {
			tableA[i] = avion.getCodeAvion() + " - " + avion.getNomAvion() + " - " + avion.getNbPlace();
			i++;
		}
		this.jcbAvion = new JComboBox<String>(tableA);
		
		this.jlDestination = new JLabel("Destination :");
		ArrayList<Destination> lesDestinations = aero.getLesDestinations();
		i = 0;
		for(Destination destination : lesDestinations) {
			tableD[i] = destination.getVilleD() + " | " + destination.getPaysD();
			i++;
		}
		this.jcbDestination = new JComboBox<String>(tableD);
		
		this.jbCreer = new JButton("Créer");
		
		ActionCreerVol actionAjouterDestination = new ActionCreerVol(aero, this, vueInfo);
		this.jbCreer.addActionListener(actionAjouterDestination);
		this.jdpiDate.addKeyListener(actionAjouterDestination);
		this.jcbAvion.addKeyListener(actionAjouterDestination);
		this.jcbDestination.addKeyListener(actionAjouterDestination);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3, 3, 3, 3);
		this.add(jlDate, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jdpiDate, c);
		
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jrbCourrier, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jrbCommercial, c);
		
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlAvion, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jcbAvion, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlDestination, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jcbDestination, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		this.add(vueInfo, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jbCreer, c);
	}
	
	public String getDate() {
		try {
			return jdpiDate.getModel().getYear() + "-" + (jdpiDate.getModel().getMonth()+1) + "-" + jdpiDate.getModel().getDay();
		} catch(NullPointerException e) {
			return null;
		}
	}
	
	public boolean isCourrier() {
		return this.jrbCourrier.isSelected();
	}
	
	public boolean isCommercial() {
		return this.jrbCommercial.isSelected();
	}

	public int getAvionIndex() {
		return this.jcbAvion.getSelectedIndex();
	}
	
	public int getDestinationIndex() {
		return this.jcbDestination.getSelectedIndex();
	}
}
