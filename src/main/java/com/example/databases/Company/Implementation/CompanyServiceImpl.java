package com.example.databases.Company.Implementation;

import com.example.databases.Company.Company;
import com.example.databases.Company.CompanyRepository;
import com.example.databases.Company.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
