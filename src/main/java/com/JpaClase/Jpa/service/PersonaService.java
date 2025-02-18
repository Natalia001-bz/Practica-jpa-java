package com.JpaClase.Jpa.service;

import com.JpaClase.Jpa.model.Persona;
import com.JpaClase.Jpa.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
@Autowired
private IPersonaRepository personaRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = personaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
personaRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
personaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
Persona perso = personaRepository.findById(id).orElse(null);
        return null;
    }

    @Override
    public void editarPersona(Long id, Persona personaActualizada) {
        Persona personaExistente = personaRepository.findById(id).orElse(null);

        if(personaExistente != null){
            personaExistente.setNombre(personaActualizada.getNombre());
            personaExistente.setApellido(personaActualizada.getApellido());
            personaExistente.setEdad(personaActualizada.getEdad());
            personaRepository.save(personaExistente);
        }else{
            System.out.println("No se encontró persona con el id: " +  id);
        }
    }
}
