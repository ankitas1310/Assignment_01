package com.afkl.travel.exercise.repository;

import com.afkl.travel.exercise.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    Location findAllByTypeAndCode(String Type, String code);

}