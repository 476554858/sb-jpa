package com.sbjpa;

import com.sbjpa.entity.User;
import com.sbjpa.repository.UserRepository;
import com.sbjpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbJpaApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	EntityManager entityManager;
	@Test
	public void contextLoads() {
		/*User user = new User();
		user.setEmail("111@ddd.com");
		user.setLastName("我是休息休息");
		userRepository.save(user);*/
//		User user = userRepository.findByLastName("张三");
//		System.out.println(user.toString());

//		List<User> list = userRepository.getByLastNameStartingWithAndIdLessThan("张",3);
//		for(User u:list){
//			System.out.println(u.toString());
//		}

//		User u = userRepository.getMaxIdUser();
		//System.out.println(u);

//		User u = userRepository.testQueryAnnotationParams2("333@qq.com", "张三");
//		userService.updateUser("xxx",1);
//		List<User> users = new ArrayList<User>();
//		for(int i='a';i<='z';i++){
//			User u = new User();
//			u.setEmail(i+"@@@q.com");
//			u.setLastName((char)i+""+(char)i);
//			users.add(u);
//		}
//		userRepository.save(users);


		User user = new User();
		user.setEmail("xxx");
		user.setLastName("xxxx");
		user.setId(31);
		User user1 = userRepository.saveAndFlush(user);
		System.out.println(user==user1);
	}

	@Test
	public void testPage(){
		int pageNo = 3-1;
		int pageSize = 5;
		Sort.Order order1 = new Sort.Order(Sort.Direction.ASC,"id");
		Sort.Order order2 = new Sort.Order(Sort.Direction.ASC,"lastName");
		Sort sort = new Sort(order1,order2);
		PageRequest pageRequest = new PageRequest(pageNo,pageSize,sort);

		Page<User> page = userRepository.findAll(pageRequest);

		System.out.println("总记录数:"+page.getTotalElements());
		System.out.println("当前第几页："+(page.getNumber()+1));
		System.out.println("总页数"+page.getTotalPages());
		System.out.println("当前页面的list"+page.getContent());
		System.out.println("但钱页面的记录数"+page.getNumberOfElements());
	}

	@Test
	public void testJpaSpecificationExecutor(){
		int pageNo = 3-1;
		int pageSize = 5;
		PageRequest pageRequest = new PageRequest(pageNo,pageSize);
		Specification<User> specification = new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				Path path = root.get("id");
				Predicate predicate = criteriaBuilder.gt(path,5);
				return predicate;
			}
		};
		Page<User> page = userRepository.findAll(specification,pageRequest);
	}

	@Test
	public void testEtitymanageer(){
		userRepository.test();
	}


















	@Test
	public void test(){
		Map<String,Object> dataBus = new HashMap<String,Object>();
		dataBus.put("PayerAcctNo","12344444");


		String selfCarCode = (String)dataBus.get("PayerAcctNo");

		String cardBin = "123456";

		Boolean flag = selfCarCode.startsWith(cardBin);

		System.out.println(flag);
		dataBus.put("isKH",flag);

		System.out.println((Boolean)dataBus.get("isKH"));


		dataBus.put("PayerAcctNo","");
		dataBus.put("PayerAcctName","");
		dataBus.put("PayeeAcctNo","");
		dataBus.put("PayeeAcctName","");
		dataBus.put("RealTranAmt","");
		dataBus.put("AcctBal","");
		dataBus.put("TradeDate","");
		dataBus.put("TellerSeqNo","");

	}


	@Test
	public void test2(){
		URL url = this.getClass().getClassLoader().getResource("/"+"com");
		String fileStr = url.getFile();
		System.out.println(fileStr);
		File file = new File(fileStr);
		String[] filesStr = file.list();
		for(String path:filesStr){
			System.out.println(path);
		}

	}








}
