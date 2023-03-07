package com.unoamuchos.controller;

import com.unoamuchos.dto.CursoTemaDTO;
import com.unoamuchos.models.Curso;
import com.unoamuchos.service.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @Autowired
    private ICursoService cursoService;
    
    //crear un curso
    @PostMapping("/curso/crearCurso")
    public String crearCurso(@RequestBody Curso curso) {
        cursoService.guardarCurso(curso);
        return "Curso creado!";
    }

    //obtener los cursos
    @GetMapping("/curso/obtenerCurso")
    public List<Curso> traerCursos() {
        return cursoService.traerCurso();
    }
    
    //obtener el curso determinado
    @GetMapping("/curso/tema/{id_curso}") 
    public CursoTemaDTO temasPorCurso(@PathVariable Long id_curso){
        return cursoService.buscarTemasPorCursos(id_curso);      
    }
    
    //obtener cursos con la palabra Java
    @GetMapping("/curso/java")
    public List<Curso> traerCursoJava(){
        return cursoService.traerCursosJava();   
    }
    
    //modificar los datos de un curso
    @PutMapping("/curso/modificar")
    public Curso editarCurso(@RequestBody Curso curso){
        cursoService.editarCurso(curso);        
        return cursoService.buscarCurso(curso.getId_curso());
    }
    
}

