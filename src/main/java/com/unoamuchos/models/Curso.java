package com.unoamuchos.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id_curso;
    
    @Basic
    private String nombre;
    private String modalidad;
    private String fecha_finalizacion;    
    
    @OneToMany
    private List<Tema> listaDeTemas;
}
