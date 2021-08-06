package com.peregud.travelhistoryrest.repository;

import com.peregud.travelhistoryrest.domain.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static com.peregud.travelhistoryrest.util.AppConstants.ID;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {

    @Query("select j.city as city from Journey j where j.id = :id")
    String getCity(@Param(ID) Long id);
}
