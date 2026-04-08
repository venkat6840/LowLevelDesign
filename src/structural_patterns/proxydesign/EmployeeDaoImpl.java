package structural_patterns.proxydesign;

public class EmployeeDaoImpl implements EmployeeDao {
  @Override
  public void getEmployeeInfo(int empId) {
    System.out.println("Getting employee details " + empId);
  }

  @Override
  public void createEmployee(EmployeeDo employee) {
    System.out.println("Creating employee " + employee);
  }
}
