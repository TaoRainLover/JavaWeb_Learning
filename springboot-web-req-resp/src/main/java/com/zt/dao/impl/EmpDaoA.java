package com.zt.dao.impl;

import com.zt.dao.EmpDao;
import com.zt.pojo.Emp;
import com.zt.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 将当前类交给IOC容器管理，成为IOC容器中的Bean
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // 1. 加载解析 emp.xml 文件
        // String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        // System.out.println(file);
        String file = "/Users/rainlovertao/Library/CloudStorage/OneDrive-LINGDU/JAVA学习/code/JavaWeb_HEIMA_2023/springboot-web-req-resp/src/main/resources/emp.xml";
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
