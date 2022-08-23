package com.kit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kit.entity.Attendance;
import com.kit.entity.Department;
import com.kit.entity.Designation;
import com.kit.entity.Employee;
import com.kit.entity.Grade;
import com.kit.entity.GradeDetail;
import com.kit.entity.Transaction;
import com.kit.entity.User;
import com.kit.enums.AmountType;
import com.kit.enums.Gender;
import com.kit.enums.PaymentType;
import com.kit.enums.TransactionType;
import com.kit.repository.DepartmentRepository;
import com.kit.repository.DesignationRepository;
import com.kit.repository.EmployeeRepository;
import com.kit.repository.GradeDetailRepository;
import com.kit.repository.GradeRepository;
import com.kit.repository.TransactionRepository;
import com.kit.repository.UserRepository;

@SpringBootTest
class HrApplicationTests {

	private String username = "zubayer";
	private String departmentName = "Software";
	private String designation = "Senior Software Engineer";

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private DepartmentRepository depRepo;
	@Autowired
	private DesignationRepository desRepo;
	@Autowired
	private TransactionRepository trnRepo;
	@Autowired
	private GradeRepository gradeRepo;
	@Autowired
	private GradeDetailRepository gradDetailRepo;
	@Autowired
	private EmployeeRepository empRepo;

	@Order(1)
	@Test
	void createUser() {
		User u = new User();
		u.setEmail("zubayer@gmail.com");
		u.setUsername(username);
		u.setPassword("1234");
		u.setStatus(true);
		u = userRepo.save(u);
		assertNotNull(u);
		System.out.println(u.toString());
	}

	@Order(2)
	@Test
	void createDepartment() {
		Department d = new Department();
		d.setName(departmentName);
		d.setStatus(true);
		d = depRepo.save(d);
		assertNotNull(d);
		System.out.println(d.toString());
	}

	@Order(3)
	@Test
	void createDesignation() {
		Designation d = new Designation();
		d.setName(designation);
		d.setStatus(true);
		d = desRepo.save(d);
		assertNotNull(d);
		System.out.println(d.toString());
	}

	@Order(4)
	@Test
	void createTransaction() {
		List<Transaction> list = new ArrayList<>();

		Transaction t = new Transaction();
		t.setName("Basic Salary");
		t.setTransactionType(TransactionType.ADDITION);
		t.setStatus(true);
		list.add(t);

		Transaction t1 = new Transaction();
		t1.setName("House Allowance");
		t1.setTransactionType(TransactionType.ADDITION);
		t1.setStatus(true);
		list.add(t1);

		Transaction t2 = new Transaction();
		t2.setName("Provident Fund");
		t2.setTransactionType(TransactionType.DEDUCTION);
		t2.setStatus(true);
		list.add(t2);

		Transaction t3 = new Transaction();
		t3.setName("Medical Allowance");
		t3.setTransactionType(TransactionType.ADDITION);
		t3.setStatus(true);
		list.add(t3);

		Transaction t4 = new Transaction();
		t4.setName("Transportation Allowance");
		t4.setTransactionType(TransactionType.ADDITION);
		t4.setStatus(true);
		list.add(t4);

		Transaction t5 = new Transaction();
		t5.setName("Mobile Allowance");
		t5.setTransactionType(TransactionType.ADDITION);
		t5.setStatus(true);
		list.add(t5);

		List<Transaction> result = trnRepo.saveAll(list);
		assertEquals(list.size(), result.size(), "Something wrong");

		result.stream().forEach(r -> System.out.println(r.toString()));
	}

	@Order(5)
	@Test
	void createGrade() {
		Grade g = new Grade();
		g.setCode("Default");
		g.setStatus(true);
		g = gradeRepo.save(g);
		System.out.println(g.toString());

		Grade g1 = new Grade();
		g1.setCode("Intern");
		g1.setStatus(true);
		g1 = gradeRepo.save(g1);
		System.out.println(g1.toString());
	}

	@Order(6)
	@Test
	void createGradeDetails() {
		List<GradeDetail> list = new ArrayList<GradeDetail>();

		GradeDetail d1 = new GradeDetail();
		d1.setGradeId(Long.valueOf(1));
		d1.setTransactionId(Long.valueOf(1)); // Basic Salary
		d1.setType(AmountType.PERCENT);
		d1.setAmount(BigDecimal.valueOf(50));
		list.add(d1);

		GradeDetail d2 = new GradeDetail();
		d2.setGradeId(Long.valueOf(1));
		d2.setTransactionId(Long.valueOf(2)); // House Allowance
		d2.setType(AmountType.PERCENT);
		d2.setAmount(BigDecimal.valueOf(35));
		list.add(d2);

		GradeDetail d3 = new GradeDetail();
		d3.setGradeId(Long.valueOf(1));
		d3.setTransactionId(Long.valueOf(3)); // Provident Fund
		d3.setType(AmountType.PERCENT);
		d3.setAmount(BigDecimal.valueOf(5));
		list.add(d3);

		GradeDetail d4 = new GradeDetail();
		d4.setGradeId(Long.valueOf(1));
		d4.setTransactionId(Long.valueOf(4)); // Medical Allowance
		d4.setType(AmountType.PERCENT);
		d4.setAmount(BigDecimal.valueOf(6));
		list.add(d4);

		GradeDetail d5 = new GradeDetail();
		d5.setGradeId(Long.valueOf(1));
		d5.setTransactionId(Long.valueOf(5)); // Transportation Allowance
		d5.setType(AmountType.PERCENT);
		d5.setAmount(BigDecimal.valueOf(8));
		list.add(d5);

		GradeDetail d6 = new GradeDetail();
		d6.setGradeId(Long.valueOf(1));
		d6.setTransactionId(Long.valueOf(6)); // Mobile Allowance
		d6.setType(AmountType.PERCENT);
		d6.setAmount(BigDecimal.valueOf(1));
		list.add(d6);

		GradeDetail d7 = new GradeDetail();
		d7.setGradeId(Long.valueOf(2));
		d7.setTransactionId(Long.valueOf(1)); // Basic Salary
		d7.setType(AmountType.PERCENT);
		d7.setAmount(BigDecimal.valueOf(50));
		list.add(d7);

		GradeDetail d8 = new GradeDetail();
		d8.setGradeId(Long.valueOf(2));
		d8.setTransactionId(Long.valueOf(2)); // House Allowance
		d8.setType(AmountType.PERCENT);
		d8.setAmount(BigDecimal.valueOf(35));
		list.add(d8);

		GradeDetail d9 = new GradeDetail();
		d9.setGradeId(Long.valueOf(2));
		d9.setTransactionId(Long.valueOf(3)); // Provident Fund
		d9.setType(AmountType.PERCENT);
		d9.setAmount(BigDecimal.valueOf(0));
		list.add(d9);

		GradeDetail d10 = new GradeDetail();
		d10.setGradeId(Long.valueOf(2));
		d10.setTransactionId(Long.valueOf(4)); // Medical Allowance
		d10.setType(AmountType.PERCENT);
		d10.setAmount(BigDecimal.valueOf(6));
		list.add(d10);

		GradeDetail d11 = new GradeDetail();
		d11.setGradeId(Long.valueOf(2));
		d11.setTransactionId(Long.valueOf(5)); // Transportation Allowance
		d11.setType(AmountType.PERCENT);
		d11.setAmount(BigDecimal.valueOf(8));
		list.add(d11);

		GradeDetail d12 = new GradeDetail();
		d12.setGradeId(Long.valueOf(2));
		d12.setTransactionId(Long.valueOf(6)); // Mobile Allowance
		d12.setType(AmountType.PERCENT);
		d12.setAmount(BigDecimal.valueOf(1));
		list.add(d12);

		List<GradeDetail> result = gradDetailRepo.saveAll(list);
		assertEquals(list.size(), result.size(), "Something wrong");

		result.stream().forEach(r -> System.out.println(r.toString()));
	}

	@Order(7)
	@Test
	void createEmployee() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Employee e = new Employee();
		e.setUserId(Long.valueOf(1));
		e.setGender(Gender.MALE);
		e.setMobile("01515634889");
		e.setDob(sdf.parse("1990-09-26"));
		e.setGradeId(Long.valueOf(1));
		e.setJoiningDate(sdf.parse("2020-11-10"));
		e.setResignDate(null);
		e.setPermanentDate(sdf.parse("2021-02-10"));
		e.setTotalSalary(BigDecimal.valueOf(62000));
		e.setPaymentType(PaymentType.CASH);
		e.setBankAccount(null);
		e.setBankAmount(BigDecimal.ZERO);
		e.setCashAmount(e.getTotalSalary());
		e.setCheckAmount(BigDecimal.ZERO);
		e.setBankName(null);
		e.setTin(null);
		e.setStatus(true);
		e.setDepartmentId(Long.valueOf(1));
		e.setDesignationId(Long.valueOf(1));
		e = empRepo.save(e);
		System.out.println(e.toString());
	}

	@Order(8)
	@Test
	void createAttendance() throws ParseException {
		
		Attendance a = new Attendance();
		
		
		
	}

}
