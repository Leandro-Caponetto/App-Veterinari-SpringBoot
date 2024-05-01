package com.veterinaria.springboot.service.implementation;

import com.veterinaria.springboot.model.Duenio;
import com.veterinaria.springboot.repository.DuenioRepository;
import com.veterinaria.springboot.service.DuenioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DuenioServiceImpl implements DuenioService {

    private final DuenioRepository duenioRepository;


    @Override
    public List<Duenio> getDuenios() {
        List<Duenio> listaDuenios = duenioRepository.findAll();
        return listaDuenios;
    }

    @Override
    public void seveDuenio(Duenio duenio) {
        duenioRepository.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id) {
        duenioRepository.deleteById(id);
    }

    @Override
    public Duenio findDuenio(Long id) {
        return duenioRepository.findById(id).orElse(null);
    }

    @Override
    public void editDuenio(Duenio duenio) {
        this.seveDuenio(duenio);
    }
}
