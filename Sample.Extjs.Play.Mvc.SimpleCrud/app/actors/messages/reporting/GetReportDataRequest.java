package actors.messages.reporting;

import java.sql.Connection;
import java.util.Map;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/11/12
 * Time: 2:06 PM
 */
public class GetReportDataRequest {
    //<editor-fold desc="-- Constants --">
    private static String REPORT_FILES_FOLDER = "/reports";
    private static String REPORT_XML_FILE_EXTENSION = "jrxml";
    private static String REPORT_COMPILED_FILE_EXTENSION = "jasper";
    //</editor-fold>

    //<editor-fold desc="-- Fields --">
    private final String jrxmlPath;
    private final String jasperPath;
    private final String reportFormat;
    private final Connection reportDbConnection;
    private Map<String, Object> parameters;
    private String reportName;
    //</editor-fold>

    public GetReportDataRequest(String reportName, Connection reportDbConnection, Map<String,Object> parameters,
                                String reportFormat) {
        this.reportName = reportName;
        this.jrxmlPath = getReportFilePath(String.format("%s.%s", reportName, REPORT_XML_FILE_EXTENSION));
        this.jasperPath = getReportFilePath(String.format("%s.%s", reportName, REPORT_COMPILED_FILE_EXTENSION));
        this.reportDbConnection = reportDbConnection;
        this.reportFormat = reportFormat;
        this.parameters = parameters;
    }

    //<editor-fold desc="-- Getters --">
    public String getJrxmlPath() {
        return jrxmlPath;
    }

    public String getJasperPath() {
        return jasperPath;
    }

    public Connection getReportDbConnection() {
        return reportDbConnection;
    }

    public Map<String,Object> getParameters() {
        return parameters;
    }

    public String getReportName() {
        return reportName;
    }

    public String getReportFormat(){
        return reportFormat;
    }
    //</editor-fold>

    private static String getReportFilePath(String reportFileName) {
        return String.format(".%s", controllers.routes.Assets.at(REPORT_FILES_FOLDER, reportFileName).url());
    }
}
