package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.dtos.ProductoDto;
import ar.edu.utn.frc.tup.lciii.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

}
