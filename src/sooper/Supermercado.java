package sooper;

import sooper.contenedores.Bolsa;
import sooper.contenedores.Caja;
import sooper.productos.Congelado;
import sooper.productos.Fresco;
import sooper.productos.Higiene;

public class Supermercado {
    public static void main(String[] args) {
        IPedido pedido = new Pedido("001");

        IContenedor bolsa1 = new Bolsa("B001", 40,25, 900);
        IContenedor caja1 = new Caja("C001",30,50,75);
        System.out.println("Bolsa: "+bolsa1);
        System.out.println("Caja: "+caja1);

        pedido.addContenedor(bolsa1);
        pedido.addContenedor(caja1);
        System.out.println("Pedido con contenedores: "+pedido);

        IProducto manzanas = new Fresco("MNZ",1000,1500);
        IProducto peras = new Fresco("PER",800,1200);
        IProducto helado = new Congelado("HLD",800,1000);
        IProducto papelWC = new Higiene("PWC",500,2500);

        IContenedor contManzanas = pedido.addProducto(manzanas);
        IContenedor contPeras = pedido.addProducto(peras);
        IContenedor contHelado = pedido.addProducto(helado);
        IContenedor contPapel = pedido.addProducto(papelWC);

        System.out.println("Pedido con productos: "+pedido);
    }
}