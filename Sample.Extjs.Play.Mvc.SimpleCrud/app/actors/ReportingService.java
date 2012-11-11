package actors;

import actors.messages.reporting.GetReportDataRequest;
import actors.messages.reporting.GetReportDataResponse;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.Future;
import java.io.File;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JRException;

import static akka.pattern.Patterns.*;
/**
 * Created by Wendy Sanarwanto (saintc0d3r@gmail.com) @2012
 * Date: 11/11/12
 * Time: 11:33 AM
 */
public class ReportingService extends UntypedActorBase{
    protected static final String PDF_FORMAT = "application/pdf";
    public static final String ACTOR_NAME = "ReportingService";
    private static ActorRef s_instance;

    public static void initialiseActorRef(ActorSystem actorSystem){
        s_instance = actorSystem.actorOf(new Props(ReportingService.class), ACTOR_NAME );
    }

    @Override
    public void onReceive(Object message) {
        if (message instanceof GetReportDataRequest){
            buildReportData((GetReportDataRequest) message);
        }
    }

    //<editor-fold desc="-- Helpers --">
    public static Future<Object> getReportData(GetReportDataRequest request) {
        return ask(s_instance, request, askTimeOut );
    }

    private void buildReportData(GetReportDataRequest request){
        boolean success = false;
        byte[] reportData = null;
        String errorResponse = null;
        try{
            // Does the compiled report file exist ?
            if ( !compiledReportFileExist(request.getJasperPath()) ){
                compileReportXmlFile(request.getJrxmlPath(), request.getJasperPath());
            }
            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(request.getJasperPath(), request.getParameters(), request.getReportDbConnection());

            reportData = exportReport(jasperPrint, request.getReportFormat());
            success= true;
        }
        catch(Exception exception){
            exception.printStackTrace();
            reportData = new byte[0];
            errorResponse = String.format(getStringById("Error.Service.Reporting.UnableToRender"), request.getReportName());
        }
        getSender().tell(new GetReportDataResponse(success, reportData, errorResponse));
    }

    private boolean compiledReportFileExist(String jasperPath){
        File file = new File(jasperPath);
        return file.exists();
    }

    private void compileReportXmlFile(String jrxmlPath, String jasperPath)
        throws JRException{
        JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);
    }

    private byte[] exportReport(JasperPrint jasperPrint, String reportFormat)
        throws JRException{
        byte[] result = new byte[0];
        switch(reportFormat){
            case PDF_FORMAT:
            default: result = JasperExportManager.exportReportToPdf(jasperPrint);
        }
        return result;
    }
    //</editor-fold>
}
