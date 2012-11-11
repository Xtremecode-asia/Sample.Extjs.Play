package actors.messages.reporting;

/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/11/12
 * Time: 2:22 PM
 */
public class GetReportDataResponse {
    private boolean success;
    private byte[] reportData;
    private String errorResponse;

    public GetReportDataResponse(boolean success, byte[] reportData, String errorResponse){
        this.success = success;
        this.reportData = reportData;
        this.errorResponse = errorResponse;
    }

    public boolean getSuccess() {
        return success;
    }

    public byte[] getReportData() {
        return reportData;
    }

    public String getErrorResponse() {
        return errorResponse;
    }
}
