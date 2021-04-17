/**
 *
 * Una interfaz es una clase completamente abstracta, es decir es una clase sin
 * implementación. No es necesario ponerle abstract ya que lo son
 * implicitamente. Si adicionalmente tiene miembros-datos, estos seran
 * constantes static y final.
 */
package com.aprendec.dao;

import com.aprendec.dao.beans.ProductoDTO;
import java.util.List;

public interface ProductoDAO {

    public String obtenerCodProd();

    public ProductoDTO obtenerProducto(String codigo);

    public List<ProductoDTO> listarProductos(String nombre);

    public int registrarProducto(ProductoDTO productoDTO);

    public int actualizarProducto(ProductoDTO productoDTO);

    public int eliminarProducto(String codigo);

}