package com.unoamuchos.service;

import com.unoamuchos.dto.CursoTemaDTO;
import com.unoamuchos.models.Curso;
import com.unoamuchos.repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImp implements ICursoService{
    
    @Autowired
    private ICursoRepository cursoRepo;

    @Override
    public List<Curso> traerCurso() {   
        return cursoRepo.findAll();
    }

    @Override
    public void guardarCurso(Curso curso) {
        cursoRepo.save(curso);
    }

    @Override
    public void eliminarCurso(Long id_curso) {
        cursoRepo.deleteById(id_curso);
    }

    @Override
    public void editarCurso(Curso curso) {
        this.guardarCurso(curso);
    }

    @Override
    public Curso buscarCurso(Long id_curso) {
    return cursoRepo.findById(id_curso).orElse(null);
    }

    //Método que busca los cursos que contengan la palabra Java
    @Override
    public List<Curso> traerCursosJava() {
        String palabra="Java";
        String compararPalabra;
        
        List<Curso> listaCursos= this.traerCurso();
        List<Curso> listaCursosJava= new ArrayList<Curso>();
        
        for (Curso curso : listaCursos) {
            compararPalabra= curso.getNombre();
            if (compararPalabra.equalsIgnoreCase(palabra)) { //se valida si está o no en mayúsculas
                listaCursosJava.add(curso);
            }
        }
        return listaCursosJava;
    }

    @Override
    public CursoTemaDTO buscarTemasPorCursos(Long id_curso) {
        CursoTemaDTO cursoTema= new CursoTemaDTO();
        Curso curso= this.buscarCurso(id_curso);
        cursoTema.setNombreCurso(curso.getNombre());
        cursoTema.setListaTemas(curso.getListaDeTemas());
        return cursoTema;     
    }
    
}
