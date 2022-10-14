package fi.utu.tech.ooj.exercise3.tehtava4b;

public interface Uimataitoinen {
    default void ui(String kohde) {
        System.out.println(this + " ui paikkaan " + kohde);
    }
}
