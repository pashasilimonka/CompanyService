package edu.sylymonka;/*
  @author   silim
  @project   CompanyService
  @class  Company
  @version  1.0.0 
  @since 22.02.2024 - 23.17
*/

public class Company {
    private Company parent;
    private int countOfWorkers;

    public Company(Company parent,int countOfWorkers){
        this.parent=parent;
        this.countOfWorkers=countOfWorkers;
    }

    public Company getParent() {
        return parent;
    }


    public int getCountOfWorkers() {
        return countOfWorkers;
    }

}
