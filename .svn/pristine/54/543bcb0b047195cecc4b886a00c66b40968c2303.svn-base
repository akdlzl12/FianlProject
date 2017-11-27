package com.es.employee.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.common.vo.Pagination;
import com.es.employee.mapper.EmployeeMapper;
import com.es.employee.mapper.JobHistoryMapper;
import com.es.employee.mapper.PayHistoryMapper;
import com.es.employee.vo.Employee;
import com.es.employee.vo.EmployeeManagement;
import com.es.employee.vo.EmployeeTimetable;
import com.es.employee.vo.JobHistory;
import com.es.employee.vo.PayHistory;
import com.es.financial.mapper.DailyReportMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper empMapper;
	@Autowired
	private PayHistoryMapper payMapper;
	@Autowired
	private JobHistoryMapper jobMapper;
	@Autowired
	private DailyReportMapper reportMapper;
	
	@Override
	public Employee register(Employee employee) {
		employee.setId(empMapper.readNextId());
		empMapper.insert(employee);
		
		PayHistory payHistory = new PayHistory();
		payHistory.setEmployee(employee);
		payHistory.setStartedDate(employee.getHiredAt());
		payHistory.setHourlyPay(employee.getHourlyPay());
		payHistory.setId(this.payMapper.readNextId());
		this.payMapper.insert(payHistory);
		
		JobHistory jobHistory = new JobHistory();
		jobHistory.setEmployeeId(employee.getId());
		jobHistory.setStartedDate(employee.getHiredAt());
		jobHistory.setJobType(employee.getJobType());
		jobHistory.setId(this.jobMapper.readNextId());
		this.jobMapper.insert(jobHistory);
		return employee;
	}
	
	@Override
	public List<Employee> searchEmployees(Pagination pagination) {	
		pagination.setTotalItems(this.empMapper.readTotalRow(pagination));
		return this.empMapper.list(pagination);
	}

	@Override
	public Employee detail(int id, Date when) {
		
		Employee employee = this.empMapper.read(id);
		Map<String, Object> timeMap = new HashedMap<String, Object>();
		timeMap.put("id", id);
		timeMap.put("when", when);
		employee.setJobHistory(this.empMapper.listJobHistoryByEmpId(id));
		List<PayHistory> payHistories =this.empMapper.listPayHistoryByEmpId(timeMap);
		if(payHistories.size() > 1) {
			for(PayHistory history : payHistories) {
				if(history.getEndedDate() == null) {
					if(when.getTime() > history.getStartedDate().getTime()) {
						employee.setHourlyPay(history.getHourlyPay());
						break;
					}
				} else {
					if(when.getTime() > history.getStartedDate().getTime() && when.getTime() < history.getEndedDate().getTime()) {
						employee.setHourlyPay(history.getHourlyPay());
						break;
					}
				}
			}
		} else if(payHistories.size() == 1){
			PayHistory payHistory = payHistories.get(0);
			employee.setHourlyPay(payHistory.getHourlyPay());
		}
		employee.setManagements(this.empMapper.listManagementByEmpIdAndDate(timeMap)); 
		List<Map<String, Object>> salaryAndWorkingHourList = this.empMapper.readSalaryAndWorkingHoursByIdAndDate(timeMap);
		if(!salaryAndWorkingHourList.isEmpty()) {
			Map<String, Object> salaryAndWorkingMap = salaryAndWorkingHourList.get(0);
			employee.setSalary(((BigDecimal)salaryAndWorkingMap.get("SALARY")).intValue());
			employee.setWorkingHoursPerMonth(((BigDecimal)salaryAndWorkingMap.get("WORKING_HOURS")).intValue());
		}
		employee.setMismatches(this.reportMapper.readMismatchRecordByEmpIdAndDate(timeMap));
		employee.setMismatchPerMonth(this.empMapper.readMismatchByIdAndDate(timeMap));
		employee.setTheifRecords(this.empMapper.listTheifRecordByEmpId(id));
		
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		Employee foundEmployee = this.empMapper.read(employee.getId());
		this.empMapper.update(employee);
		
		if(employee.getJobType() != null) {
			if(!foundEmployee.getJobType().equals(employee.getJobType())) {
				this.jobMapper.updateJobHistoryEndedDate(employee.getId());
				JobHistory history = new JobHistory();
				history.setId(this.jobMapper.readNextId());
				history.setJobType(employee.getJobType());
				history.setEmployeeId(employee.getId());
				history.setStartedDate(new Date());
				this.jobMapper.insert(history);
			}
			if(foundEmployee.getHourlyPay() != (employee.getHourlyPay())) {
				this.empMapper.updatePayHistoryEndedDate(employee.getId());
				PayHistory history = new PayHistory();
				history.setId(this.jobMapper.readNextId());
				history.setHourlyPay(employee.getHourlyPay());
				history.setEmployee(employee);
				history.setStartedDate(new Date());
				this.empMapper.insertPayHistory(history);
			}
		}
		return employee;
	}

	@Override
	public Employee delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean registerPunish(EmployeeManagement mng, Date date) {
		Map<String, Object> map = new HashMap();
		map.put("id", mng.getEmployeeId());
		map.put("when", date);
		EmployeeTimetable timetable = this.empMapper.readTimetableIdByIdAndDate(map);
		if(timetable == null)
			return false;
		mng.setTimetable(timetable);
		this.empMapper.registerTimetableManagement(mng);
		return true;
	}
	
	
	@Override
	public List<EmployeeTimetable> timetableByDate(Date when) {
		List<EmployeeTimetable> timetables  = this.empMapper.listTimetableByDate(when);
		
		
		return timetables;
	}

	@Override
	public void timetableUpdate(EmployeeTimetable timetable) {
		this.empMapper.updateTimetable(timetable);
		if(timetable.getManagementId() != null && timetable.getManagementId() > 0 && timetable.getManagementDetail() != null) {
			// update
			this.empMapper.updateManagement(timetable);
		} else if(timetable.getManagementDetail() != null){
			// insert
			this.empMapper.insertManagement(timetable);
		}
	}
	
	@Override
	public void dummy() {
//		Random r = new Random();
//		
//		
//		String[] firstNames = new String[] {"진희", "진주", "효연", "여민", "래선", "희태", "주성", "연강", "소희", "하늘", "명보",
//				"희창", "은영", "청웅", "찬주", "대문", "민영", "혜미", "희경", "찬호", "태겸", "라예", "미려", "성오", "수천", "경도", "종흠",
//				"현우", "요훈", "찬우", "보미", "주상", "경우", "선문", "태현", "상민", "민아"};
//		String[] lastNames = new String [] {"이", "함", "송", "반", "임", "명", "천", "예", "채", "임", "장", "민", "정",
//				"마", "진", "노", "구", "선", "명", "최", "천", "윤", "소", "민"};
//		String[] metropolitan = new String[] {
//				"서울", "인천", "대전", "서울", "서울", "서울", "대구", "대구", "부산", "부산", "울산", "울산", "울산", "울산",
//				"부산", "서울", "서울", "서울", "서울", "서울", "서울", "서울", "서울", "대전" , "대전", "대전", "대전", "대전", "광주", "광주", "광주", "광주"
//		};
//		String[] gu = new String[] {
//				"은평구", "종로구", "중구", "서구", "남구", "부평구", "분당구", "노원구", "달서구", "중구", "서구", "북구", "남구", "서면" 
//		};
//		String[] dong = new String[] {
//				"묘동", "녹번동", "죽전동", "원평동", "남동", "북동", "진동", "진남동", "서원동", "남서동", "양재동", "노원동", "돈구동"
//		};
//		
//		
//		
//		int size = 40;
//		String[] cGender = new String[] {"F", "M"};
//		String[] jType = new String[] {"I", "T"};
//		
//		
//		String[] mReasons = new String[] {
//			"늦잠", "차 막힘", "경미한 교통사고", "몸살", "개인사정", "독감", "몸살", "친적 조문", "전화 안받음", "연락이 닿지 않음", "단말기에서 돈을 가져감"  	
//		};
//		String[] mDetails = new String[] {
//			"L", "L", "L", "E", "E", "E", "A", "A", "U", "U", "T"	
//		};
//		Date[] workingMonth = new Date[] { 
//				DateUtil.yyyymmdd("2017-11-09"),DateUtil.yyyymmdd("2017-11-10"),DateUtil.yyyymmdd("2017-11-11"),DateUtil.yyyymmdd("2017-11-09"),
//				DateUtil.yyyymmdd("2017-11-13"),DateUtil.yyyymmdd("2017-11-14"),DateUtil.yyyymmdd("2017-11-15"),DateUtil.yyyymmdd("2017-11-16"),
//				DateUtil.yyyymmdd("2017-11-17"),DateUtil.yyyymmdd("2017-11-18"),DateUtil.yyyymmdd("2017-11-19"),DateUtil.yyyymmdd("2017-11-20"),
//				DateUtil.yyyymmdd("2017-11-21"),DateUtil.yyyymmdd("2017-11-22"),DateUtil.yyyymmdd("2017-11-23"),DateUtil.yyyymmdd("2017-11-24"),
//				DateUtil.yyyymmdd("2017-11-25"),
//				DateUtil.yyyymmdd("2017-11-26"),
//				DateUtil.yyyymmdd("2017-11-27"),
//				DateUtil.yyyymmdd("2017-11-28"),
//				DateUtil.yyyymmdd("2017-11-29"),
//				DateUtil.yyyymmdd("2017-12-01"),
//				DateUtil.yyyymmdd("2017-12-02"),
//				DateUtil.yyyymmdd("2017-12-03"),
//				DateUtil.yyyymmdd("2017-12-04"),
//				DateUtil.yyyymmdd("2017-12-05"),
//				DateUtil.yyyymmdd("2017-12-06"),
//				DateUtil.yyyymmdd("2017-12-07"),
//				DateUtil.yyyymmdd("2017-12-08"),
//				DateUtil.yyyymmdd("2017-12-09"),
//				DateUtil.yyyymmdd("2017-12-10"),
//				DateUtil.yyyymmdd("2017-12-11"),
//				DateUtil.yyyymmdd("2017-12-12"),
//				DateUtil.yyyymmdd("2017-12-13"),
//		};
//		int[] mismatch = new int[] {
//				0, 0, 0, 0, 0, 30000, 0, 0, 0,0, 0, 0, 0, 0, 10000, 0, 0, 0,0, 0, 0, 0, 0, 30000, 0, 0, 0,0, 0, 0, 0, 0, 100000, 0, 0, 0
//		};
//		int[] admins = new int[] {
//			0, 0, 0, 1, 2, 3, 0, 0, 0, 0,0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 0, 0 
//		};
//		int[] pos = new int[] {
//			1, 2, 3, 4, 5
//		};
//		int [] emps = new int[] {
//				0, 0, 0, 0, 0, 5, 0, 0, 0,0, 0, 0, 0, 0, 3, 0, 0, 0,0, 0, 0, 0, 0, 5, 0, 0, 0,0, 0, 0, 0, 0, 7, 0, 0, 0
//		};
//		
//		
//		Date[] startedAt = new Date[] {
//			DateUtil.yyyymmddhhmmss("2017-11-09 09:00:00"), DateUtil.yyyymmddhhmmss("2017-11-10 09:00:00"), DateUtil.yyyymmddhhmmss("2017-11-11 09:00:00"),
//			DateUtil.yyyymmddhhmmss("2017-11-12 09:00:00"), DateUtil.yyyymmddhhmmss("2017-11-13 09:00:00"), DateUtil.yyyymmddhhmmss("2017-11-15 09:00:00"),
//			DateUtil.yyyymmddhhmmss("2017-11-16 09:00:00"), DateUtil.yyyymmddhhmmss("2017-11-17 09:00:00"), DateUtil.yyyymmddhhmmss("2017-11-19 09:00:00"),
//			DateUtil.yyyymmddhhmmss("2017-11-20 09:00:00"), DateUtil.yyyymmddhhmmss("2017-11-21 09:00:00"), DateUtil.yyyymmddhhmmss("2017-11-22 09:00:00")
//		};
//		Date[] endedAt = new Date[] {
//			DateUtil.yyyymmddhhmmss("2017-11-09 18:00:00"), DateUtil.yyyymmddhhmmss("2017-11-10 18:00:00"), DateUtil.yyyymmddhhmmss("2017-11-11 18:00:00"),
//			DateUtil.yyyymmddhhmmss("2017-11-12 18:00:00"), DateUtil.yyyymmddhhmmss("2017-11-13 18:00:00"), DateUtil.yyyymmddhhmmss("2017-11-15 18:00:00"),
//			DateUtil.yyyymmddhhmmss("2017-11-16 18:00:00"), DateUtil.yyyymmddhhmmss("2017-11-17 18:00:00"), DateUtil.yyyymmddhhmmss("2017-11-19 18:00:00"),
//			DateUtil.yyyymmddhhmmss("2017-11-20 18:00:00"), DateUtil.yyyymmddhhmmss("2017-11-21 18:00:00"), DateUtil.yyyymmddhhmmss("2017-11-22 18:00:00")
//		};
//		
//		Employee c = new Employee();
//		DailyReport dr = new DailyReport();
//		
//		EmployeeTimetable et = new EmployeeTimetable();
//		EmployeeManagement em = new EmployeeManagement();
//		
//		for(int i=0; i < workingMonth.length; i++) {
//			dr.setEmployeeId(emps[i]);
//			dr.setPosId(1);
//			if(emps[i] != 0) dr.setReport("횡령");
//			else dr.setReport("이상없음");
//			dr.setMismatchMoney(mismatch[i]);
//			dr.setWorkingDate(workingMonth[i]);
//			dr.setId(this.reportMapper.nextId());
//			this.reportMapper.insert(dr);
//			System.out.println(dr);
//		}
//		int timeSize = startedAt.length;
//		int manageSize = mDetails.length;
//		for(int i=0; i<size ; i++) {
//			String name = lastNames[r.nextInt(lastNames.length)]+firstNames[r.nextInt(firstNames.length)];
//			String firstPhone = String.format("%4s", String.valueOf(r.nextInt(9999))).replace(" ", "0");
//			String lastPhone = String.format("%4s", String.valueOf(r.nextInt(9999))).replace(" ", "0");
//			Date ccreated = DateUtil.yyyymmdd("" + 201 + r.nextInt(8)+ "-"+String.format("2%s", r.nextInt(12)).replace(" ", "0") + "-"+String.format("2%s", r.nextInt(30)).replace(" ", "0"));
//			
//			c.setName(name);
//			c.setPhone("010-"+firstPhone +"-"+ lastPhone);
//			c.setHourlyPay(6450);
//			c.setGender(cGender[r.nextInt(2)]);
//			c.setJobType(jType[r.nextInt(2)]);
//			c.setAddress(metropolitan[r.nextInt(metropolitan.length)]+" "
//					+gu[r.nextInt(gu.length)]+" "
//					+dong[r.nextInt(dong.length)]+" "
//					+String.format("%3s", String.valueOf(r.nextInt(999))).replace(" ", "5")+"-"+String.format("%2s", String.valueOf(r.nextInt(99))).replace(" ", "2"));
//			c.setAccountNo(String.format("%5s", String.valueOf(r.nextInt(99999))).replace(" ", "0")+"-"+String.format("%4s", String.valueOf(r.nextInt(9999))).replace(" ", "0")+"-"+String.format("%4s", String.valueOf(r.nextInt(9999))).replace(" ", "0"));
//			c.setHiredAt(ccreated);
//			c.setBirth(DateUtil.yyyymmdd("1992-01-01"));
//			c = this.register(c);
//			for(int j=0; j < timeSize; j ++) {
//				
//				
//				int etId = this.empMapper.readNextTimetableId();
//				et.setId(etId);
//				et.setEmployee(c);
//				et.setStartedAt(startedAt[j]);
//				et.setEndedAt(endedAt[j]);
//				
//				this.empMapper.registerTimetable(et);
//				if(r.nextInt(5) % 5 == 0) {
//					int randomId = r.nextInt(mDetails.length);
//					em.setDetail(mDetails[randomId]);
//					em.setTimetableId(etId);
//					em.setReason(mReasons[randomId]);
//					this.empMapper.registerTimetableManagement(em);
//				}
//			}
//		}
	}

	


	
	
}
