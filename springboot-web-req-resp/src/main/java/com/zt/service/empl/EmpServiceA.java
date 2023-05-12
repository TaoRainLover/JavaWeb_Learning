package com.zt.service.empl;

import com.zt.dao.EmpDao;
import com.zt.dao.impl.EmpDaoA;
import com.zt.pojo.Emp;
import com.zt.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component //  将当前类交给IOC容器管理，成为IOC容器中的Bean
@Service
public class EmpServiceA implements EmpService {
    @Autowired // 运行时，IOC容器会提供该类型的bean对象，并赋值给该变量 - 依赖注入
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        // 1. 调用 Dao, 获取数据
        List<Emp> empList = empDao.listEmp();
        // 2. 对数据进行转换处理
        empList.stream().forEach(emp->{
            String gender = emp.getGender();
            if("1".equals(gender)) {
                emp.setGender("男");
            }else if("2".equals(gender)) {
                emp.setGender("女");
            }
            String job = emp.getJob();
            if("1".equals(job)) {
                emp.setJob("讲师");
            }else if("2".equals(job)) {
                emp.setJob("班主任");
            }else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
