package fi.utu.tech.ooj.exercise3.tehtava4ab;

import java.util.ArrayList;
import java.util.List;

public abstract class Eläin {
    static <X extends Z, Y extends Z, Z extends Eläin> List<Z> yhdistä(List<X> xs, List<Y> ys) {
        var tmp = new ArrayList<Z>();
        for (var x : xs) tmp.add(x);
        for (var y : ys) tmp.add(y);
        return tmp;
    }
}
/*
 * Tehtävän 4B vastaus:
 * Tuloksena saadaan lista, joka sisältää Z-tyyppisiä olioita tai sen alityyppejä. Z perii Eläin-luokan.
 * Täten listaan voi sijoittaa Eläin-, Z-, X-, ja Y-tyypin olioita. Graafista voidaan siis lukea yhteensopivat
 * tyyppisignatuurit, kun tiedetään että List<Z> vastaa graafissa List<? extends Animal>-signatuuria.
 * Tällöin yhteensopivia ovat List<X>, List<Y>, List<? extends Z> ja List<Z>. 
 */
