
package jdbcexample2;
import java.util.List;

public class JDBCExample2 {

    
  public static void main(String[] args) {
     

        EmployeeDAO.addEmployee("Alwis", "Software Engineer ", 75000);
        EmployeeDAO.addEmployee("Bob Marley", "Manager", 80000);
       
        EmployeeDAO.updateEmployee(1, "John Doe","Senior Software Engineer",
        90000);
        
        List<EmployeeDAO> employees = EmployeeDAO.getAllEmployees();
        employees.forEach(System.out::println);
        
        EmployeeDAO.deleteEmployee(2);
    
    
}
}