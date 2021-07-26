package sooper.contenedores;

import sooper.IContenedor;
import sooper.IProducto;

import java.util.HashSet;
import java.util.Set;

public abstract class Contenedor implements IContenedor {

    private String referencia;
    private int alto;
    private int resistencia;
    private Set<IProducto> productos;

    public Contenedor(String referencia, int alto, int resistencia) {
        this.referencia = referencia;
        this.alto = alto;
        this.resistencia = resistencia;
        this.productos = new HashSet<IProducto>();
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
        return getVolumen() - volumenOcupado();
    }

    private int volumenOcupado() {
        int res = 0;
        for(IProducto p : productos){
            res += p.getVolumen();
        }
        return res;
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
        boolean resistenciaOK = resiste(producto);
        boolean volumenOK = producto.tengoEspacio(this);
        boolean compatibilidadOK = true;

        for (IProducto p: productos) {
            boolean compatibleOK = producto.esCompatible(p);
            compatibilidadOK &= compatibleOK;
        }

        if(resistenciaOK && volumenOK && compatibilidadOK){
            productos.add(producto);
            producto.meter(this);
        }
        return resistenciaOK && volumenOK && compatibilidadOK;
    }

    @Override
    public boolean resiste(IProducto producto) {
        return resistencia > producto.getPeso();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contenedor: "+referencia+" ["+getTipo()+ "] (sup "+getSuperficie()+ "cm2 - vol "+getVolumen()+"cm3 - resistencia "+getResistencia()+" g).\n");
        if(productos.isEmpty()){
            sb.append("\t\tvacío\n");
        }
        for (IProducto p: productos) {
            sb.append("\t\t"+p+"\n");
        }
        sb.append("\t\t>> Disponible vol "+volumenDisponible() + "cm3");
        return sb.toString();
    }
}
