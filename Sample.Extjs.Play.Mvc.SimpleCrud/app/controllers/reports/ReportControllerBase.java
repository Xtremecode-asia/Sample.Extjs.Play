package controllers.reports;

import actors.ReportingService;
import actors.messages.reporting.GetReportDataRequest;
import actors.messages.reporting.GetReportDataResponse;
import akka.dispatch.Mapper;
import java.util.Map;
import play.db.DB;
import play.libs.Akka;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/11/12
 * Time: 8:53 PM
 */
public abstract class ReportControllerBase extends Controller {
    protected static String PDF_FORMAT = "application/pdf";

    protected static Result asyncReport(String reportName, final String reportFormat, Map<String, Object> params){
        GetReportDataRequest request = new GetReportDataRequest( reportName, DB.getConnection(), params, reportFormat);
        return async(Akka.asPromise(
                ReportingService.getReportData(request).map(
                        new Mapper<Object, Result>() {
                            @Override
                            public Result apply(Object rawResponse) {
                                GetReportDataResponse response = (GetReportDataResponse) rawResponse;
                                return response.getSuccess() ? ok(response.getReportData()).as(reportFormat)
                                        : badRequest(response.getErrorResponse());
                            }
                        }
                )
            )
        );
    }
}
