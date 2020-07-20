package com.foo.servicensw.repo;

import com.foo.servicensw.model.RegInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<RegInfo, Integer> {
}
