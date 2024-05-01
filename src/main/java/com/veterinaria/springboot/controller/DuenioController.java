package com.veterinaria.springboot.controller;

import com.veterinaria.springboot.model.Duenio;

import com.veterinaria.springboot.service.DuenioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DuenioController {

    private final DuenioService duenioService;

    @GetMapping("/duenio/traer")
    public List<Duenio> getPersonas(){
        return duenioService.getDuenios();
    }

    @PostMapping("/duenio/crear")
    public String savePersona(@RequestBody Duenio duenio){
        duenioService.seveDuenio(duenio);
        return "La persona fue creada correctamente";
    }

    @PutMapping("/duenio/editar")
    public Duenio editPersona(@RequestBody Duenio duenio){
        duenioService.editDuenio(duenio);
        return duenioService.findDuenio(duenio.getId_duenio());
    }
}
