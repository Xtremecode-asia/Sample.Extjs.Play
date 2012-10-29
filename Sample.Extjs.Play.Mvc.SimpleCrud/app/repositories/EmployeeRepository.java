package repositories;

import com.avaje.ebean.Ebean;
import models.Employee;

import java.util.List;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 10/28/12
 * Time: 1:15 PM
 */
public class EmployeeRepository {
    public List<Employee> FindAll(){
        return Ebean.find(Employee.class).findList();
    }

    public Employee FindById(long id){
        return Ebean.find(Employee.class).where().eq("id", id).findUnique();
    }
}
