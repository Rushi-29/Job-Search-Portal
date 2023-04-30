package com.geekster.JobSearchPortal.service;

import com.geekster.JobSearchPortal.model.Job;
import com.geekster.JobSearchPortal.model.JobType;
import com.geekster.JobSearchPortal.repository.IJobDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    IJobDao jobDao;
    public String addJob(List<Job> joblist) {
       Iterable<Job> list = jobDao.saveAll(joblist);
       if(list!=null){
           return "jobs added successfully...!!!";
       }else{
           return "could not added...!!!";
       }
    }

    public Optional<Job> getJobById(Long jobId) {
        return jobDao.findById(jobId);
    }

    public List<Job> getAll() {
        return (List<Job>) jobDao.findAll();
    }
    public List<Job> getStocksByType(JobType jobType) {

        return jobDao.findByJobType(jobType);
    }

    public List<Job> getJobsBasedOnSalary(Double salary) {
        return jobDao.findBySalaryGreaterThan(salary);
    }

    public void deleteJobById(Long jobId) {
         jobDao.deleteById(jobId);
    }

    public List<Job> getJobsByTitle(String jobTitle) {
        return jobDao.findByTitle(jobTitle);
    }

    public List<Job> getJobsByCompany(String companyName) {
        return jobDao.findByCompanyName(companyName);
    }

    public List<Job> getAllJobSorted() {
        return jobDao.GetAllJobsBySalary();
    }

    public List<Job>searchBy(String Title){
        return jobDao.searchByTitle(Title);
    }
    @Transactional
    public void updateSalary(Long id, Double salary) {
        jobDao.putSalary(id,salary);
    }

    @Transactional
    public void deleteLowSalary(Double salary) {
        jobDao.deleteBasedOnSalary(salary);
    }
}
