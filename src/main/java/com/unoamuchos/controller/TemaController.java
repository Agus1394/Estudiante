package com.unoamuchos.controller;

import com.unoamuchos.models.Tema;
import com.unoamuchos.service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {

    @Autowired
    private ITemaService temaService;

    //crear un tema
    @PostMapping("/tema/crearTema")
    public String crearTema(@RequestBody Tema tema) {
        temaService.guardarTema(tema);
        return "Tema creado!";
    }

    //modificar datos de un tema determinado
    @PutMapping("/tema/modificar/{id_tema}")
    public Tema modificarTema(@PathVariable Long id_tema,
            @RequestParam(required = false, name = "cambiarNombre") String cambiarNombre,
            @RequestParam(required = false, name = "cambiarDesc") String cambiarDesc) {
        temaService.editarTema(id_tema, cambiarNombre, cambiarDesc);
        Tema tema = temaService.buscarTema(id_tema);
        return tema;
    }
}
