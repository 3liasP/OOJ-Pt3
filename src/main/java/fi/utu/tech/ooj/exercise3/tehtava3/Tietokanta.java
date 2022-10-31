package fi.utu.tech.ooj.exercise3.tehtava3;

import java.util.HashSet;

public class Tietokanta<E extends Elokuva> {
    // Tehtävien 3B ja 3C vastaukset:
    HashSet<E> kiinnostavat;
    HashSet<E> huonot;
    HashSet<E> esitetyt;
    HashSet<E> luokittelemattomat;

    public Tietokanta(){
        this.kiinnostavat = new HashSet<E>();
        this.huonot = new HashSet<E>();
        this.esitetyt = new HashSet<E>();
        this.luokittelemattomat = new HashSet<E>();
    }

    public HashSet<E> esittämättömät(){
        HashSet<E> esittämättömät = new HashSet<E>();
        for(E elokuva : kiinnostavat){
            if(!(esitetyt.contains(elokuva))){
                esittämättömät.add(elokuva);
            }
        }
        for(E elokuva : huonot){
            if(!(esitetyt.contains(elokuva))){
                esittämättömät.add(elokuva);
            }
        }
        return esittämättömät;
    }
}
