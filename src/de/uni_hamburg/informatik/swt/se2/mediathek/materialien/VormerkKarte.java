package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;

/**
 * Simuliert eine Pappkarte an einem Medium, die eine Liste von Vormerkern zeigt
 * 
 * @author Pinky
 */
public class VormerkKarte 
{
	
	private List<Kunde> _kundenliste;
	
	/**
	 * Initialisiert eine neue VormerkKarte
	 */
	public VormerkKarte()
	{
		_kundenliste = new LinkedList<>();		
	}	
	
	/**
	 * Prüft, ob das Vormerken für einen Kunden möglich ist
	 * wichtig ist, dass die Kundenliste nihct voll ist,
	 * und dass sie nicht bereits den Kunden enthält
	 * 
	 * @param kunde der Kunde, der vormerken will
	 * 
	 * @require kunde != null
	 * 
	 * @return true, wenn möglich
	 * 
	 */	
	public boolean istVormerkenMoeglich(Kunde kunde) 
	{
		assert kunde != null : "Kunde darf kein Nullpointer sein!";
				
		return _kundenliste.size() < 3 && !_kundenliste.contains(kunde);
	}
	
	/**
	 * Zeigt an, ob das Vormerken generell möglich ist
	 *
	 * @return true, wenn möglich
	 */
	public boolean istVormerkenMoeglich()
	{
		return _kundenliste.size() < 3;
	}
	
	/**
	 * Fügt einen Kunden der Liste hinzu
	 * 
	 * @param kunde der Kunde, der vormerken will
	 * 
	 * @require kunde != null;
	 */
	public void fuegeHinzu(Kunde kunde) 
	{
		assert kunde != null : "Vorbedingung Verletzt! Kunde darf nicht null sein!";
		if (istVormerkenMoeglich(kunde))
		{
			_kundenliste.add(kunde);
		}
		else 
		{
			System.err.print("Kunde darf nicht vormerken!!!");
		}
	}
	
	/**
	 * entfernt einen Kunden wieder
	 * 
	 * @param kunde der Kunde, der entfernt wird
	 * 
	 * @require kunde != null
	 */
	public void entferne(Kunde kunde)
	{
		assert kunde != null : "Vorbedingung verletzt: kunde != null";
		
		if (!_kundenliste.remove(kunde))
		{
			System.err.print("Kunde kann nciht entfernt werden!");
		}
	}
}
