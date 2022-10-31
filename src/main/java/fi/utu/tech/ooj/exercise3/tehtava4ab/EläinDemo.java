package fi.utu.tech.ooj.exercise3.tehtava4ab;

import java.util.ArrayList;

public class EläinDemo {

    static void demo() {
        ArrayList<Eläin> elukat = new ArrayList<Eläin>();
        ArrayList<Kissa> kissat = new ArrayList<Kissa>();
        ArrayList<Koira> koirat = new ArrayList<Koira>();

        // Tehtävän 4A vastaus:
        elukat.addAll(kissat);
        elukat.addAll(koirat);
        /* 
         * Listojen lisääminen listaan elukat onnistuu, koska elukat lista on Eläin-tyyppinen lista
         * ja tällöin se voi ottaa vastaan Eläin-tyyppisiä muuttujia, sekä sen alityyppejä. Luokat
         * Kissa ja Koira perivät Eläin-luokan, jolloin siis kissat ja koirat listojen muuttujat ovat
         * Eläin-luokan alityyppisiä.
         * 
         * Listojen kissat ja koirat viittauksia ei voida sijoittaa elukat listaan, sillä nämä listat
         * eivät ole Eläin-tyyppisiä.
         * 
         * Alla oleva koodi toimii, koska luotu lista kelpuuttaa kaikki Eläin-tyypit sekä sen
         * alityypit.
         */
        ArrayList<? extends Eläin> elukat2 = new ArrayList<Eläin>();
        elukat2 = kissat;
    }
}

/*
 * Tehtävän 4B vastaus löytyy Elain.java tiedostosta.
 */