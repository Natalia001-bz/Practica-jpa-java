package com.JpaClase.Jpa.service;

import com.JpaClase.Jpa.model.DetallePedido;
import com.JpaClase.Jpa.repository.IDetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService implements IDetallePedidoService{
    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;
    //private IPedidoRepository pedidoRepository;
    // private IProductRepository productRepository;


    @Override
    public List<DetallePedido> getAllDetallePedido() {
        List<DetallePedido> listaDetalles = detallePedidoRepository.findAll();
        return listaDetalles;
    }

    @Override
    public void saveDetallePedido(DetallePedido detalle) {
        detallePedidoRepository.save(detalle);

    }

    @Override
    public void deleteDetallePedido(Integer id) {
detallePedidoRepository.deleteById(id);
    }

    @Override
    public DetallePedido findDetallePedido(Integer id) {
        DetallePedido detalle = detallePedidoRepository.findById(id).orElse(null);
        return null;
    }

    @Override
    public void editDetallePedido(Integer id, DetallePedido DetallePedidoUpdate) {

    }
}
