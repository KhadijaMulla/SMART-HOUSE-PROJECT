package com.smarthouse.house.controller;

import com.smarthouse.house.dto.PropertyResponseDTO;
import com.smarthouse.house.entity.Property;
import com.smarthouse.house.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public Property createProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
    }

    @GetMapping
    public List<PropertyResponseDTO> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @PutMapping("/{id}")
    public Property updateProperty(@PathVariable Long id,
                                   @RequestBody Property property) {
        return propertyService.updateProperty(id, property);
    }

    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable Long id) {
        return propertyService.deleteProperty(id);
    }
}