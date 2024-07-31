package com.example.databases.job.Implementation;

import com.example.databases.job.Job;
import com.example.databases.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSevice implements JobService {
    private final List<Job>  jobs= new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }
}
