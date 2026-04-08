package structural_patterns.proxydesign;

public class EmployeeDaoDemo {
  public static void main(String[] args) {
    EmployeeDao employeeDao = new EmployeeDaoProxy("ADMIN");
    employeeDao.getEmployeeInfo(240);
    employeeDao.createEmployee(new EmployeeDo());
  }
}
