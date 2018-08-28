package com.belle.springboot.dao;

import com.belle.springboot.pojo.Emp;

import java.util.List;

public interface EmpDAO {
    List<Emp> getAll();

    Emp getOne(Integer empno);
}
