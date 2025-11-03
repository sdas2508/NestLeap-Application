package com.souvik.nestleapapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.souvik.nestleapapplication.Repository.UserRepository;
import com.souvik.nestleapapplication.entity.AppUser;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //  LOGIN API
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody AppUser loginData) {
        AppUser user = userRepository.findByEmail(loginData.getEmail());

        if (user == null) {
            return ResponseEntity.status(404).body("User not found! Please register first.");
        }

        if (!user.getPassword().equals(loginData.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password! Try again.");
        }

        return ResponseEntity.ok(user);
    }

    //  REGISTER API (with duplicate email check)
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AppUser user) {
        try {
            AppUser existingUser = userRepository.findByEmail(user.getEmail());
            if (existingUser != null) {
                return ResponseEntity
                        .status(400)
                        .body("Email already registered! Please log in instead.");
            }

            userRepository.save(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(500)
                    .body("Database error occurred. Please try again later.");
        } catch (Exception e) {
            return ResponseEntity
                    .status(500)
                    .body("Unexpected error: " + e.getMessage());
        }
    }

    //  UPDATE USER API (optional — to edit user info)
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody AppUser updatedUser) {
        AppUser existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return ResponseEntity.status(404).body("User not found!");
        }

        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setMobileNumber(updatedUser.getMobileNumber());
        existingUser.setPassword(updatedUser.getPassword());

        userRepository.save(existingUser);
        return ResponseEntity.ok("User details updated successfully!");
    }
}
