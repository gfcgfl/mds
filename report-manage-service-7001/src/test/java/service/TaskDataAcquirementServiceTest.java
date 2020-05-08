package service;

import com.zju.nir.report.ReportManageServiceMain;
import com.zju.nir.report.entity.ReportData;
import com.zju.nir.report.entity.ReportMetaData;
import com.zju.nir.report.service.TaskDataAcquirementService;
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
public class TaskDataAcquirementServiceTest {

    @Autowired
    private TaskDataAcquirementService taskDataAcquirementService;

    @Test
    public void testGetReportNeededTaskData() {

        ReportMetaData reportMetaData = new ReportMetaData();
        reportMetaData.setCollectId(12);
        reportMetaData.setPatientId(2);
        reportMetaData.setDoctorId(1);
        reportMetaData.setStartTime(new Date());
        reportMetaData.setEndTime(new Date());

        ReportData reportNeededTaskData = taskDataAcquirementService.getReportNeededTaskData(reportMetaData);

        System.out.println(reportNeededTaskData);

    }
}
