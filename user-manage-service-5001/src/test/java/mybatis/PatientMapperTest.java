package mybatis;

import com.zju.nir.user.UserManageServiceMain;

import com.zju.nir.user.entity.PatientDO;
import com.zju.nir.user.mapper.PatientMapper;
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
@SpringBootTest(classes = {UserManageServiceMain.class})
public class PatientMapperTest {

    @Autowired
    private PatientMapper patientMapper;


    @Test
    public void testInsert() {
        Date date = new Date();
        PatientDO patientDO = new PatientDO().setAge(10).setCreateTime(date).setGender(0).setName("lao")
                .setUpdateTime(date).setWeight("77.4").setHeight("190.9");

        int i = patientMapper.insert(patientDO);
        System.out.println(i);

    }


}
