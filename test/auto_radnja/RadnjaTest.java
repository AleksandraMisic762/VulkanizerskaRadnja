package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

abstract class RadnjaTest {

	protected Radnja radnja;
	
	@Test
	void testDodajGumu() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Michelin Defender");
		ag.setPrecnik(17);
		ag.setSirina(215);
		ag.setVisina(65);
		
		radnja.dodajGumu(ag);
		
		assertTrue(radnja.pronadjiGumu("Michelin Defender").contains(ag));
	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> radnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Michelin Defender");
		ag1.setPrecnik(17);
		ag1.setSirina(215);
		ag1.setVisina(65);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Michelin Defender");
		ag2.setPrecnik(17);
		ag2.setSirina(215);
		ag2.setVisina(65);
		
		radnja.dodajGumu(ag1);
		
		
		assertThrows(java.lang.RuntimeException.class,
				() -> radnja.dodajGumu(ag2));
	}

	@Test
	void testPronadjiGumu() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Michelin Defender");
		ag1.setPrecnik(17);
		ag1.setSirina(215);
		ag1.setVisina(65);
		
		radnja.dodajGumu(ag1);
		
		LinkedList<AutoGuma> res = radnja.pronadjiGumu("Michelin Defender");
		
		assertEquals(1, res.size());
		assertEquals(ag1, res.get(0));
	}
	
	@Test
	void testPronadjiGumuNijeURadnji() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Michelin Defender");
		ag1.setPrecnik(17);
		ag1.setSirina(215);
		ag1.setVisina(65);
		
		radnja.dodajGumu(ag1);
		
		LinkedList<AutoGuma> res = radnja.pronadjiGumu("Michelin Pilot");
		
		assertTrue(res.isEmpty());
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertNull(radnja.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuViseRazlicitihDimenzija() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Michelin Defender");
		ag1.setPrecnik(17);
		ag1.setSirina(215);
		ag1.setVisina(65);
		
		radnja.dodajGumu(ag1);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Michelin Defender");
		ag2.setPrecnik(16);
		ag2.setSirina(210);
		ag2.setVisina(60);
		
		radnja.dodajGumu(ag2);
		
		AutoGuma ag3 = new AutoGuma();
		ag3.setMarkaModel("Michelin Defender");
		ag3.setPrecnik(18);
		ag3.setSirina(205);
		ag3.setVisina(60);
		
		radnja.dodajGumu(ag3);
		
		LinkedList<AutoGuma> res = radnja.pronadjiGumu("Michelin Defender");
		
		assertEquals(3, res.size());
		assertTrue(res.contains(ag1));
		assertTrue(res.contains(ag2));
		assertTrue(res.contains(ag3));
	}

}
