package service;

import com.zju.nir.report.ReportManageServiceMain;
import com.zju.nir.report.entity.ReportMessage;
import com.zju.nir.report.entity.ReportMetaData;
import com.zju.nir.report.service.ReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author xiaoguo
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ReportManageServiceMain.class})
public class ReportServiceTest {


    @Autowired
    private ReportService reportService;

    @Test
    public void testCreateReport() {
        ReportMetaData reportMetaData = new ReportMetaData();
        reportMetaData.setCollectId(12);
        reportMetaData.setPatientId(2);
        reportMetaData.setDoctorId(1122);
        reportMetaData.setStartTime(new Date());
        reportMetaData.setEndTime(new Date());

        ReportMessage report = reportService.createReport(reportMetaData);
        System.out.println(report);
    }


}
