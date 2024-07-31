package com.example.databases.job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("jobList")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createjob(@RequestBody Job job){
        jobService.createJob(job);
        return  "Job Added Successfuly";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id) {
        System.out.println(id);
       return jobService.findJobById(id);
    }
}
