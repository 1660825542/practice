package com.rock.service.serviceimpl;

import com.rock.dao.IEmployeeDao;
import com.rock.dao.daoimpl.IEmployeeDaoImpl;
import com.rock.entities.Employee;
import com.rock.service.IEmployeeService;

import java.util.List;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-22 09:37:19
 */
public class IEmployeeServiceImpl implements IEmployeeService {
    IEmployeeDao iEmployeeDao=null;
    public IEmployeeServiceImpl(){
        iEmployeeDao=new IEmployeeDaoImpl();
    }
    public List<Employee> allEmployees(){
        return iEmployeeDao.allEmps();
    }

    @Override
    public void deleteById(String empno) {
        iEmployeeDao.deleteById(empno);
    }

    @Override
    public Employee queryById(String empno) {
        return iEmployeeDao.queryById(empno);
    }

    @Override
    public int doUpdate(Employee emp) {
        return iEmployeeDao.doUpdate(emp);
    }

    @Override
    public List<Employee> queryAllManagers() {
        return iEmployeeDao.queryAllManagers();
    }
}