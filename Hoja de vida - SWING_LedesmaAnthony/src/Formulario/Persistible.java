package Formulario;

import Excepcion.FormularioException;

public interface Persistible<T> {
    void guardar(T obj) throws FormularioException;
    T mostrar() throws FormularioException;
}
