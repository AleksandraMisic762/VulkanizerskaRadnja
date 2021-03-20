package auto_radnja;

import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja radnju.
 * 
 * @author Aleksandra Misic
 *
 */
public interface Radnja {

	/**
	 * Dodaje novu gumu u radnju.
	 * 
	 * @param a Auto guma koja se dodaje.
	 * 
	 * @throws java.lang.NullPointerException ako je uneta guma null
	 * @throws java.lang.RuntimeException ako uneta guma vec postoji u radnji (duplikat)
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Vraca listu guma prema zadatom kriterijumu za marku i model.
	 * Ako je zadati kriterijum null, vraca null kao rezultat.
	 * 
	 * @param markaModel Marka i model gume koja se trazi.
	 * 
	 * @return Vraca listu guma sa markom i modelom koji odgovara zadatom kriterijumu za pretrazivanje.
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
}
