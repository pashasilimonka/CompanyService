package edu.sylymonka;/*
  @author   silim
  @project   CompanyService
  @class  ICompanyService
  @version  1.0.0 
  @since 22.02.2024 - 23.23
*/

import java.util.List;

public interface ICompanyService {
    Company getTopLevelParent(Company company);
    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);
}
