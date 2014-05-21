package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VormerkKarteTest 
{
	private Kunde _kunde;
	private VormerkKarte _karte;
	private Medium _medium;
	
	public VormerkKarteTest()
	{
		 _medium = new CD("bar", "baz", "foo", 123);
		_kunde =  new Kunde(new Kundennummer(400223), "Marvin", "Robot");
		_karte = new VormerkKarte(_medium);
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
		_karte.fuegeHinzu(new Kunde(new Kundennummer(104223), "Marvin", "Robot"));
		_karte.fuegeHinzu(new Kunde(new Kundennummer(101234), "Hans", "Wurst"));
		_karte.fuegeHinzu(new Kunde(new Kundennummer(102030), "Sesselsesse", "Esteban"));
		assertFalse(_karte.istVormerkenMoeglich(new Kunde(new Kundennummer(100666), "Foo", "Bar")));
	}
}
