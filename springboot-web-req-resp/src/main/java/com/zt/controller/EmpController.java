package com.zt.controller;

import com.zt.pojo.Emp;
import com.zt.pojo.Result;
import com.zt.service.EmpService;
import com.zt.service.empl.EmpServiceA;
import com.zt.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired // 运行时，IOC容器会提供该类型的bean对象，并赋值给该变量 - 依赖注入
    private EmpService empService;
    // @RequestMapping("/listEmp")
    // public Result list() {
    //     System.out.println("请求员工数据");
    //     // 1. 加载解析 emp.xml 文件
    //     // String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
    //     // System.out.println(file);
    //     String file = "/Users/rainlovertao/Library/CloudStorage/OneDrive-LINGDU/JAVA学习/code/JavaWeb_HEIMA_2023/springboot-web-req-resp/src/main/resources/emp.xml";
    //     List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
    //     // 2. 对数据进行转换处理
    //     empList.stream().forEach(emp->{
    //         String gender = emp.getGender();
    //         if("1".equals(gender)) {
    //             emp.setGender("男");
    //         }else if("2".equals(gender)) {
    //             emp.setGender("女");
    //         }
    //         String job = emp.getJob();
    //         if("1".equals(job)) {
    //             emp.setJob("讲师");
    //         }else if("2".equals(job)) {
    //             emp.setJob("班主任");
    //         }else if ("3".equals(job)) {
    //             emp.setJob("就业指导");
    //         }
    //     });
    //     // 3. 响应数据
    //     return Result.success(empList);
    // }

    // 分层解耦
    @RequestMapping("/listEmp")
    public Result list() {
        System.out.println("请求员工数据");
        // 1. 调用 Service， 获取数据
        List<Emp> empList = empService.listEmp();

        // 2. 响应数据
        return Result.success(empList);
    }
}
