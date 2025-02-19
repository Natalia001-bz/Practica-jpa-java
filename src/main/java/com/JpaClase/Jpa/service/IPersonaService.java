package com.JpaClase.Jpa.service;

import com.JpaClase.Jpa.model.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> getPersonas();

    public void savePersona (Persona persona);

    public void deletePersona(Long id);

    public  Persona findPersona(Long id);

    public void  editarPersona(Long id, Persona  personaActualizada);


}
