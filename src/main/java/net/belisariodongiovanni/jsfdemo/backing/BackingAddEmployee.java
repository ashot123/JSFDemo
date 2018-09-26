package net.belisariodongiovanni.jsfdemo.backing;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

//import net.belisariodongiovanni.jsfdemo.bo.CompaniesBO;
import net.belisariodongiovanni.jsfdemo.bo.CompaniesBO;
import net.belisariodongiovanni.jsfdemo.bo.EmployeesBO;
import net.belisariodongiovanni.jsfdemo.model.Company;
import net.belisariodongiovanni.jsfdemo.model.Employee;

@ManagedBean(name = "backingAddEmployee")
@ViewScoped
public class BackingAddEmployee {
    private Employee employee = new Employee();
    private EmployeesBO employeesBO = new EmployeesBO();
    private List<Company> companiesList = new ArrayList<>();
    private CompaniesBO companiesBO = new CompaniesBO();



    public List<Company> getCompaniesList() {
        return companiesList;
    }

    public void setCompaniesList(List<Company> companiesList) {
        this.companiesList = companiesList;
    }

    //private CompaniesBO companiesBO = new CompaniesBO();


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



    /*public List<Company> getCompaniesList() {
        return companiesList;
    }

    public void setCompaniesList(List<Company> companiesList) {
        this.companiesList = companiesList;
    }*/





    public String saveEmployee() {
        // Saving employee ...
        employeesBO.insertEmployee(employee);
        return "employees";
    }

    public void init() {
        this.companiesList = companiesBO.findAllCompanies();

        // Add empty string as first company name (default)
        Company company = new Company();
        company.setName("");
        companiesList.add(0, company);
        System.out.println("init() called");
    }


}
