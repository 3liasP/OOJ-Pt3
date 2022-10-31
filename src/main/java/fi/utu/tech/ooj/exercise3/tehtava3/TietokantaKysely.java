package fi.utu.tech.ooj.exercise3.tehtava3;

import java.util.List;

/* Tehtävän 3A vastaus:
 * X on geneerinen tyyppiparametri. Sen avulla voidaan määrittää rajapinnan toteuttava tyyppi.
 * Tämän ansiosta tyyppiä ei tarvitse erikseen tarkistaa eikä rajapinnan sisällä tehdä
 * tyypin muutoksia, joka tekee koodista tehokkaamman ja virheettömämmän. Rajapinnassa geneerisiä
 * ovat rivit2, rivit3 ja rivi, sillä niissä hyödynnetään geneeristä tyyppiparametriä X.
 * Rajapintamääritys muotoilee kyselyn tulosdatan paramtrina syötetyn tyypin muotoiseksi.
 * 
 * Metodeista rivit1 ja rivit2 ovat muuten täysin samat, mutta rivit1 palauttaa Object-tyyppisen
 * taulukon, johon voi siis tallentaa Object-tyyppisiä muuttujia sekä kaikkia sen alityyppisiä
 * muuttujia. Metodi rivit2 sen sijaan ottaa vastaan vain tyypin X muuttujia sekä sen alityyppejä.
 * Metodi rivit3 palauttaa listan, joka sisältää tyypin X muuttujia sekä sen alityyppejä. Metodi
 * rivi palauttaa yhden rivin rivit2 metodin muodostamasta taulukosta. Palautus on tyyppiä X
 * tai jotakin sen alityyppiä.
 */

public interface TietokantaKysely<X> {
    // @.post RESULT == (montako tietokannan riviä kysely tuotti tulokseksi)
    int rivimäärä();
    
    // @.post RESULT == (kyselyn tulosrivit taulukkona)
    Object[] rivit1();

    // @.post RESULT == (kyselyn tulosrivit taulukkona)
    X[] rivit2();
    
    // @.post RESULT == (kyselyn tulosrivit listana)
    List<X> rivit3();

    // @.post RESULT == rivit2()[riviNumero]
    X rivi(int riviNumero);
}
