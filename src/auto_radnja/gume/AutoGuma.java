package auto_radnja.gume;

/**
 * Klasa koja predstavlja gumu automobila
 * 
 * AutoGuma ima atribute markaModel kao String vrenost i precnik, sirina i
 * visina kao celobrojne vrednosti (int).
 * 
 * @author Aleksandra Misic
 * @version 0.1
 *
 */
public class AutoGuma {

	/**
	 * Marka i model gume kao String.
	 */
	private String markaModel = null;
	/**
	 * Precnik gume kao int. Ako nije specificiran, vrednost je -1;
	 */
	private int precnik = -1;
	/**
	 * Sirina gume kao int. Ako nije specificirana, vrednost je -1;
	 */
	private int sirina = -1;
	/**
	 * Visina gume kao int. Ako nije specificirana, vrednost je -1;
	 */
	private int visina = -1;

	/**
	 * Konstruktor koji inicijalizuje objekat klase AutoGume.
	 */
	public AutoGuma() {
	}

	/**
	 * Konstruktor koji inicijalizuje objekat klase AutoGume i postavlja vrednosti
	 * za ime i prezime autora.
	 * 
	 * @param markaModel
	 *            Marka i model gume kao String.
	 * @param precnik
	 *            Precnik gume kao int.
	 * @param sirina
	 *            Sirina gume kao int.
	 * @param visina
	 *            Visina gume kao int.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca marku i model gume.
	 * 
	 * @return Marka i model gume kao String.
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja marku i model na novu vrednost.
	 * 
	 * @param markaModel
	 *            Marka i model kao String.
	 * 
	 * @throws java.lang.NullPointerException
	 *             ako je uneti String za marku i model null.
	 * @throws java.lang.RuntimeException
	 *             Ako je uneti String za marku i model koji nema bar 3 znaka.
	 * 
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume.
	 * 
	 * @return Precnik kao int.
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja precnik gume na novu vrednost.
	 * 
	 * @param precnik
	 *            Precnik kao int.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako uneti precnik nije u dozvoljenom opsegu, odnosno manji od 13
	 *             ili veci od 22.
	 * 
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu gume.
	 * 
	 * @return Sirina kao int.
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja sirinu gume na novu vrednost.
	 * 
	 * @param sirina
	 *            Sirina kao int.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako uneta sirina nije u dozvoljenom opsegu, odnosno manja od 135
	 *             ili veca od 355.
	 * 
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu gume.
	 * 
	 * @return Visina kao int.
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja visinu gume na novu vrednost.
	 * 
	 * @param visina
	 *            Visina kao int.
	 * 
	 * @throws java.lang.RuntimeException
	 *             Ako uneta visina nije u dozvoljenom opsegu, odnosno manja od 25
	 *             ili veca od 95.
	 * 
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * @return Vraca String sa podacima o marki i modelu, precniku, sirini i visini
	 *         gume za automobil.
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve auto gume i vraca true ako su iste, odnosno false ako nisu.
	 * 
	 * Gume se porede po marki i modelu, precniku, sirini i visini. Ako je bilo koje
	 * od ovih atributa razlicit, gume se ne smatraju istim.
	 * 
	 * @return
	 *         <ul>
	 *         <li>true ako su oba objekta klase AutoGuma i imaju istu marka i
	 *         model, precnik, sirinu i visinu</li>
	 *         <li>false u svi ostalim slucajevima</li>
	 *         </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
