package net.belisariodongiovanni.jsfdemo.backing;

import net.belisariodongiovanni.jsfdemo.bo.EmployeesBO;
import net.belisariodongiovanni.jsfdemo.model.Employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "backingEmployees")
@SessionScoped
public class BackingEmployees {
    EmployeesBO employeesBO = new EmployeesBO();

    @ManagedProperty(value="#{backingEditEmployee}")
    private BackingEditEmployee backingEditEmployee;


    public EmployeesBO getEmployeesBO() {
        return employeesBO;
    }

    public void setEmployeesBO(EmployeesBO employeesBO) {
        this.employeesBO = employeesBO;
    }

    public BackingEditEmployee getBackingEditEmployee() {
        return backingEditEmployee;
    }

    public void setBackingEditEmployee(BackingEditEmployee backingEditEmployee) {
        this.backingEditEmployee = backingEditEmployee;
    }

    public List<Employee> findAllEmployees() {
        return employeesBO.findAllEmployees();
    }

    public void delete(Employee employee) {
        employeesBO.deleteEmployee(employee);
    }

    public String edit(Employee employee) {
        backingEditEmployee.setEmployee(employee);
        return "update-employee";
    }
}
