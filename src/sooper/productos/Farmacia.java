package sooper.productos;

import sooper.IProducto;
import sooper.emuns.Categoria;

public class Farmacia extends Producto{

    public Farmacia(String referencia, int peso, int volumen) {
        super(referencia, peso, volumen);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.FARMACIA;
    }

    @Override
    public boolean esCompatible(IProducto p) {
        return !Categoria.ALIMENTACION.equals(p.getCategoria()) && !Categoria.MASCOTAS.equals(p.getCategoria());
    }
}
