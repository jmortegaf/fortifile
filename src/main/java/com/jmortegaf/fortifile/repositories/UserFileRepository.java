package com.jmortegaf.fortifile.repositories;

import com.jmortegaf.fortifile.models.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFileRepository extends JpaRepository<UserFile,Long> {
}
