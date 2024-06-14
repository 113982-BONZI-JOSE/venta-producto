package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.ProductoDto;
import ar.edu.utn.frc.tup.lciii.services.ProductoService;
import ar.edu.utn.frc.tup.lciii.models.Producto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("{id}")
    public ResponseEntity<Producto> getById(@PathVariable Long id){
        Producto producto = productoService.getProductoById(id);
        return ResponseEntity.ok(producto);
    }

    @PostMapping("")
    public ResponseEntity<ProductoDto> createProducto(@RequestBody ProductoDto productoDto){
        Producto producto = productoService.createProducto(productoDto);
        return ResponseEntity.ok(modelMapper.map(producto, ProductoDto.class));
    }

}
