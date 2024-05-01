package com.veterinaria.springboot.service.implementation;

import com.veterinaria.springboot.dto.MascotaDuenioDTO;
import com.veterinaria.springboot.model.Mascota;
import com.veterinaria.springboot.repository.MascotaRepository;
import com.veterinaria.springboot.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascotaRepository.findAll();
        return listaMascotas;
    }

    @Override
    public Mascota saveMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascotaRepository.deleteById(id_mascota);
    }

    @Override
    public Optional<Mascota> findMascota(Long id_mascota) {
        return mascotaRepository.findById(id_mascota);
    }

    @Override
    public Optional<Mascota> editMascota(Long id_mascota, Mascota mascota) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id_mascota);
        if(mascotaOptional.isPresent()){
            Mascota mascotaDb = mascotaOptional.orElseThrow();

            mascotaDb.setNombre(mascota.getNombre());
            mascotaDb.setRaza(mascota.getRaza());
            mascotaDb.setEspecie(mascota.getEspecie());
            mascotaDb.setColor(mascota.getColor());
            mascotaDb.setDuenio(mascota.getDuenio());
        }
        return mascotaOptional;
    }

    @Override
    public List<Mascota> getCaniches() {
        List<Mascota> listMascotas = this.getMascotas();
        List<Mascota> listaCaniches = new ArrayList<Mascota>();

        for (Mascota mascota:listMascotas){
            if (mascota.getEspecie().equalsIgnoreCase("perro") && mascota.getRaza().equalsIgnoreCase("caniche")){
                listaCaniches.add(mascota);
            }
        }

        return listaCaniches;
    }

    @Override
    public List<MascotaDuenioDTO> getMascoDuenios() {
        List<Mascota> listaMascotas = this.getMascotas();
        List<MascotaDuenioDTO> listaMascoDuenio = new ArrayList<MascotaDuenioDTO>();
        MascotaDuenioDTO masco_duenio = new MascotaDuenioDTO();

        for (Mascota masco : listaMascotas) {

            System.out.println(masco.getNombre());
            masco_duenio.setNombre_duenio(masco.getDuenio().getNombre());
            masco_duenio.setNombre_mascota(masco.getNombre());
            masco_duenio.setApellido_duenio(masco.getDuenio().getApellido());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());

            listaMascoDuenio.add(masco_duenio);
            masco_duenio = new MascotaDuenioDTO();
        }
        return listaMascoDuenio;
    }
}
