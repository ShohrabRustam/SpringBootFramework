package com.example.databases.Company;

import com.example.databases.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Company>> getAllCompanies(){
       return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.findCompanyById(id);
        if(company!=null)
            return new ResponseEntity<>(company, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.crateCompany(company);
        return ResponseEntity.ok("Job Added Successfuly");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id , @RequestBody Company company){
        boolean isUpdated = companyService.updateCompany(id,company);
        if(isUpdated)
            return new ResponseEntity<>("Job/Jobs Has been updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
    }


}
