package com.iwamih31;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {

	/**	Action取得（日付指定） */
	@Query("select action"
			+ " from Action action"
			+ " where action.date >= :start_date"
			+ " and action.date <= :end_date"
			+ " order by action.subject asc")
	public List<Action> action_List(
			@Param("start_date") LocalDate start_date,
			@Param("end_date") LocalDate end_date
			);

	/**	subjects取得（日付降順） */
	@Query("select distinct action"
			+ " from Action action"
			+ " order by action.date desc")
	public List<Action> subjects();

	/**	Action取得（指定日まで） */
	@Query("select distinct action"
			+ " from Action action"
			+ " where action.date <= :date"
			+ " order by action.date desc")
	public List<Action> up_to_date(
			@Param("date") LocalDate localDate
			);

}