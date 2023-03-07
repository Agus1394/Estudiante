package com.unoamuchos.service;

import com.unoamuchos.dto.CursoTemaDTO;
import com.unoamuchos.models.Curso;
import java.util.List;


public interface ICursoService {
    
    public List<Curso> traerCurso();
    
    //método q obtiene los cursos que contengan la palabra Java"
    public List<Curso> traerCursosJava();
    
    public void guardarCurso(Curso curso);
    
    public void eliminarCurso(Long id_curso);
    
    public void editarCurso(Curso curso);
    
    public Curso buscarCurso(Long id_curso);
    
    //método q busca por medio de la dto los temas
    public CursoTemaDTO buscarTemasPorCursos(Long id_curso);
    
}
