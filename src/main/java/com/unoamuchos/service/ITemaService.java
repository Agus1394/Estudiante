package com.unoamuchos.service;

import com.unoamuchos.models.Tema;
import java.util.List;


public interface ITemaService {
    
    public List<Tema> traerTema();
    
    public void guardarTema(Tema tema);
    
    public void borrarTema(Long id_tema);
    
    public void editarTema(Long id_tema, String cambiarNombre, String cambiarDesc);

    public Tema buscarTema(Long id_tema); 
    
}