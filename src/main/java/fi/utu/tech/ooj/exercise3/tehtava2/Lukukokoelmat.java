package fi.utu.tech.ooj.exercise3.tehtava2;

import java.util.Random;
import java.util.Scanner;

/**
 * Lukukokoelma esittää listaa, jonka alkiot ovat Number-tyyppisiä lukuja.
 * 
 * Huom: luokan toteutuksesta ja määrittelyistä (loppuehdot, luokkainvariantit) on pääosin jätetty pois sellaiset
 * asiat, jotka eivä ole tehtävän kannalta tärkeitä. Yksinkertaisuussyistä kokoelmalla on mm. maksimikapasiteetti, 
 * joka annetaan parametrina konstruktorille.
 * 
 * @.classInvariant:  koko() <= kapasiteetti()
 * @.classInvariantPrivate koko() == viimeinenIndeksi && (listan alkiot on tallennettu taulukkoon
 *                         luvut indekseihin 0, 1, ..., viimeinenIndeksi)
 */
class Lukukokoelma {
	private Number[] luvut;
	private int viimeinenIndeksi = -1;
	
	public Lukukokoelma(int maksimiKapasiteetti) {
		luvut = new Number[maksimiKapasiteetti];
		
	}
	
	/**
	 * Palauttaa suurimman mahdollisen listaan tallennettavien alkioiden määrän. 
	 */
	public int kapasiteetti() { 
		return luvut.length;
	}
	
	/**
	 * Palauttaa listan nykyisen koon.
	 * @.pre: true
	 * @.post: RESULT == (listassa olevien alkioiden lukumäärä)
	 */
	public int koko() {
		return viimeinenIndeksi + 1;
	}
	
	/**
	 * Lisää luvun n listan viimeiseksi alkioksi.
	 * 
	 *  @.pre koko() < kapasiteetti()
	 *  @.post hae(koko()-1) == n
	 */
	public void lisää(Number n) {
		luvut[++viimeinenIndeksi] = n;
	}
	
	/**
	 * Palauttaa listan paikassa i olevan alkion.
	 * 
	 * @.pre 0 <= i < koko()
	 * @.post RESULT == (listan paikassa i oleva alkio)
	 */
	public Number hae(int i) {
		return luvut[i];
	}

	// Tehtävän 2A vastaus:
	public void lukukokoelmaDemo(){
		Lukukokoelma lk = new Lukukokoelma(5);
		lk.lisää(2);
		lk.lisää(3.5);
		System.out.println(lk.koko());
		Kokonaislukukokoelma klk = new Kokonaislukukokoelma(5);
		klk.lisää(2);
		klk.lisää(3.5);
		System.out.println(klk.koko());
		/*
		 * Yllä olevasta lyhyestä ohjelmasta huomataan, että lukukokoelma tyyppisellä oliolla numeroiden
		 * lisäykset onnistuvat. Kokonaislukukokoelma tyyppisen olion tapauksessa toinen lisäys ei kuitenkaan
		 * onnistu, sillä se ei ole kokonaisluku. Liskovin korvaavuusperiaate ei toteudu, sillä Lukukokoelma-luokan
		 * perivä Kokonaislukukokoelma-luokka rajaa syötettävät arvot kokonaislukuihin. Tämä tarkoittaa sitä, että
		 * Lukukokoelma-luokkaa ei voida korvata Kokonaislukukokoelma-luokalla.
		 */
	}
	/*
	 * Tehtävän 2B vastaus:
	 * Alkuehdot eivät noudata kontravarianssia, koska tämä antaa ehdoksi sen, että Kokonaislukukokoelmassa parametrin
	 * tulee olla Integer, joka on Number-tyypin alityyppi. Aliluokan metodin alkuehto siis tiukentaa ehtoa eikä
	 * löyhennä sitä niin kuin varianssisääntöjen mukaan kuuluisi. Loppuehdot ovat invariantit, jolloin ne ovat
	 * myös kovariantit ja täten noudattavat varianssisääntöjä. Kokonaislukukokoelma-luokan metodissa nostetaan
	 * poikkeus, jota ei käsitellä yliluokassa. Täten poikkeukset eivät noudata kovarianssia.
	 * 
	 * Tehtävän 2C vastaus:
	 * Alkuehdot ja loppuehdot ovat invariantit ja täten noudattavat varianssisääntöjä. Paluuarvo sen sijaan
	 * ei noudata kovarianssia, sillä Kokonaislukukokoelma-luokan metodi tyyppipakottaa paluuarvon Integer-
	 * tyyppiseksi. Kovarianssin mukaan paluuarvojen tulisi olla samaa tyyppiä eli tässä tapauksessa Number-
	 * tyyppiä, koska yliluokan metodi palauttaa Number-tyyppisen arvon.
	 * 
	 * Tehtävän 2D vastaus:
	 * Luokkainvariantit noudattavat kovarianssia, koska aliluokan luokkainvariantti tiukentaa ehtoja asettamalla
	 * ehdon, jonka mukaan kaikkien listan alkioiden tulee olla Integer-tyyppisiä.
	 */
}

/**
 * Lukukokoelma, jonka alkiot ovat tyyppiä Integer.
 * 
 * @.classInvariant:  koko() <= kapasiteetti() && FORALL(i : 0 <= i < koko(); hae(i) instanceof Integer)
 *
 */
class Kokonaislukukokoelma extends Lukukokoelma {
	public Kokonaislukukokoelma(int maksimiKapasiteetti) {
		super(maksimiKapasiteetti);
	}
	
	/**
	 *  Lisää luvun n listan viimeiseksi alkioksi.
	 * 
	 *  @.pre koko() < kapasiteetti() && n instanceof Integer
	 *  @.post hae(koko()-1) == n
	 */
	@Override
	public void lisää(Number n) {
		if (!(n instanceof Integer)) {
			throw new NumberFormatException("Vääräntyyppinen luku: " + n);
		}
		super.lisää(n);
	}
	
	/**
	 * Palauttaa listan paikassa i olevan alkion.
	 * 
	 * @.pre 0 <= i < koko()
	 * @.post RESULT == (listan paikassa i oleva alkio)
	 */
	@Override
	public Integer hae(int i) {
		return (Integer) super.hae(i);
	}
}
