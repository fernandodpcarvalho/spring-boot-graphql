package com.udemy.compras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.compras.domain.Produto;
import com.udemy.compras.repository.ProdutoRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository rep;

    public List<Produto> findAll() {
        return rep.findAll();
    }

    public Produto findById(Long id) {
        return rep.findById(id).orElse(null);
    }

    @Transactional
    public Produto save(Produto p) {
        return rep.save(p);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if(rep.findById(id).isPresent()) {
            rep.deleteById(id);
            return true;
        }
        return false;
    }
}
