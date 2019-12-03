package com.example.restaurantapp.weeklyinfo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WeeklyInfoRepository extends CrudRepository<WeeklyInfo, Long>{
	
	static Optional <WeeklyInfo> findBbyId(@Param ("idWeeklyInfo") long idWeeklyInfo)	{
		return null;
	}

}
