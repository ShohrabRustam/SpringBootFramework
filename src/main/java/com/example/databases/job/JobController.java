package com.example.databases.job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
