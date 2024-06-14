package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.ProductoDto;
import org.springframework.stereotype.Service;
import ar.edu.utn.frc.tup.lciii.models.Producto;

@Service
public interface ProductoService {

    Producto getProductoById(Long id);

    Producto createProducto(ProductoDto productoDto);
}
