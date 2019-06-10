package com.rock.dao.daoimpl;

import com.rock.dao.IEmployeeDao;
import com.rock.entities.Employee;
import com.rock.util.JDBCUtil;

import java.util.List;

/**
 * @author :老张
 * @version :1.0
 * @Description :
 * @Date :2019-03-22 09:38:18
 */
public class IEmployeeDaoImpl implements IEmployeeDao {
    private  JDBCUtil util=null;

    public IEmployeeDaoImpl() {
        util=new JDBCUtil();
    }

    @Override
    public List<Employee> allEmps() {
        String sql="select a.*,b.dname from emp a left join dept b on a.deptno=b.deptno ";
        List<Employee> all=util.queryAll(Employee.class,sql);
        return all;
    }

    @Override
    public void deleteById(String empno) {
        String sql="delete from emp where empno=?";
        util.runSql(sql,empno);
    }

    @Override
    public Employee queryById(String empno) {
        String sql="select * from emp where empno=?";
        return util.queryById(Employee.class,sql,empno);
    }

    @Override
    public int doUpdate(Employee emp) {
        String sql="update emp set ename=?,sal=?,comm=?,mgr=? where empno=?";
        System.out.println(emp.getMgr());
        return util.runSql(sql,emp.getEname(),emp.getSal(),emp.getComm(),emp.getMgr(),emp.getEmpno());
    }

    @Override
    public List<Employee> queryAllManagers() {
        String sql="select distinct a.ename,b.mgr from emp a ,emp b where a.empno =b.mgr";

        return util.queryAll(Employee.class,sql);
    }
}
