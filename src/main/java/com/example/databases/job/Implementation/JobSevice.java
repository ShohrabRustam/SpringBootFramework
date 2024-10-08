package com.example.databases.job.Implementation;

import com.example.databases.job.Job;
import com.example.databases.job.JobRepository;
import com.example.databases.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSevice implements JobService {
//    private final List<Job>  jobs= new ArrayList<>();
    JobRepository jobRepository;
//    private Long nextId = 1L;

    public JobSevice(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
//        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
//        job.setId(nextId++);
//        jobs.add(job);
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
//        for(Job job:jobs){
//            if (job.getId().equals(id))
//                return job;
//        }
//        return null;
    }
    public boolean deleteJobById(Long id){
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){

        }
        return false;
//        Iterator<Job> iterator = jobs.iterator();
//        boolean isDeleted = false;
//        while (iterator.hasNext()){
//            Job job = iterator.next();
//            if (job.getId().equals(id)){
//                iterator.remove();
//                isDeleted =  true;
//            }
//        }
//        return isDeleted;
    }

   public boolean updateJobById(Long id,Job updatedJob){
       Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
//        boolean isUpdated = false;
//        for(Job job: jobs){
//            if(job.getId().equals(id)){
//                isUpdated = true;
//                job.setTitle(updatedJob.getTitle());
//                job.setDecription(updatedJob.getDecription());
//                job.setMinSalary(updatedJob.getMinSalary());
//                job.setMaxSalary(updatedJob.getMaxSalary());
//                job.setLocation(updatedJob.getLocation());
//            }
//        }
//        return isUpdated;
    }


}
