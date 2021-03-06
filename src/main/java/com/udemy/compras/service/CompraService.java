package com.udemy.compras.service;

import com.udemy.compras.domain.Cliente;
import com.udemy.compras.domain.Compra;
import com.udemy.compras.graphql.dto.CompraResumo;
import com.udemy.compras.graphql.exceptions.DomainException;
import com.udemy.compras.repository.CompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository rep;

    public Compra findById(Long id) {
        return rep.findById(id).orElse(null);
    }

    public List<Compra> findAll(Pageable pageable) {
        return rep.findAll(pageable).getContent();
    }

    @Transactional
//    @CacheEvict(value = "comprasByCliente", allEntries = true)
//    @CacheEvict(value = "comprasByCliente", key = "#c.cliente.id")
    public Compra save(Compra c) {
        if(c.getQuantidade() > 100) {
            throw new DomainException("Não é possível fazer uma compra com mais de 100 items");
        }
        return rep.save(c);
    }

    @Transactional
    public boolean deleteById(Long id) {
        if(rep.findById(id).isPresent()) {
            rep.deleteById(id);
            return true;
        }
        return false;
    }

//    @Cacheable(value = "comprasByCliente", key = "#c.id")
    public List<Compra> findAllByCliente(Cliente c) {
        return rep.findAllByCliente(c.getId());
    }

    public List<CompraResumo> findAllComprasRelatorio() {
        return rep.findAllComprasRelatorio();
    }
}
