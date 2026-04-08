package structural_patterns.proxydesign;

public interface EmployeeDao {
  void getEmployeeInfo(int empId);

  void createEmployee(EmployeeDo employee);
}
