package structural_patterns.proxydesign;

public class EmployeeDaoProxy implements EmployeeDao {
  EmployeeDao employeeDao;
  String access;

  public EmployeeDaoProxy(String access) {
    this.employeeDao = new EmployeeDaoImpl();
    this.access = access;
  }

  @Override
  public void getEmployeeInfo(int empId) {
    if (access.equals("USER") || access.equals("ADMIN")) {
      employeeDao.getEmployeeInfo(empId);
    } else {
      throw new RuntimeException("Access denied");
    }
  }

  @Override
  public void createEmployee(EmployeeDo employee) {
    if (access.equals("ADMIN")) {
      employeeDao.createEmployee(employee);
    } else {
      throw new RuntimeException("Access denied");
    }
  }
}
