package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.ProductoDto;
import ar.edu.utn.frc.tup.lciii.entities.ProductoEntity;
import ar.edu.utn.frc.tup.lciii.models.Producto;
import ar.edu.utn.frc.tup.lciii.repositories.jpa.ProductoRepository;
import ar.edu.utn.frc.tup.lciii.services.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Producto getProductoById(Long id) {
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity = productoRepository.getReferenceById(id);
        if(Objects.isNull(productoEntity.getId())){
            throw new EntityNotFoundException();
        }
        Producto producto = modelMapper.map(productoEntity, Producto.class);
        return producto;
    }

    @Override
    public Producto createProducto(ProductoDto productoDto) {
       ProductoEntity productoEntity = new ProductoEntity();
       productoEntity.setId(productoDto.getId());
       productoEntity.setDescriptiton(productoDto.getDescription());
       ProductoEntity producto = productoRepository.save(productoEntity);
       return modelMapper.map(producto, Producto.class);

    }
}
