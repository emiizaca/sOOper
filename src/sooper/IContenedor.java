package sooper;

import sooper.emuns.TipoContenedor;

import java.awt.image.ImageProducer;
import java.util.Set;

public interface IContenedor {

    String getReferencia();

    int getVolumen();

    int getSuperficie();

    int volumenDisponible();

    int getResistencia();

    Set<IProducto> getProductos();

    TipoContenedor getTipo();

    boolean meter(IProducto producto);

    boolean resiste(IProducto producto);
}
