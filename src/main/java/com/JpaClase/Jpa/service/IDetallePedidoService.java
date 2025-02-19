package com.JpaClase.Jpa.service;

import com.JpaClase.Jpa.model.DetallePedido;
import java.util.List;

public interface IDetallePedidoService {


    public List<DetallePedido> getAllDetallePedido();   // ← ¿Es necesario una lista siendo que cada detalle es por un pedido a la vez?   public List<DetallePedido> getDetallePedido();   o    public DetallePedido getDetallePedido();

    public void saveDetallePedido (DetallePedido detalle);

    public void deleteDetallePedido(Integer id);

    public  DetallePedido findDetallePedido(Integer id);

    public void  editDetallePedido(Integer id, DetallePedido DetallePedidoUpdate);
}
