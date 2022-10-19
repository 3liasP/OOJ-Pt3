package fi.utu.tech.ooj.exercise3.tehtava4c;

public abstract class Eläin {
    // palauttaa olion luokan nimen
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
