package fi.utu.tech.ooj.exercise3.tehtava1;

import java.util.ArrayList;

public class T1Selitettävät {

}

// Tehtävät 1A ja 1B: selitä annettujen equals- ja clone-metodien toiminta. Luokat on toteutettu vain siltä
// osin kuin on tämän tehtävän kannalta tarpeellista.

/**
 * Teoskappale esittää kirjastosta löytyvää teoksen yksittäiskappaletta. Teoskappaleilla on numerot,
 * joiden avulla voidaan pitää kirjaa siitä, mitkä teoskappaleet ovat parhaillaan lainassa. Numerot
 * ovat yksikäsitteisiä vain saman teoksen eri kappaleille, eri teosten teoskappaleilla voi olla sama numero.
 * Lisäksi kirjaa pidetään teoskappaleen kunnosta sekä muutamasta viimeisimmästä lainaajasta.
 */
class Teoskappale {
    enum Kuntoluokitus {HYVÄ, OK, HUONO}

    private Teos teos;
    private int numero;
    private Kuntoluokitus kunto;
    private ArrayList<String> edellisetLainaajat;

    public Teoskappale(Teos t, int numero, Kuntoluokitus k) {
        teos = t;
        this.numero = numero;
        kunto = k;
        edellisetLainaajat = new ArrayList<>();
    }

    // 1A: selitä tämän metodin toiminta: 1) Kerro, mihin equals-metodeilta vaadittaviin ominaisuuksiin kukin
    // ohjelmakoodirivi liittyy. 2) Arvioi jokaisesta koodirivistä, toimisiko metodi oikein, mikäli ko.
    // rivi jätettäisiin pois ja toteutus pidettäisiin muilta osin samana.

    /* VASTAUS 1A:
     *
     * Metodin määritys liittyy siihen, että metodin on toimittava olion tyypistä riippumatta. Kyseessä on siis ns. universaali ekvivalenssi.
     * Metodi vaatii tämän määrittelyrivin toimiakseen. Ensimmäinen if-lause liittyy null-samuuteen. Kyseisellä rivillä tarkistetaan, onko
     * parametrina annettu olio tyhjä. Oikeellinen equals-metodi vaatii tämän ominaisuuden, mutta metodi toimisi silti oikein
     * ilman tätä riviä. Toinen if-lause liittyy refleksiivisyyteen. Tällä testataan identtisyys. Myös refleksiivisyys vaaditaan
     * oikeelliseen equals-metodiin, mutta metodi toimisi oikein ilmankin tätä riviä. Kolmas if-lause liittyy universaaliin ekvivalenssiin.
     * Tämä tarkistaa onko parametrina annettu olio Teoskappale-luokan tyyppinen. Tämä vaaditaan oikeelliseen equals-metodiin eli
     * metodi ei toimisi myöskään ilman tätä riviä. Seuraavalla rivillä voidaan turvallisesti tyyppipakottaa olio "toinen" Teoskappale-tyyppiseksi,
     * sillä edellisellä rivillä on tarkistettu, että toinen on Teoskappale-luokan tyyppinen. Viimeisessä return-lauseessa tarkistetaan
     * ensin transitiivisuus delegoimalla se equals-metodille. Tämän jälkeen tarkistetaan identtisyys. Koko viimeinen rivi liittyy
     * siis konsistenssiin ja se tarkistaa pintasamuuden. Metodi ei toimisi oikein ilman tätä riviä.
     */
    @Override
    public boolean equals(Object toinen) {
        if (toinen == null) return false;
        if (toinen == this) return true;
        if (!(toinen instanceof Teoskappale)) return false;
        Teoskappale t2 = (Teoskappale) toinen;
        return t2.teos.equals(teos) && t2.numero == numero;
    }

    // 1B: selitä tämän metodin toiminta. Kerro erityisesti, millaisessa suhteessa tuloksena saadun Teoksen
    // viittaustyyppiset instanssimuuttujat ovat kloonattavaan Teokseen verrattuna: viittaavatko ne
    // samaan objektiin vai eri objekteihin, ja mitä merkitystä asialla on käytännössä.
    //
    // Huom: metodille ei ole suunniteltu mitään erityistä käyttötarkoitusta, joten selityksessä ei kannata
    // lähteä oletuksesta, että toiminta on kaikin puolin järkevää.

    /* VASTAUS 1B:
     *
     * Ensimmäisenä metodi määritellään public määreellä ja kerrotaan, että sen tulee palauttaa Teoskappale-tyyppinen
     * olio. Metodin varsinaisen toteutuksen ensimmäisellä rivillä luodaan "tulos" niminen olio, joka on Teoskappale-
     * tyyppinen. Tämän jälkeen on tehty try-catch-lohko sen sijaan, että metodin signatuurissa olisi määritelty
     * sen nostavan poikkeus. Try-lohkon sisällä tulos-muuttujaan kloonataan alkuperäinen olio, joka on määritetty
     * Teoskappale-tyyppiseksi Object-tyypin sijaan. Catch-lohkossa otetaan kiinni mahdollinen poikkeus, jos oliota
     * ei jostakin syystä voitaisikaan kloonata. Tämän jälkeen kopion muuttujaan edellisetLainaajat kloonataan
     * viittaus alkuperäisen olion edellisetLainaajat-muuttujasta. Lopuksi uusi olio palautetaan. Kloonatun Teoksen
     * muut paitsi edellisetLainaajat viittaustyyppiset instanssimuuttujat viittaavat samaan objektiin. Täten niillä
     * kaikilla on samat Teoksen muuttujat, kunto ja numero. Muuttuja edellisetLainaajat viittaa eri objekteihin,
     * jolloin eri klooneilla on eri lainaajat.
     */
    @SuppressWarnings("unchecked")
    @Override
    public Teoskappale clone() {
        Teoskappale tulos;
        try {
            tulos = (Teoskappale) super.clone();
        } catch (CloneNotSupportedException e) { // Tätä poikkeusta ei oikeasti pitäisi tapahtua
            throw new RuntimeException("Kloonaus epäonnistui!");
        }
        tulos.edellisetLainaajat = (ArrayList<String>) edellisetLainaajat.clone();
        return tulos;
    }


    // Pari esimerkkiä havainnointi- ja asetusmetodeista, loppuja metodeja ei toteutettu.
    public Kuntoluokitus annaKunto() {
        return kunto;
    }

    public void asetaKunto(Kuntoluokitus kunto) {
        this.kunto = kunto;
    }
}

/**
 * Teos esittää teokseen liittyviä perustietoja. (Toteutettu vain osin)
 */
class Teos implements Cloneable {
    String nimi;
    int julkaisuvuosi;

    public Teos(String nimi, int julkaisuvuosi) {
        this.nimi = nimi;
        this.julkaisuvuosi = julkaisuvuosi;
    }

    @Override
    public Teos clone() {
        try {
            return (Teos) super.clone();
        } catch (CloneNotSupportedException e) { // Tätä poikkeusta ei oikeasti pitäisi tapahtua
            throw new RuntimeException("Kloonaus epäonnistui!");
        }
    }
}