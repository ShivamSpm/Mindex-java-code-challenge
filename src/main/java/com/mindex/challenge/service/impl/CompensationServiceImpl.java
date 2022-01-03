package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompensationServiceImpl implements CompensationService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private EmployeeService employeeService;

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    /**
     * This method creates the compensation object and inserts into mongo repository
     *
     * @param compensation is the object of class Compensation
     * @return             the compensation object
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);
        Employee employee = employeeService.read(compensation.getEmployee().getEmployeeId());
        compensation.setEmployee(employee);
        compensationRepository.insert(compensation);

        return compensation;
    }

    /**
     * This method reads the compensation of a given employee
     *
     * @param id is the employee id
     * @return   the compensation object
     */
    @Override
    public Compensation read(String id) {
        LOG.debug("Read compensation with id [{}]", id);
        Employee employee = employeeRepository.findByEmployeeId(id);
        Compensation compensation = compensationRepository.findByEmployee(employee);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        if (compensation == null) {
            throw new RuntimeException("Invalid compensation: " + id);
        }
        return compensation;
    }
}
