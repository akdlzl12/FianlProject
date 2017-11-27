package com.es.employee.service;

import java.util.Date;
import java.util.List;

import com.es.common.vo.Pagination;
import com.es.employee.vo.Employee;

public interface EmployeeService {
	/**
	 * 직원등록
	 * @return
	 */
	public Employee register(Employee employee);
	
	/**
	 * 직원검색 (페이지네이션)
	 * @param pagination
	 * @return
	 */
	public List<Employee> searchEmployees(Pagination pagination);
	/**
	 * 직원 상세정보 읽어오기
	 * @return
	 */
	public Employee detail(int id, Date when);
	
	/**
	 * 직원 정보 업데이트하기
	 * @param employee
	 * @return
	 */
	public Employee update(Employee employee);
	
	/**
	 * 직원 정보 삭제 (실제 데이터베이스에서 삭제하는게 아니라 delete 칼럼을 1로 변경해 삭제된 것으로 간주하기 위함)
	 * @param id
	 * @return
	 */
	public Employee delete(int id);

	public void dummy();
}
