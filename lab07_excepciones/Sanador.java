package Personaje;

public interface Sanador {
    void curarAliado(Personajes aliado) throws RpgException;
    int getPoderCuracion();
}
