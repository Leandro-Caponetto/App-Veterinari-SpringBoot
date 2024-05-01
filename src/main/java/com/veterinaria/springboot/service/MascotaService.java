package com.veterinaria.springboot.service;

import com.veterinaria.springboot.dto.MascotaDuenioDTO;
import com.veterinaria.springboot.model.Mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaService {

    public List<Mascota> getMascotas();

    public Mascota saveMascota(Mascota mascota);

    public void deleteMascota(Long id_mascota);

    public Optional<Mascota> findMascota(Long id_mascota);

    public Optional<Mascota> editMascota(Long id_mascota, Mascota mascota);

    public List<Mascota> getCaniches();

    public List<MascotaDuenioDTO> getMascoDuenios();


}
