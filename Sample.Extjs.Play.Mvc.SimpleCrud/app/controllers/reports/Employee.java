package controllers.reports;

import play.mvc.Result;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/11/12
 * Time: 11:28 AM
 */
public class Employee extends ReportControllerBase {
    public static Result GetEmployeesReport(){
        return asyncReport("EmployeesReport", PDF_FORMAT, null);
    }
}
