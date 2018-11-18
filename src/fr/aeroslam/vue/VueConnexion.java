package fr.aeroslam.vue;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.aeroslam.controleur.action.ActionConnexion;
import fr.aeroslam.objet.Aeroport;


@SuppressWarnings("serial")
public class VueConnexion extends JPanel {

	private JLabel jlIdentifiant;
	private JTextField jtfIdentifiant;
	private JLabel jlMdp;
	private JPasswordField jtfMdp;
	private JButton jbConnexion;
	
	private Vue vue;
	private VueInfo vueInfo;
	private Aeroport aero;

	public VueConnexion(Aeroport aero, Vue vue, VueInfo vueInfo) {
		vueInfo.reset();
		this.aero = aero;
		this.vue = vue;
		this.vueInfo = vueInfo;
		
		
		this.jlIdentifiant = new JLabel("Identifiant :");
		this.jtfIdentifiant = new JTextField();
		this.jtfIdentifiant.setPreferredSize(new Dimension(150, 20));
		
		
		this.jlMdp = new JLabel("Mot de passe :");
		this.jtfMdp = new JPasswordField();
		this.jtfMdp.setPreferredSize(new Dimension(150, 20));
		
		
		this.jbConnexion = new JButton("Connexion");
		
		ActionConnexion actionConnexion = new ActionConnexion(this.aero, this.vue, this.vueInfo, this.jtfIdentifiant, this.jtfMdp);
		this.jtfIdentifiant.addKeyListener(actionConnexion);
		this.jtfMdp.addKeyListener(actionConnexion);
		this.jbConnexion.addActionListener(actionConnexion);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(3, 3, 3, 3);
		this.add(jlIdentifiant, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfIdentifiant, c);
		c.gridx = 0;
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jlMdp, c);
		c.gridx++;
		c.fill = GridBagConstraints.BOTH;
		this.add(jtfMdp, c);
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		this.add(vueInfo, c);
		c.gridy++;
		c.fill = GridBagConstraints.NONE;
		this.add(jbConnexion, c);
	}

}
