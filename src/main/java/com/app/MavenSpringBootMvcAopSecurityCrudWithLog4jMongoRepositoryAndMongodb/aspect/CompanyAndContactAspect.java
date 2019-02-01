package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.aspect;

import java.util.Date;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class CompanyAndContactAspect {
	
	private Logger logger = Logger.getLogger(CompanyAndContactAspect.class);
	
	private long startTime;
	
	private long endTime;
	
	@Pointcut("execution(* com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.*(..))")
	public void applyPointcutDate() {
	}
	
	@Before("applyPointcutDate()")
	public void showExecutionDate() {
		System.out.println("");
		logger.debug("");
		System.out.println("Method Is Calling On :: "+ new Date());
		logger.debug("Method Is Calling On :: "+ new Date());
		logger.debug("");
	}
	
	@Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.addCompanyAndContact(..))")
	public void showStartTimeOfAddCompanyAndContact(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		int hashCode = jp.getSignature().hashCode();
		startTime = System.currentTimeMillis();
		System.out.println("Method Name Is :: "+methodName);
		System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
		System.out.println("Method Start Time Is :: "+startTime);
		logger.debug("Method Name Is :: "+methodName);
		logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
		logger.debug("Method Start Time Is :: "+startTime);
		logger.debug("");
		logger.debug("");
	}
	
	@After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.addCompanyAndContact(..))")
	public void showEndTimeOfAddCompanyAndContact(JoinPoint jp) {
		endTime = System.currentTimeMillis();
		System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		System.out.println("Method End Time Is :: "+endTime);
		System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		System.out.println("");
		logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		logger.debug("Method End Time Is :: "+endTime);
		logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		logger.debug("");
		logger.debug("");
	}
	
	@Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.updateCompanyAndContact(..))")
	public void showStartTimeOfUpdateCompanyAndContact(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		int hashCode = jp.getSignature().hashCode();
		startTime = System.currentTimeMillis();
		System.out.println("Method Name Is :: "+methodName);
		System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
		System.out.println("Method Start Time Is :: "+startTime);
		logger.debug("Method Name Is :: "+methodName);
		logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
		logger.debug("Method Start Time Is :: "+startTime);
		logger.debug("");
		logger.debug("");
	}
	
	@After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.updateCompanyAndContact(..))")
	public void showEndTimeOfUpdateCompanyAndContact(JoinPoint jp) {
		endTime = System.currentTimeMillis();
		System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		System.out.println("Method End Time Is :: "+endTime);
		System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		System.out.println("");
		logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		logger.debug("Method End Time Is :: "+endTime);
		logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		logger.debug("");
		logger.debug("");
	}
	
	@Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.deleteCompanyAndContact(..))")
	public void showStartTimeOfDeleteCompanyAndContact(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		int hashCode = jp.getSignature().hashCode();
		startTime = System.currentTimeMillis();
		System.out.println("Method Name Is :: "+methodName);
		System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
		System.out.println("Method Start Time Is :: "+startTime);
		logger.debug("Method Name Is :: "+methodName);
		logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
		logger.debug("Method Start Time Is :: "+startTime);
		logger.debug("");
		logger.debug("");
	}
	
	@After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.deleteCompanyAndContact(..))")
	public void showEndTimeOfDeleteCompanyAndContact(JoinPoint jp) {
		endTime = System.currentTimeMillis();
		System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		System.out.println("Method End Time Is :: "+endTime);
		System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		System.out.println("");
		logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		logger.debug("Method End Time Is :: "+endTime);
		logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		logger.debug("");
		logger.debug("");
	}
	
	@Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.getCompanyAndContactById(..))")
	public void showStartTimeOfGetCompanyAndContactById(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		int hashCode = jp.getSignature().hashCode();
		startTime = System.currentTimeMillis();
		System.out.println("Method Name Is :: "+methodName);
		System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
		System.out.println("Method Start Time Is :: "+startTime);
		logger.debug("Method Name Is :: "+methodName);
		logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
		logger.debug("Method Start Time Is :: "+startTime);
		logger.debug("");
		logger.debug("");
	}
	
	@After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.getCompanyAndContactById(..))")
	public void showEndTimeOfGetCompanyAndContactById(JoinPoint jp) {
		endTime = System.currentTimeMillis();
		System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		System.out.println("Method End Time Is :: "+endTime);
		System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		System.out.println("");
		logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		logger.debug("Method End Time Is :: "+endTime);
		logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		logger.debug("");
		logger.debug("");
	}
	
	@Before("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.getAllCompanyAndContact(..))")
	public void showStartTimeOfGetAllCompanyAndContact(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		int hashCode = jp.getSignature().hashCode();
		startTime = System.currentTimeMillis();
		System.out.println("Method Name Is :: "+methodName);
		System.out.println("Method Storing Memory Location Code Is :: "+hashCode);
		System.out.println("Method Start Time Is :: "+startTime);
		logger.debug("Method Name Is :: "+methodName);
		logger.debug("Method Storing Memory Location Code Is :: "+hashCode);
		logger.debug("Method Start Time Is :: "+startTime);
		logger.debug("");
		logger.debug("");
	}
	
	@After("execution(public * com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO.getAllCompanyAndContact(..))")
	public void showEndTimeOfGetAllCompanyAndContact(JoinPoint jp) {
		endTime = System.currentTimeMillis();
		System.out.println("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		System.out.println("Method End Time Is :: "+endTime);
		System.out.println("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		System.out.println("");
		logger.debug("Method Declaring Type Is :: "+jp.getSignature().getDeclaringType());
		logger.debug("Method End Time Is :: "+endTime);
		logger.debug("Method Total Time Taken Is :: "+(endTime - startTime)+" MilliSeconds");
		logger.debug("");
		logger.debug("");
	}
}
