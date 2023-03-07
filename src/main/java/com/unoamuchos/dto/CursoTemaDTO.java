package com.unoamuchos.dto;

import com.unoamuchos.models.Tema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoTemaDTO {
    
    private String nombreCurso;
    private List<Tema> listaTemas;   
}
