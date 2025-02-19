package com.JpaClase.Jpa.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idPago;
    private Integer idPedido;
    private Double cantidad;
    private Double subtotal;

}



//-- Tabla detalle_pedido
//CREATE TABLE detalle_pedido (
//        id_detalle_pedido INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
//        id_pedido INT NOT NULL,
//        id_producto INT NOT NULL,
//        cantidad INT NOT NULL,
//        subtotal DECIMAL(10,2) NOT NULL,
//FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
//FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
//        ) ENGINE=InnoDB;


