package com.souvik.nestleapapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.souvik.nestleapapplication.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
