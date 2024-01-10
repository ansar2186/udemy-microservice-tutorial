package com.javaguides.organizationservice.service;

import com.javaguides.organizationservice.dto.OrganizationDto;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface OrganizationService {

    public OrganizationDto addOrganizationDto(OrganizationDto organizationDto);

    public OrganizationDto getOrganizationByCode(String orgCode);

    public List<OrganizationDto> getAllOrganization();

    public OrganizationDto updateOrganization(String OrgCode, OrganizationDto organizationDto);

}
