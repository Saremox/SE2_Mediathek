package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * Simuliert eine Pappkarte an einem Medium, die eine Liste von Vormerkern zeigt
 * 
 * @author Pinky
 */
public class VormerkKarte 
{
	
	private LinkedList<Kunde> _kundenliste;
	private final Medium _medium; 
	
	/**
	 * Initialisiert eine neue VormerkKarte
	 */
	public VormerkKarte(Medium neuMedium)
	{
		_kundenliste = new LinkedList<>();
		_medium = neuMedium;
	}	

    /**
	 * Prüft, ob das Vormerken für einen Kunden möglich ist
	 * wichtig ist, dass die Kundenliste nicht voll ist,
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
	 * Prüft ob der übergebene Kunde der erste in der Vormerkerliste ist
	 * 
	 * @param kunde für den geprüft werden soll ob dieser an der ersten Position der Liste steht
	 * 
	 * @require kunde != null
	 * 
	 * @return true wenn kunde der erste Vormerker in der Liste ist. Sonst False
	 */
	public boolean istErsterVormerker(Kunde kunde)
	{
	    assert kunde != null : "Kunde darf kein Nullpointer sein!";
	    if(_kundenliste.peek().getKundennummer() == kunde.getKundennummer())
	    {
	        return true;
	    }
	    return false;
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
	
	/**
	 * Gibt das Medium, auf das sich die VormerkKarte bezieht 
	 * 
	 * @require _medium != null
	 * 
	 * @return das Medium, an dem die karte klebt
	 */
	public Medium gibMedium()
	{
		assert _medium != null : "Vorbedingung nicht erfüllt! _medium nicht ungleich null!";
		return _medium;
	}

	/**
	 * Gibt den entleiher 
	 * @param position
	 * @return
	 */
    public Kunde getEntleiher(int position)
    {
        if(position < _kundenliste.size() && position >= 0)
        {
            return _kundenliste.get(position);
        }
        else
        {
            return null;
        }
    }
}
