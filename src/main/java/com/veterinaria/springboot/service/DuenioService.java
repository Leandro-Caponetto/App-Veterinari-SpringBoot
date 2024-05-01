package com.veterinaria.springboot.service;

import com.veterinaria.springboot.model.Duenio;

import java.util.List;

public interface DuenioService {

    public List<Duenio> getDuenios();

    public void seveDuenio(Duenio duenio);

    public void deleteDuenio(Long id);

    public Duenio findDuenio(Long id);

    public void editDuenio(Duenio duenio);
}
