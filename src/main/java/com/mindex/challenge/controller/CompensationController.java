package com.mindex.challenge.controller;


import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {

    @Autowired
    private CompensationService compensationService;

    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    /**
     * This method calls the API to create the compensation of an employee
     *
     * @param compensation is the object of the class Compensation
     * @return             created compensation of the employee
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation){
        LOG.debug("Received compensation create request for [{}]", compensation);
        return compensationService.create(compensation);
    }

    /**
     * This method calls the API to read the compensation by employee id
     *
     * @param id is the employee id
     * @return   the compensation object of the employee
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation read request for id [{}]", id);

        return compensationService.read(id);
    }

}
