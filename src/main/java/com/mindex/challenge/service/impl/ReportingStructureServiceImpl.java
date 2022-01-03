package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private int _numReports;

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    /**
     * This Method calculates the number of reports of a given employee
     *
     * @param employeeId is the id of an employee
     * @return           the fully filled out ReportingStructure
     */
    @Override
    public ReportingStructure readNumberOfReports(String employeeId) {

        LOG.debug("Creating ReportingStructure with id [{}]", employeeId);
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        _numReports = 0;
        helperMethod(employee);

        return new ReportingStructure(employee, _numReports);
    }


    /**
     * This method applies DFS on the given employee to calculate its number of reports
     *
     * @param employee is the given employee object
     */
    public void helperMethod(Employee employee){

        List<Employee> directReports = employee.getDirectReports();

        if(directReports==null)
            return;

        _numReports+=directReports.size();
        for (int i = 0; i < directReports.size();i++) {
            String employeeId = directReports.get(i).getEmployeeId();
            Employee thisEmployee = employeeRepository.findByEmployeeId(employeeId);
            helperMethod(thisEmployee);
        }
    }
}
