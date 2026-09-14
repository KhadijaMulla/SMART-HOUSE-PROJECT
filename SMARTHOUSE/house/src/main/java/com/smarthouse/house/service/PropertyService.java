package com.smarthouse.house.service;

import com.smarthouse.house.dto.PropertyResponseDTO;
import com.smarthouse.house.entity.Property;
import com.smarthouse.house.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<PropertyResponseDTO> getAllProperties() {

        List<Property> properties = propertyRepository.findAll();

        List<PropertyResponseDTO> propertyResponseDTOs = new ArrayList<>();

        for (Property property : properties) {

            PropertyResponseDTO dto = new PropertyResponseDTO();

            dto.setId(property.getId());
            dto.setTitle(property.getTitle());
            dto.setDescription(property.getDescription());
            dto.setLocation(property.getLocation());
            dto.setRent(property.getRent());
            dto.setRoomType(property.getRoomType());
            dto.setAvailable(property.isAvailable());

            if (property.getOwner() != null) {
                dto.setOwnerId(property.getOwner().getId());
                dto.setOwnerName(property.getOwner().getName());
            }

            propertyResponseDTOs.add(dto);
        }

        return propertyResponseDTOs;
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public Property updateProperty(Long id, Property property) {

        Property existingProperty =
                propertyRepository.findById(id).orElse(null);

        if (existingProperty != null) {

            existingProperty.setTitle(property.getTitle());
            existingProperty.setDescription(property.getDescription());
            existingProperty.setLocation(property.getLocation());
            existingProperty.setRent(property.getRent());
            existingProperty.setRoomType(property.getRoomType());
            existingProperty.setAvailable(property.isAvailable());
            existingProperty.setOwner(property.getOwner());

            return propertyRepository.save(existingProperty);
        }

        return null;
    }

    public String deleteProperty(Long id) {

        propertyRepository.deleteById(id);

        return "Property deleted successfully";
    }
}