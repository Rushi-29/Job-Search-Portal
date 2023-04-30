package com.geekster.JobSearchPortal.controller;

import com.geekster.JobSearchPortal.model.Job;
import com.geekster.JobSearchPortal.model.JobType;
import com.geekster.JobSearchPortal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Jobs")
public class JobController {

    @Autowired
    JobService jobService;

    // inbuilt methods
    @PostMapping(value = "/job")
    public String addJobs(@Valid @RequestBody List<Job> Joblist){
        return jobService.addJob(Joblist);
    }
    @GetMapping(value = "/getAllJobs")
    public List<Job> getAllJobs(){
        return jobService.getAll();
    }

    @GetMapping(value = "/getJobById/{JobId}")
    public Optional<Job> getJobById(@PathVariable Long JobId){
        return jobService.getJobById(JobId);
    }
    @DeleteMapping(value = "/deleteJobById/{JobId}")
    public void  deleteJobById(@PathVariable Long JobId){
         jobService.deleteJobById(JobId);
    }

    // custom finder
    @GetMapping(value = "/type/{jobType}")
    public List<Job> getJobBasedOnType(@PathVariable JobType jobType)
    {
        return jobService.getStocksByType(jobType);
    }
    @GetMapping(value = "/salary/{salary}")
    public List<Job> getJobsBasedOnSalary(@PathVariable Double salary)
    {
        return jobService.getJobsBasedOnSalary(salary);
    }
    @GetMapping(value = "/title/{jobTitle}")
    public List<Job>  getJobsByTitle(@PathVariable String jobTitle){
        return jobService.getJobsByTitle(jobTitle);
    }
    @GetMapping(value = "/company/{companyName}")
    public List<Job>  getJobsByCompany(@PathVariable String companyName){
        return jobService.getJobsByCompany(companyName);
    }


 // Query

    @GetMapping(value = "/jobSort")
    public List<Job> getOrderedJobs()
    {
        return jobService.getAllJobSorted();
    }
    @GetMapping(value = "/searchByTitle/{title}")
    public List<Job> searchBy(@PathVariable String title){
        return jobService.searchBy(title);
    }
    @PutMapping(value = "/update/id/{id}/salary/{salary}")
    public void updateSalary(@PathVariable Long id,@PathVariable Double salary){
        jobService.updateSalary(id,salary);
    }

    @DeleteMapping(value = "/delete/salary/{salary}")
    public void deleteLowSalary(@PathVariable Double salary){
        jobService.deleteLowSalary(salary);
    }



}
