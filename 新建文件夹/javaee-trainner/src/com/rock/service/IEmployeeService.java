package com.rock.service;

import com.rock.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> allEmployees();

    /**
     * 删除员工信息根据员工编号
     * @param empno
     */
    void deleteById(String empno);

    /**
     * 根据员工编号获取员工的详细信息
     * @param empno
     * @return
     */
    Employee queryById(String empno);

    /**
     * 完成员工信息的更新
     * @param emp
     * @return
     */
    int doUpdate(Employee emp);

    List<Employee> queryAllManagers();
}
