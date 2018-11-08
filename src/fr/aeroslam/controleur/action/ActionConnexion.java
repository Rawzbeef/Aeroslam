package fr.aeroslam.controleur.action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;
import fr.aeroslam.vue.Vue;
import fr.aeroslam.vue.VueInfo;
import fr.aeroslam.vue.VueMenu;


public class ActionConnexion implements ActionListener, KeyListener {
	
	private Vue vue;
	private VueInfo vueInfo;
	
	private JTextField jtfIdentifiant;
	private JTextField jtfMdp;
	private Aeroport aero;

	

	public ActionConnexion(Aeroport aero, Vue vue, VueInfo vueInfo, JTextField jtfIdentifiant, JTextField jtfMdp) {
		this.aero = aero;
		this.vue = vue;
		this.vueInfo = vueInfo;
		this.jtfIdentifiant = jtfIdentifiant;
		this.jtfMdp = jtfMdp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vueInfo.reset();
		if(Modele.connexionAdmin(jtfIdentifiant.getText(), jtfMdp.getText())) {
			vue.getContentPane().removeAll();
			vue.setJMenuBar(new VueMenu(aero, vue, vueInfo));
			vue.getContentPane().add(new JPanel()).revalidate();
		}
		else {
			vueInfo.addLabelErreur("Identifiants incorrect");
			vue.getContentPane().revalidate();
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER) {
			vueInfo.reset();
			if(Modele.connexionAdmin(jtfIdentifiant.getText(), jtfMdp.getText())) {
				vue.getContentPane().removeAll();
				vue.setJMenuBar(new VueMenu(aero, vue, vueInfo));
				vue.getContentPane().add(new JPanel()).revalidate();
			}
			else {
				vueInfo.addLabelErreur("Identifiants incorrect");
				vue.getContentPane().revalidate();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
