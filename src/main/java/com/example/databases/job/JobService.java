package com.example.databases.job;

import org.jvnet.hk2.annotations.Service;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
}
