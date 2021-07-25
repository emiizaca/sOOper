package sooper.contenedores;

import sooper.IContenedor;
import sooper.IProducto;
import java.util.Set;

public abstract class Contenedor implements IContenedor {

    private String referencia;
    private int alto;
    private int resistencia;
    private Set<IProducto> productos;

    public Contenedor(String referencia, int alto) {
        this.referencia = referencia;
        this.alto = alto;
    }

    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public int getVolumen() {
        return alto * getSuperficie();
    }

    @Override
    public int volumenDisponible() {
        return 0;
    }

    @Override
    public int getResistencia() {
        return resistencia;
    }

    @Override
    public Set<IProducto> getProductos() {
        return productos;
    }

    @Override
    public boolean meter(IProducto producto) {
        return false;
    }

    @Override
    public boolean resiste(IProducto producto) {
        return false;
    }
}
