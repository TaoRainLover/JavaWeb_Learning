package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete() {
        int numDelete = empMapper.delete(17);
        System.out.println(numDelete);
    }

    @Test
    public void testInsert() {
        // 构造员工对象
        Emp emp = new Emp();
        emp.setUsername("Tom1");
        emp.setName("汤姆1");
        emp.setImage("2.jpeg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2023, 5, 21));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        // 新增员工
        empMapper.insert(emp);
        System.out.println(emp.getId());


    }

    @Test
    public void testUpdate() {
        // 构造员工对象
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Tom0");
        emp.setName("汤姆0");
        emp.setImage("2.jpeg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2023, 5, 21));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.update(emp);

    }

    // 使用动态SQL更新代码，只需要修改要更新的字段
    @Test
    public void testUpdate2() {
        // 构造员工对象
        Emp emp = new Emp();
        emp.setId(21);
        emp.setUsername("Tom222");
        emp.setName("汤姆222");

        empMapper.update2(emp);

    }

    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(18);
        System.out.println(emp);
    }

    @Test
    public void testList() {
        List<Emp> list = empMapper.list("张", (short)1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        // List<Emp> list = empMapper.list(null, null, null, null);

        for (Emp emp:list) {
            System.out.println(emp);
        }

    }
    // @Test
    // public void testList() {
    //     List<Emp> list = empMapper.list("张", (short)1, null, null);
    //
    //     for (Emp emp:list) {
    //         System.out.println(emp);
    //     }
    //
    // }

    @Test
    public void deleteIds() {
        List<Integer> empIds = Arrays.asList(13,14,15);
        empMapper.deleteByIds(empIds);

    }


}
