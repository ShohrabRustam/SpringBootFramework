package com.example.databases.job.Implementation;

import com.example.databases.job.Job;
import com.example.databases.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public Job findJobById(Long id) {
        for(Job job:jobs){
            if (job.getId().equals(id))
                return job;
        }
        return null;
    }
    public boolean deleteJobById(Long id){
        Iterator<Job> iterator = jobs.iterator();
        boolean isDeleted = false;
        while (iterator.hasNext()){
            Job job = iterator.next();
            if (job.getId().equals(id)){
                iterator.remove();
                isDeleted =  true;
            }
        }
        return isDeleted;
    }

   public boolean updateJobById(Long id,Job updatedJob){
        boolean isUpdated = false;
        for(Job job: jobs){
            if(job.getId().equals(id)){
                isUpdated = true;
                job.setTitle(updatedJob.getTitle());
                job.setDecription(updatedJob.getDecription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
            }
        }
        return isUpdated;
    }


}
