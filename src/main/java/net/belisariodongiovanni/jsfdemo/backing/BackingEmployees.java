package net.belisariodongiovanni.jsfdemo.backing;

import net.belisariodongiovanni.jsfdemo.bo.EmployeesBO;
import net.belisariodongiovanni.jsfdemo.model.Employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "backingEmployees")
@SessionScoped
public class BackingEmployees {
    EmployeesBO employeesBO = new EmployeesBO();

    public List<Employee> findAllEmployees() {
        return employeesBO.findAllEmployees();
    }

    public void delete(Employee employee) {
        employeesBO.deleteEmployee(employee);
    }
}
