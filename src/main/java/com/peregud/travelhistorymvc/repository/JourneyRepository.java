package com.peregud.travelhistorymvc.repository;

import com.peregud.travelhistorymvc.domain.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static com.peregud.travelhistorymvc.AppConstants.PARAM_ID;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {

    @Query("select j.city as city from Journey j where j.id = :id")
    String getCity(@Param(PARAM_ID) Long id);
}
