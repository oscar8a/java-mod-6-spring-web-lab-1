package com.accesscamp.api.service;

import com.accesscamp.api.dto.CamperDTO;
import com.accesscamp.api.model.Camper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.accesscamp.api.repository.CamperRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamperService {

    @Autowired
    private CamperRepository camperRepository;

    @Autowired
    private ModelMapper mapper;

    public CamperDTO saveCamperDTO(CamperDTO camperDTO){

        // Convert camperDTO to a Camper Entity
        Camper camper = mapper.map(camperDTO, Camper.class);

        camperRepository.save(camper);

        return mapper.map(camper, CamperDTO.class);
    }

    public CamperDTO getCamperDTO(Long id){
        Camper camper =
                camperRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(camper, CamperDTO.class);
    }

    public List<CamperDTO> getCampersDTO(){
        return camperRepository.findAll()
                .stream()
                .map(camper -> mapper.map(camper, CamperDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteCamper(Long id) {
        camperRepository.deleteById(id);
    }
}
