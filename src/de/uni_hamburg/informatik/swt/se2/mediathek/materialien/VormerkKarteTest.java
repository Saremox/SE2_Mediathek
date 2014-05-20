package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VormerkKarteTest 
{
	private Kunde _kunde;
	private VormerkKarte _karte;
	
	public VormerkKarteTest()
	{
		_kunde =  new Kunde(new Kundennummer(4223), "Marvin", "Robot");
		_karte = new VormerkKarte();
	}
	
	@Test 
	public void testeFuegeHinzu()
	{
		assertTrue(_karte.istVormerkenMoeglich());
		_karte.fuegeHinzu(_kunde);
		assertFalse(_karte.istVormerkenMoeglich(_kunde));
	}
	
	@Test
	public void testeEntfernen()
	{
		_karte.fuegeHinzu(_kunde);
		assertFalse(_karte.istVormerkenMoeglich(_kunde));
		_karte.entferne(_kunde);
		assertTrue(_karte.istVormerkenMoeglich(_kunde));
	}
	
	@Test
	public void testeMehrAlsDreiKunden()
	{
		_karte.fuegeHinzu(new Kunde(new Kundennummer(4223), "Marvin", "Robot"));
		_karte.fuegeHinzu(new Kunde(new Kundennummer(1234), "Hans", "Wurst"));
		_karte.fuegeHinzu(new Kunde(new Kundennummer(2030), "Sesselsesse", "Esteban"));
		assertFalse(_karte.istVormerkenMoeglich(new Kunde(new Kundennummer(666), "Foo", "Bar")));
	}
}
