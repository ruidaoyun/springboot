package com.belle.springboot.controller;


import com.belle.springboot.pojo.JsonResult;
import com.belle.springboot.pojo.Users;
import com.belle.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private HttpServletResponse response;

    @GetMapping("all")
    public List<Users> getAll(){
        return usersService.getAll ();
    }

    @GetMapping("{id}")
    public Users getUserById(@PathVariable("id")Integer id){
        return usersService.getUserById (id);
    }

    @GetMapping()
    public Users getUserByName(@RequestParam("name") String name){
        return usersService.getUserByName (name);
    }

    @DeleteMapping("{id}")
    public JsonResult delete(@PathVariable("id")Integer id){
        Integer i=usersService.deleteUsersById (id);

        if (i>0){
            return new JsonResult (0,"delete success");
        }
       return new JsonResult (1,"delete failed");
    }

    @PostMapping
    public JsonResult insert(Users users){
        Integer i=usersService.insertUsers (users);
        if (i>0){
            return new JsonResult (0,"insert success");
        }
        return new JsonResult (1,"insert failed");

    }

    @PutMapping
    public JsonResult update(Users users){
        Integer i=usersService.updateUsers (users);
        if (i>0){
            return new JsonResult (0,"update success");
        }
        return new JsonResult (1,"update failed");
    }
}
