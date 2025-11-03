package com.souvik.nestleapapplication.Controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.souvik.nestleapapplication.entity.PropertyDetails;
import java.nio.file.Files;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @GetMapping
    public List<PropertyDetails> getAllProperties() {
        try {
            var resource = new ClassPathResource("static/data.json");
            var jsonData = Files.readAllBytes(resource.getFile().toPath());

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonData, new TypeReference<List<PropertyDetails>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @GetMapping("/{id}")
    public PropertyDetails getPropertyById(@PathVariable Long id) {
        try {
            var resource = new ClassPathResource("static/data.json");
            var jsonData = Files.readAllBytes(resource.getFile().toPath());
            ObjectMapper mapper = new ObjectMapper();

            List<PropertyDetails> properties =
                    mapper.readValue(jsonData, new TypeReference<List<PropertyDetails>>() {});

            return properties.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
