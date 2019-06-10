package service.Impl;

import dao.IEmployeeDao;
import dao.IEmployeeDaoImpl.IEmployeeDaoimpl;
import entities.Employee;
import service.IEmployeeService;

import java.util.List;

public class IEmployeeServiceimpl implements IEmployeeService {
    private IEmployeeDao ied=null;
    public IEmployeeServiceimpl(){
        ied=new IEmployeeDaoimpl();
    }
    public List<Employee> allemps() {
        return ied.allemps();
    }
}
