package com.example.restaurantapp.weeklyinfo;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WeeklyInfoRepository extends CrudRepository<WeeklyInfo, Long>{
	
	//returns the current week
	WeeklyInfo findFirstByOrderByDateDesc();
	
	
	Optional <WeeklyInfo> findFirstByDateGreaterThanOrderByDateAsc(Date date);
	
	Optional <WeeklyInfo> findFirstByDateLessThanOrderByDateDesc(Date date);
}




