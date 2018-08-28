package com.belle.springboot.controller;

import com.belle.springboot.pojo.Emp;
import com.belle.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/one")
    public Emp getOne(@RequestParam("empno")Integer empno){
        return empService.getOne (empno);
    }

    @GetMapping("/all")
    public List<Emp> getAll(){
        return empService.getAll ();
    }
}
