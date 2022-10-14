package fi.utu.tech.ooj.exercise3.tehtava4b;

public interface Lentävä {
    default void lennä(String kohde) {
        System.out.println(this + " lentää paikkaan " + kohde);
    }
}
