package servcie;

import com.zju.nir.collect.CollectManageServiceMain;
import com.zju.nir.collect.entity.vo.TaskDataAndMarkVO;
import com.zju.nir.collect.service.DispatchTaskService;
import com.zju.nir.common.entity.LinkingTask;
import com.zju.nir.common.entity.ReturnResult;
import com.zju.nir.common.entity.ReyTask;
import com.zju.nir.common.entity.StroopTask;
import com.zju.nir.common.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Date;

/**
 * @author xiaoguo
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CollectManageServiceMain.class})
public class DispatchTaskServiceTest {

    @Autowired
    private DispatchTaskService dispatchTaskService;

    @Test
    public void testDispatch() throws InterruptedException {
        File file = new File("D:\\pro\\JAVA\\Prjs\\mental-disease-system\\" +
                "collect-manage-service-6001\\src\\test\\resources\\marked-task1-12-20200114091946740.txt");

        TaskDataAndMarkVO data = new TaskDataAndMarkVO();
        data.setTaskId(1);
        data.setPatientId(4).setCollectId(12)
                .setStartTime(DateUtils.dateToDateTime(new Date()));

        Thread.sleep(2000);

        data.setEndTime(DateUtils.dateToDateTime(new Date()));

        data.setTask1(
                new ReyTask().setPatientId(4).setReyDdScore(234).setReyDiScore(4235)
                        .setReySdScore(25).setReySiScore(333)
        );
//        data.setTask2(new LinkingTask().setAWordMis(1).setAWordTime(3).setBWordMis(22).setBWordTime(34));

//        data.setTask3(new StroopTask().setAStroopMis(1).setAStroopTime(33).setBStroopMis(2)
//                .setBStroopTime(44).setCStroopTime(4).setCStroopMis(3).setDStroopMis(545).setDStroopTime(55));
        ReturnResult<Object> ret = dispatchTaskService.dispatch(file, data);

        System.out.println(ret);

    }

}
