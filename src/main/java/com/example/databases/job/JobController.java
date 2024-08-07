package com.example.databases.job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createjob(@RequestBody Job job){
        jobService.createJob(job);
        return ResponseEntity.ok("Job Added Successfuly");
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.findJobById(id);
        if(job!=null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteJobById(id);
        if(isDeleted)
            return new ResponseEntity<>("Job/Jobs Has been deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job) {
        boolean isUpdated = jobService.updateJobById(id,job);
        if(isUpdated)
            return new ResponseEntity<>("Job/Jobs Has been updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
    }
}
