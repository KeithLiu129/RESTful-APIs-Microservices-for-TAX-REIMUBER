package com.techbow.datadashboard.controller;

import com.techbow.datadashboard.model.dao.DataDao;
import com.techbow.datadashboard.model.dao.impl.DataHashMapDao;
import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController //:== @Controller + @ResponseBody
public class DataDashboardController {

    @Autowired
    private DataDao dataDao;

    @PostMapping("data")
    public Data createData(@RequestBody Data data) {
        return dataDao.save(data);
    }

    @GetMapping("/data/{id}")
    public Data findDataById(@PathVariable Long id) {
        return dataDao.findById(id);
    }




    @GetMapping("hello")
    public String hello() {
        return "Hello";
    }


    @GetMapping("hello/{name}")
    public String hello2(@PathVariable String name) {
        return "Hello" + name;
    }

}
