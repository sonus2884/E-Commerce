package com.teamG.TeamG.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teamG.TeamG.dto.OrderResponse;
import com.teamG.TeamG.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	  @Query(value =
			  "SELECT e FROM User e WHERE e.date BETWEEN ?1 AND ?2 order "
                      + "by e.date")
	  public List<User> findUserReport(Date Start_date,Date End_date);

	@Query(value =
			"SELECT e FROM User e WHERE e.date BETWEEN ?1 AND ?2 order "
					+ "by e.date")
	public List<User> findUserReportMonthly(Date Start_date,Date End_date);
	  
	  
	
	
}

