/**
 * @file    ProductoDAOList.java
 * @Author  Jose María del Águila López
 * @Author  Rafael Galán Ruiz
 */

package com.tiendainformatica.list;

import com.tiendainformatica.dao.ProductoDAO;
import com.tiendainformatica.model.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOList implements ProductoDAO {

    private static ArrayList<Producto> productos;
    private static int idProducto = 1;

    /**
     * @brief Constructor ProductoDAOList
     * @brief se añaden los diferentes productos
     * Los productos contienen:
     *                             idProducto
     *                             Nombre
     *                             Imagen
     *                             Descripción
     *                             Precio
     *                             Categoria
     */
    public ProductoDAOList() {
        if (productos == null) {
            productos=new ArrayList<>();
            productos.add(new Producto(idProducto++,"ASUS - Placa base","/imagenes/placaBase.jpg","Placa de base para gaming con AURA Sync RGB LED, DDR4 3200MHz, M.2, USB 3.1 conector panel y tipo A/C",99.99,"Placa base"));
            productos.add(new Producto(idProducto++,"AMD RYZEN 7","/imagenes/amdRyzen.jpg","AMD RYZEN 7 1700- Procesador de 3.7 GHz, Socket AM4 con ventilador Wraith Spire incluido",149.45,"Procesadores"));
            productos.add(new Producto(idProducto++,"Ballistix Sport LT","/imagenes/ram.jpg","Ballistix Sport LT 4GB DDR4 2400 MT/s (PC4-19200) SR x8 DIMM 288-Pin - BLS4G4D240FSE (Rojo)",120,"Memoria RAM"));
            productos.add(new Producto(idProducto++,"ASUS - Tarjeta gráfica","/imagenes/grafica.jpg","ASUS STRIX-GTX1080-8G-GAMING - Tarjeta gráfica (Strix, NVIDIA GeForce GTX 1080, 8 GB, GDDR5X, DVI, HDMI, DP)",253.55,"Tarjeta Grafica"));
            productos.add(new Producto(idProducto++,"Logitech G29","/imagenes/mando.jpg","Logitech G29 - Volante para simulación de carreras con pedales incluidos, compatible con PS4, PS3 y PC",83,"Gaming"));
        }
    }
    
    /**
     * @brief Busca un producto por su id
     * @param id
     * @return El producto que conicida con el id dado
     */
    @Override
    public Producto buscaId(Integer id) {
        Producto encontrado = null;
        for (Producto p : productos) {
            if (p.getId() == id) {
                encontrado = p;
            }
        }
        return encontrado;
    }
    
    /**
     * @brief Funcion que devuelve todos los productos que hay en la plataforma
     * @return Todos los productos
     */
    @Override
    public List<Producto> buscaTodos() {
        return productos;
    }

    /**
     * @brief función papa añadir un nuevo producto
     * @param p
     * @return true cuando se crea el producto
     */
    @Override
    public boolean crea(Producto p) {
        Producto nuevoProducto = new Producto(p);
        nuevoProducto.setId(idProducto);
        productos.add(nuevoProducto);
        p.setId(idProducto);
        idProducto++;
        return true;
    }
    
    /**
     * @brief función para guardar un nuevo producto
     * @param p
     * @return true si el producto se ha guardado correctamente
     */
    @Override
    public boolean guarda(Producto p) {
        boolean guardado= false;
        Producto nuevoProducto = new Producto(p);
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == nuevoProducto.getId()) {
                productos.set(i, nuevoProducto);
                guardado = true;
            }
        }
        return guardado;
    }

    /**
     * @brief Función para borrar un producto
     * @param id
     * @return true si el producto se borra correctamente
     */
    @Override
    public boolean borra(Integer id) {
        boolean borrado = false;
        for (Producto p : productos) {
            if (p.getId() == id) {
                productos.remove(p);
                borrado = true;
            }
        }
        return borrado;
    }

    /**
     * @brief función que devuelve los productos según la categoria dada
     * @param categoria
     * @return devuelve una lista de productos con la categoria en común
     */
    @Override
    public List<Producto> buscaCategoria(String categoria) {
        List<Producto> listaProd = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCategoria().equals(categoria)) {
                listaProd.add(p);
            }
        }
        return listaProd;
    }

}
