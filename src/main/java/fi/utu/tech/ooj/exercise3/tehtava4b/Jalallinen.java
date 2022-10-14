package fi.utu.tech.ooj.exercise3.tehtava4b;

public interface Jalallinen {
    default int raajaMäärä() {
        return 4;
    }

    default void kävele(String kohde) {
        System.out.println(this + " kävelee paikkaan " + kohde);
        for (int i = 0; i < raajaMäärä(); i++)
            System.out.println(this + " sanoo: astun nyt tassulla " + i);
    }
}
