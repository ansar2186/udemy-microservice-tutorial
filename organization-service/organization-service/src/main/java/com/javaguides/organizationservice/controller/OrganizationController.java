package com.javaguides.organizationservice.controller;

import com.javaguides.organizationservice.dto.OrganizationDto;
import com.javaguides.organizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> addOrganization(@RequestBody OrganizationDto organizationDto) {
        return new ResponseEntity<>(organizationService.addOrganizationDto(organizationDto), HttpStatus.CREATED);

    }

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code) {
        return new ResponseEntity<>(organizationService.getOrganizationByCode(code), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDto>> getAllOrganization() {
        return new ResponseEntity<>(organizationService.getAllOrganization(), HttpStatus.OK);
    }

    @PutMapping("{orgCode}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable String orgCode,@RequestBody OrganizationDto organizationDto){
        return new ResponseEntity<>(organizationService.updateOrganization(orgCode,organizationDto),HttpStatus.CREATED);
    }


}
