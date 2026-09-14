package com.smarthouse.house.controller;

import com.smarthouse.house.entity.RentalRequest;
import com.smarthouse.house.repository.RentalRequestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental-requests")
public class RentalRequestController {

    private RentalRequestRepository rentalRequestRepository;

    public RentalRequestController(RentalRequestRepository rentalRequestRepository) {
        this.rentalRequestRepository = rentalRequestRepository;
    }

    // CREATE
    @PostMapping
    public RentalRequest createRequest(@RequestBody RentalRequest request) {
        return rentalRequestRepository.save(request);
    }

    // READ - All requests
    @GetMapping
    public List<RentalRequest> getAllRequests() {
        return rentalRequestRepository.findAll();
    }

    // READ - Request by ID
    @GetMapping("/{id}")
    public RentalRequest getRequestById(@PathVariable Long id) {
        return rentalRequestRepository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public RentalRequest updateRequest(@PathVariable Long id,
                                       @RequestBody RentalRequest request) {

        RentalRequest existingRequest =
                rentalRequestRepository.findById(id).orElse(null);

        if (existingRequest != null) {
            existingRequest.setMessage(request.getMessage());
            existingRequest.setStatus(request.getStatus());
            existingRequest.setRequestDate(request.getRequestDate());
            existingRequest.setStudent(request.getStudent());
            existingRequest.setProperty(request.getProperty());

            return rentalRequestRepository.save(existingRequest);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id) {

        rentalRequestRepository.deleteById(id);

        return "Rental request deleted successfully";
    }
}