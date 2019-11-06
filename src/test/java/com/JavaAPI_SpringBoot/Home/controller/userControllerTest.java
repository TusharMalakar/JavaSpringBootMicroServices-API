package com.JavaAPI_SpringBoot.Home.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.JavaAPI_SpringBoot.Home.model.account;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(Parameterized.class)
public class userControllerTest {
	
	userController apiController = new userController();
	
	@BeforeClass // it will run only once before class execute 
	public static void beforeclass() {
		System.out.println("before class runs only once ");
	}
	@AfterClass // it will run only once before class execute 
	public static void afterclass() {
		System.out.println("after class runs only once ");
	}
	
	
//	@Before // it will run before every methods
//	public void welcome0() {
//		//testing welcome end-point
//		apiController.welcomePage();
//		System.out.println(apiController.welcomePage());
//	}
	
	
	@Test
	public void welcome() {
		//testing welcome end-point
		apiController.welcomePage();
		System.out.println(apiController.welcomePage());
	}
//	@After // it will run after every methods
//	public void welcome1() {
//		//testing welcome end-point
//		apiController.welcomePage();
//		System.out.println(apiController.welcomePage());
//	}
	
	
	
	@Test
	public void login_endpoint() {
		//testting login endpoint
		apiController.login_endpoint("testuser1", "any");
		System.out.println(apiController.login_endpoint("testuser1", "any"));
	}
	
	
	
	
	
	@Test
	public void create_account() {
		//testing create_account endpoint
		account Account = new account("testuser10","pass10");
		apiController.create_account(Account);
	}
	
	@Test
	public void update_user() {
		//testing update_user endpoint
		account Account = new account("testuser10","password");
		apiController.update_user(Account);
	}
	
	@Test
	public void delete_user() {
		//testting delete_user endpoint
		apiController.delete_user("username");
	}
	@Test
	public void delete_all_users() {
		//testting delete_all_users endpoint
		apiController.delete_all_users();
	}

}
