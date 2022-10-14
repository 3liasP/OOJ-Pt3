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