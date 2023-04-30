package com.geekster.JobSearchPortal.repository;

import com.geekster.JobSearchPortal.model.Job;
import com.geekster.JobSearchPortal.model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobDao extends CrudRepository<Job,Long> {

    List<Job> findByJobType(JobType jobType);

    List<Job> findBySalaryGreaterThan(Double salary);


    List<Job> findByTitle(String jobTitle);

    List<Job> findByCompanyName(String companyName);


    @Query(value = "select * from job order by salary desc",nativeQuery = true)
    List<Job> GetAllJobsBySalary();

    @Query(value = "SELECT * FROM Job  WHERE description LIKE %:title%",nativeQuery = true)
    List<Job> searchByTitle(String title);



    @Modifying
    @Query(value = "update job set salary=:salary where id=:id",nativeQuery = true)
    void putSalary(Long id, Double salary);

    @Modifying
    @Query(value = "delete from job where SALARY<=:salary",nativeQuery = true)
    void deleteBasedOnSalary(Double salary);
}
