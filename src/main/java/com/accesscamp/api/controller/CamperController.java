package com.accesscamp.api.controller;

import com.accesscamp.api.dto.CamperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.accesscamp.api.service.CamperService;

import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {
    @Autowired
    private CamperService camperService;

    @PostMapping
    public CamperDTO createCamper(@RequestBody CamperDTO camper) {
        return camperService.saveCamperDTO(camper);
    }

    @GetMapping
    public List<CamperDTO> getCampers() {
        return camperService.getCampersDTO();
    }

    @GetMapping("/{id}")
    public CamperDTO getCamper(@PathVariable Long id) {
        return camperService.getCamperDTO(id);
    }

//    Would Patching be the same as Posting? The actual Repository function is called save and does both
//    @PatchMapping("/{id}")
//    public CamperDTO updateCamper(@RequestBody CamperDTO camper) {
//        return camperService.saveCamperDTO(camper);
//    }

    @DeleteMapping("/{id}")
    public void deleteCamper(@PathVariable Long id) {
        camperService.deleteCamper(id);
    }
}
