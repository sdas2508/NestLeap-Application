package com.souvik.nestleapapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.souvik.nestleapapplication.Repository.OwnerRepository;
import com.souvik.nestleapapplication.entity.OwnerDetails;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    // Fetch all owners (only name, email, contact)
    @GetMapping
    public List<Map<String, String>> getAllOwners() {
        return ownerRepository.findAll().stream()
                .map(owner -> Map.of(
                        "ownerName", owner.getOwnerName(),
                        "mobileNumber", owner.getMobileNumber(),
                        "email", owner.getEmail()
                ))
                .collect(Collectors.toList());
    }

    // Fetch owner by ID (only name, email, contact)
    @GetMapping("/{id}")
    public Map<String, String> getOwnerById(@PathVariable Long id) {
        Optional<OwnerDetails> ownerOpt = ownerRepository.findById(id);
        if (ownerOpt.isPresent()) {
            OwnerDetails owner = ownerOpt.get();
            return Map.of(
                    "ownerName", owner.getOwnerName(),
                    "mobileNumber", owner.getMobileNumber(),
                    "email", owner.getEmail()
            );
        }
        return Map.of("error", "Owner not found");
    }
}
