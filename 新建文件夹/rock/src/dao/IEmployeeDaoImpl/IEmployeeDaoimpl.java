package dao.IEmployeeDaoImpl;

import com.rock.util.JDBCUtil;
import dao.IEmployeeDao;
import entities.Employee;

import java.util.List;

public class IEmployeeDaoimpl implements IEmployeeDao {
    @Override
    public List<Employee> allemps() {
        JDBCUtil jdbc=new JDBCUtil();
        String sql="select * from emp";
        List<Employee> all=jdbc.queryAll(Employee.class,sql);
        return all;
    }
}
