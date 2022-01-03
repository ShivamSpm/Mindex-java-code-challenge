package com.mindex.challenge.controller;


import com.mindex.challenge.data.ReportingStructure;

import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;


    /**
    * This method calls the API to read the number of reports of a given employee
    *
    * @param id is the id of an employee
    * @return   the reporting structure of an employee
     */
    @GetMapping("/readNumberOfReports/{id}")
    public ReportingStructure readNumberOfReports(@PathVariable String id) {
        LOG.debug("Received read number of reports [{}]", id);

        return reportingStructureService.readNumberOfReports(id);
    }
}
