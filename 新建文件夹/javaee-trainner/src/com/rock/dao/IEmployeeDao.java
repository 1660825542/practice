package com.rock.dao;

import com.rock.entities.Employee;

import java.util.List;

public interface IEmployeeDao {
    List<Employee> allEmps();

    /**
     * 根据员工编号删除员工信息
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
     * 完成员工的更新
     * @param emp
     * @return
     */
    int doUpdate(Employee emp);

    List<Employee> queryAllManagers();
}
