package repositories;

import models.Employee;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 1:15 PM
 */
public class EmployeeRepository extends RepositoryBase<Employee, Long> {
    @Override
    public Class<Employee> getModelClass() {
        return Employee.class;
    }
}
