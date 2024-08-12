package com.example.databases.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company findCompanyById(Long id);
    void crateCompany(Company company);
    boolean updateCompany(Long id, Company company);
    boolean deleteCompanyById(Long id);

}
