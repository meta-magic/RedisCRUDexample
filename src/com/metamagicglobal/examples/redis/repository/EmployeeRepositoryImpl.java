package com.metamagicglobal.examples.redis.repository;

import java.util.Map;

import org.springframework.data.redis.core.RedisTemplate;

import com.metamagicglobal.examples.redis.entity.Employees;
import com.metamagicglobal.examples.redis.repository.EmployeeRepository;

public class EmployeeRepositoryImpl implements  EmployeeRepository
{
		
		private RedisTemplate<String, Employees> redisTemplate;
		
		private static String EMP_KEY = "Employees";

		public RedisTemplate<String, Employees> getRedisTemplate()
		{
				return redisTemplate;
		}

		public void setRedisTemplate(RedisTemplate<String, Employees> redisTemplate)
		{
				this.redisTemplate = redisTemplate;
		}

		@Override
		public void addEmployee(Employees emp)
		{
				this.redisTemplate.opsForHash().put(EMP_KEY, emp.getId(), emp);
		}

		@Override
		public Employees getEmployeeById(String id)
		{
				return (Employees)this.redisTemplate.opsForHash().get(EMP_KEY, id);
		}

		@Override
		public Map<Object,Object> getAllEmployees()
		{
				return this.redisTemplate.opsForHash().entries(EMP_KEY);
		}

		@Override
		public void delEmployeeById(String id)
		{
				this.redisTemplate.opsForHash().delete(EMP_KEY,id);
				
		}

		@Override
		public void updateEmployee(Employees emp) {
			// TODO Auto-generated method stub
			this.redisTemplate.opsForHash().put(EMP_KEY, emp.getId(), emp);
		}

}
