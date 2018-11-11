
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.aeroslam.modele.Modele;
import fr.aeroslam.objet.Aeroport;


public class ModeleTest {

	private Aeroport aeroport;

	@Before
	public void setUp() {
		this.aeroport = new Aeroport();
	}

	//@Test
	public void testNbAvion() {
		Assert.assertEquals("Pas le bon nombre d'avions", Modele.getNbAvion(), 5);
	}
	
	//@Test
	public void testGetLesAvions() {
		Assert.assertEquals("Pas le bon nombre d'avions", aeroport.getLesAvions().size(), 5);
	}
	
	@Test
	public void testToXml() {
		System.out.println(aeroport.getLesAvions().get(0).toXml());
	}

}
