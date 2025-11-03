package com.souvik.nestleapapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.souvik.nestleapapplication.entity.OwnerDetails;

public interface OwnerRepository extends JpaRepository<OwnerDetails, Long> { }
