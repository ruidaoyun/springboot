package com.belle.springboot.service.impl;

import com.belle.springboot.dao.EmpDAO;
import com.belle.springboot.pojo.Emp;
import com.belle.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDAO empDAO;

    @Override
    public List<Emp> getAll() {
        return empDAO.getAll ();
    }

    @Override
    public Emp getOne(Integer empno) {
        return empDAO.getOne (empno);
    }
}
