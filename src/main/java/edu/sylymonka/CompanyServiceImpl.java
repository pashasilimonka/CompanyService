package edu.sylymonka;/*
  @author   silim
  @project   CompanyService
  @class  ICompanyServiceImpl
  @version  1.0.0 
  @since 22.02.2024 - 23.25
*/

import java.util.List;

public class CompanyServiceImpl implements ICompanyService {
    @Override
    public Company getTopLevelParent(Company company) {
        if(company!=null){
            if (company.getParent()==null){
                return company;
            }
            while(company.getParent()!=null){
                company=company.getParent();
            }
            return company;
        }
        return null;
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        if (company==null){
            return 0;
        }
        long result = company.getCountOfWorkers();
        for (Company comp: companies){

            if (comp.getParent()==null){
                continue;

            }
            if(comp.getParent()==company){
                result+=getEmployeeCountForCompanyAndChildren(comp,companies);
            }

        }
        return result;
    }
}
