package net.belisariodongiovanni.jsfdemo.backing;


import net.belisariodongiovanni.jsfdemo.bo.CompaniesBO;
import net.belisariodongiovanni.jsfdemo.bo.EmployeesBO;
import net.belisariodongiovanni.jsfdemo.model.Company;
import net.belisariodongiovanni.jsfdemo.model.Employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "backingEditEmployee", eager = true)
@SessionScoped
public class BackingEditEmployee {
    private Employee employee = new Employee();
    private EmployeesBO employeesBO = new EmployeesBO();
    private CompaniesBO companiesBO = new CompaniesBO();
    private List<Company> companiesList = new ArrayList<Company>();


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public List<Company> getCompaniesList() {
        return companiesList;
    }


    public void init() {
        this.companiesList = companiesBO.findAllCompanies();

        // Add empty string as first company name (default)
        Company company = new Company();
        company.setName("");
        companiesList.add(0, company);

    }

    public String updateEmployee() {
        employeesBO.updateEmployee(employee);
        return "employees";
    }

}
