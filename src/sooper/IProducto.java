package sooper;

import sooper.contenedores.Contenedor;
import sooper.emuns.Categoria;

public interface IProducto {

    String getReferencia();

    int getPeso();

    int getVolumen();

    Categoria getCategoria();

    boolean esCompatible(IProducto p);

    boolean tengoEspacio(IContenedor contenedor);

    void meter(Contenedor contenedor);
}
