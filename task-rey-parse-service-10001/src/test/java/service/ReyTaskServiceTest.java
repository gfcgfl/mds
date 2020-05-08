//package service;
//
//import com.zju.nir.common.entity.ReturnResult;
//import com.zju.nir.common.entity.ReyTask;
//import com.zju.nir.common.entity.TaskDataDTO;
//import com.zju.nir.common.utils.FileUtils;
//import com.zju.nir.rey.ReyTaskParseServiceMain;
//import com.zju.nir.rey.service.ReyTaskService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @author xiaoguo
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {ReyTaskParseServiceMain.class})
//public class ReyTaskServiceTest {
//
//    @Autowired
//    private ReyTaskService reyTaskService;
//
//    @Test
//    public void testAddReyTask() throws InterruptedException {
//
//        File file = new File("D:\\pro\\JAVA\\Prjs\\mental-disease-system\\" +
//                "task-rey-parse-service-10001\\src\\test\\resources\\generatorConfig.xml");
//        byte[] bytes = FileUtils.toBytes(file);
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        TaskDataDTO taskDataDTO = new TaskDataDTO();
//        taskDataDTO.setFileString("bytes").setCollectId(10).setPatientId(1).setTaskId(1).
//                setStartTime(dateFormat.format(new Date()));
//        Thread.sleep(1000);
//        taskDataDTO.setEndTime(dateFormat.format(new Date()));
//
//        ReyTask reyTask = new ReyTask().setReyDdScore(1).setReyDiScore(3).setReySiScore(3).setReySdScore(33);
//        taskDataDTO.setData(reyTask);
//
//        ReturnResult<Object> ret = reyTaskService.addReyTask(taskDataDTO);
//
//        System.out.println(ret);
//    }
//}
