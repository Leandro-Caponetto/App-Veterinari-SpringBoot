package com.veterinaria.springboot.controller;

import com.veterinaria.springboot.dto.MascotaDuenioDTO;
import com.veterinaria.springboot.model.Mascota;
import com.veterinaria.springboot.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MascotaController {

    private final MascotaService mascotaService;

    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota mascota){
        mascotaService.saveMascota(mascota);
        return "La mascota fue creada correctamente";
    }

    @GetMapping("/mascotas/traer")
    public List<Mascota> traerMascotas(){
        return mascotaService.getMascotas();
    }

    @DeleteMapping("/mascotas/borrar/{id_mascota}")
    public String deleteMascota(@PathVariable Long id_mascota){
        mascotaService.deleteMascota(id_mascota);
        return "La mascota fue borrado correctamente";

    }

    @PutMapping("/mascotas/editar")
    public ResponseEntity<?> editMascota(@RequestBody Mascota mascota, @PathVariable Long id_mascota){
        Optional<Mascota> mascotaOptional = mascotaService.editMascota(id_mascota, mascota);
        if(mascotaOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.CREATED).body(mascotaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/mascotas/traer-caniches")
    public List<Mascota> traerCaniches(){
        return mascotaService.getCaniches();
    }

    @GetMapping("/mascotas/traer-duenios")
    public List<MascotaDuenioDTO> traerMascotaDuenios(){
        return mascotaService.getMascoDuenios();
    }
}
