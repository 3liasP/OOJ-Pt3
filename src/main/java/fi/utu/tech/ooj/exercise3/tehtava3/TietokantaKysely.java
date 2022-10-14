package fi.utu.tech.ooj.exercise3.tehtava3;

import java.util.List;

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
