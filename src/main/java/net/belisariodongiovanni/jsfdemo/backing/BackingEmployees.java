package net.belisariodongiovanni.jsfdemo.backing;

import net.belisariodongiovanni.jsfdemo.bo.EmployeesBO;
import net.belisariodongiovanni.jsfdemo.model.Employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "backingEmployees")
@SessionScoped
public class BackingEmployees {



    public List<Employee> findAllEmployees() {
        EmployeesBO employeesBO = new EmployeesBO();
        return employeesBO.findAllEmployees();
    }

}
