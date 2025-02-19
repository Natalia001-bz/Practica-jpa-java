package com.JpaClase.Jpa.repository;


import com.JpaClase.Jpa.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
}
