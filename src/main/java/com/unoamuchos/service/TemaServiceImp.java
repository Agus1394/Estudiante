package com.unoamuchos.service;

import com.unoamuchos.models.Tema;
import com.unoamuchos.repository.ITemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaServiceImp implements ITemaService{
    
    @Autowired
    private ITemaRepository temaRepo;

    @Override
    public List<Tema> traerTema() {
        return temaRepo.findAll();
    }

    @Override
    public void guardarTema(Tema tema) {
        temaRepo.save(tema);
    }

    @Override
    public void borrarTema(Long id_tema) {
        temaRepo.deleteById(id_tema);
    }

    @Override
    public Tema buscarTema(Long id) {     
        return temaRepo.findById(id).orElse(null);     
    }

    @Override
    public void editarTema(Long id_tema, String cambiarNombre, String cambiarDesc) {
            //busco el obj tema
            Tema tema= this.buscarTema(id_tema);
            
            //se edita
            tema.setNombre(cambiarNombre);
            tema.setDescripcion(cambiarDesc);
            
            //se guarda el tema editado
            this.guardarTema(tema);
    }
    
}
