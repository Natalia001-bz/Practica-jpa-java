package com.JpaClase.Jpa.controller;

import com.JpaClase.Jpa.model.Persona;
import com.JpaClase.Jpa.service.IPersonaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso) {
        personaService.savePersona(perso);
        return "La persona fue creada";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return "La persona fue eliminada";
    }

    @GetMapping("/personas/traer/{id}")
    public ResponseEntity<Persona> findPersona(@PathVariable Long id) {
       Persona persona = personaService.findPersona(id);
       if (persona == null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(persona);
    }

    @PutMapping("/personas/editar/{id}")
    public ResponseEntity<String>  editarPersona(
            @PathVariable Long id,
            @RequestBody Persona personaActualizada) {
        personaService.editarPersona(id, personaActualizada);
        return  ResponseEntity.ok("La persona se actualizó correctamente");
// La consulta debe tener una forma metodo, url, body y la respuesta tambien debe tener la misma forma
    }

}
