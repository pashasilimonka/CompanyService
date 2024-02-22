package edu.sylymonka;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author   silim
  @project   CompanyService
  @class  CompanyServiceImplTest
  @version  1.0.0 
  @since 22.02.2024 - 23.25
*/class CompanyServiceImplTest {

    private final Company directors = new Company(null,3);
    private final Company teamLeads = new Company(directors,4);
    private final Company frontEndDevs = new Company(teamLeads,5);
    //private final Company uiUx = new Company(frontEndDevs,2);
    private final Company pageDevs = new Company(frontEndDevs,3);
    private final Company backEndDevs = new Company(teamLeads,6);
    private final Company codeWriters = new Company(backEndDevs,3);
    private final Company devOps = new Company(backEndDevs,2);
    private final Company dataScientists = new Company(teamLeads,2);

    private final List<Company> companies = new ArrayList<>(Arrays.asList(directors,teamLeads,frontEndDevs,
            pageDevs,backEndDevs,
            codeWriters,dataScientists,devOps));
    private final ICompanyService service = new CompanyServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void whenCompanyIsNullThenNull(){
        assertNull(service.getTopLevelParent(null));
    }
    @Test
    public void whenCompanyIsTopLevelThenReturnIt(){
        Company result = service.getTopLevelParent(directors);
        assertEquals(directors,result);
    }
    @Test
    public void whenCompanyIsChildThenReturnTopParent(){
        Company result = service.getTopLevelParent(teamLeads);
        assertEquals(directors,result);
    }
    @Test
    public void whenParentCompanyIsTwoStepsToParentThenReturnParent(){
        Company result = service.getTopLevelParent(frontEndDevs);
        assertEquals(directors,result);
    }@Test
    public void whenParentCompanyIsThreeStepsToParentThenReturnParent(){
        Company result = service.getTopLevelParent(codeWriters);
        assertEquals(directors,result);
    }
    @Test
    public void whenCompanyIsNullThenReturn0Workers(){
        long result = service.getEmployeeCountForCompanyAndChildren(null,null);
        assertEquals(0,result);
    }
    @Test
    public void whenCompanyHasNoChildrenThenReturnOnlyHerEmployees(){
        long result = service.getEmployeeCountForCompanyAndChildren(devOps,companies);
        assertEquals(devOps.getCountOfWorkers(),result);
    }@Test
    public void whenCompanyHasOneChildThenReturnHerAndChildEmployee(){
        long result = service.getEmployeeCountForCompanyAndChildren(frontEndDevs,companies);
        assertEquals(8,result);
    }@Test
    public void whenCompanyHasMoreChildrenThenReturnHerAndChildrenEmployee(){
        long result = service.getEmployeeCountForCompanyAndChildren(backEndDevs,companies);
        assertEquals(11,result);
    }@Test
    public void whenCompanyIsTopParentThenReturnAllEmployers(){
        long result = service.getEmployeeCountForCompanyAndChildren(directors,companies);
        assertEquals(28,result);
    }




}