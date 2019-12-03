package com.techbow.datadashboard.controller;

import com.techbow.datadashboard.model.dao.DataDao;
import com.techbow.datadashboard.model.dao.impl.DataHashMapDao;
import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //:== @Controller + @ResponseBody
@RequestMapping("api/v1")
public class DataDashboardController {

    @Qualifier("dataJpaDao")
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

    @GetMapping("/data")
    public List<Data> getAllData(@RequestParam(name = "limit", required = false) String limit) {
        return dataDao.findAll(limit);
    }
    @GetMapping("data/client/{clientId}")
    public List<Data> findDataByClientId(Long clientId) {
        return null;
    }
}
