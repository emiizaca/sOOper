package sooper;

public interface IProducto {

    String getReferencia();

    int getPeso();

    int getVolume();

    String getCategoria();

    boolean esCompatible(IProducto p);

    boolean tengoEspacio(IContenedor contenedor);
}
