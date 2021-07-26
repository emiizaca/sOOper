package sooper.productos;

import sooper.IProducto;

public class Farmacia extends Producto{

    public Farmacia(String referencia, int peso, int volumen) {
        super(referencia, peso, volumen);
    }

    @Override
    public String getCategoria() {
        return "Farmacia";
    }

    @Override
    public boolean esCompatible(IProducto p) {
        return false;
    }
}
