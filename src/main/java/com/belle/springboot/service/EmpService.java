package com.belle.springboot.service;

import com.belle.springboot.pojo.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getAll();

    Emp getOne(Integer empno);
}
