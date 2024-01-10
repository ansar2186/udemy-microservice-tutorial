package com.javaguides.organizationservice.service.impl;

import com.javaguides.organizationservice.Entity.Organization;
import com.javaguides.organizationservice.dto.OrganizationDto;
import com.javaguides.organizationservice.repository.OrganizationRepository;
import com.javaguides.organizationservice.service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationImpl implements OrganizationService {
    @Autowired
  public  OrganizationRepository organizationRepository;

    ModelMapper modelMapper= new ModelMapper();
    @Override
    public OrganizationDto addOrganizationDto(OrganizationDto organizationDto) {
        Organization organization = modelMapper.map(organizationDto, Organization.class);
        Organization savedOrganization = organizationRepository.save(organization);
        return modelMapper.map(savedOrganization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String orgCode) {
        Organization organizationByCode = organizationRepository.findByOrganizationCode(orgCode);
        return modelMapper.map(organizationByCode, OrganizationDto.class);
    }

    @Override
    public List<OrganizationDto> getAllOrganization() {
        List<Organization> organizationList = organizationRepository.findAll();
        return organizationList.stream().map((org -> modelMapper.map(org, OrganizationDto.class))).toList();
    }

    @Override
    public OrganizationDto updateOrganization(String OrgCode, OrganizationDto organizationDto) {
        Organization dbOrganization = organizationRepository.findByOrganizationCode(OrgCode);
        dbOrganization.setOrganizationCode(organizationDto.getOrganizationCode());
        dbOrganization.setOrganizationName(organizationDto.getOrganizationName());
        dbOrganization.setOrganizationDescription(organizationDto.getOrganizationDescription());
        Organization savedOrganization = organizationRepository.save(dbOrganization);

        return modelMapper.map(savedOrganization,OrganizationDto.class);
    }
}
