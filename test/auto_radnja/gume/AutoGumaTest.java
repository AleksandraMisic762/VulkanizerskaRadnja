package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;

	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		ag = new AutoGuma();

		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Michelin Pilot", 17, 205, 55);

		assertNotNull(ag);
		assertEquals("Michelin Pilot", ag.getMarkaModel());
		assertEquals(17, ag.getPrecnik());
		assertEquals(205, ag.getSirina());
		assertEquals(55, ag.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Michelin Agilis");
		
		assertEquals("Michelin Agilis", ag.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> ag.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelPrekratakString() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setMarkaModel("Aa"));
	}

	@ParameterizedTest
	@CsvSource({
		"14",
		"16",
		"18",
		"21"
	})
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		
		assertEquals(precnik, ag.getPrecnik());
	}
	
	@Test
	void testSetPrecnikPremalaVrednost() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setPrecnik(3));
	}
	
	@Test
	void testSetPrecnikPrevelikaVrednost() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setPrecnik(70));
	}

	@ParameterizedTest
	@CsvSource({
		"140",
		"205",
		"300",
		"350"
	})
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		
		assertEquals(sirina, ag.getSirina());
	}
	
	@Test
	void testSetSirinaPremalaVrednost() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setSirina(100));
	}
	
	@Test
	void testSetSirinaPrevelikaVrednost() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setSirina(400));
	}

	@ParameterizedTest
	@CsvSource({
		"30",
		"50",
		"70",
		"90"
	})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		
		assertEquals(visina, ag.getVisina());
	}
	
	@Test
	void testSetVisinaPremalaVrednost() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setVisina(20));
	}
	
	@Test
	void testSetVisinaPrevelikaVrednost() {
		assertThrows(java.lang.RuntimeException.class, () -> ag.setVisina(200));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("Michelin Defender");
		ag.setPrecnik(17);
		ag.setSirina(215);
		ag.setVisina(65);

		String res = ag.toString();

		assertTrue(res.contains("Michelin Defender"));
		assertTrue(res.contains("17"));
		assertTrue(res.contains("215"));
		assertTrue(res.contains("65"));
	}

	@ParameterizedTest
	@CsvSource({
		"Michelin Pilot, 17, 205, 60, Michelin Pilot, 17, 205, 60, true",
		"Michelin Defender, 17, 205, 60, Michelin Pilot, 17, 205, 60, false",
		"Michelin Pilot, 16, 205, 60, Michelin Pilot, 17, 205, 60, false",
		"Michelin Pilot, 17, 215, 60, Michelin Pilot, 17, 205, 60, false",
		"Michelin Pilot, 17, 205, 65, Michelin Pilot, 17, 205, 60, false",
		"Michelin Pilot, 16, 215, 60, Michelin Pilot, 17, 205, 60, false",
		"Michelin Pilot, 16, 205, 70, Michelin Pilot, 17, 205, 60, false",
		"Michelin Pilot, 17, 215, 65, Michelin Pilot, 17, 205, 60, false",
		"Michelin Defender, 18, 205, 60, Michelin Pilot, 17, 205, 60, false",
		"Michelin Defender, 17, 215, 60, Michelin Pilot, 17, 205, 60, false",
		"Michelin Defender, 17, 205, 65, Michelin Pilot, 17, 205, 60, false"
	})
	void testEqualsObject(String markaModel1, int precnik1, int sirina1, int visina1, String markaModel2, int precnik2, int sirina2, int visina2, boolean equals) {
		ag.setMarkaModel(markaModel1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel(markaModel2);
		ag2.setPrecnik(precnik2);
		ag2.setSirina(sirina2);
		ag2.setVisina(visina2);
		
		assertEquals(ag.equals(ag2), equals);
	}

}
