package com.practice;

import java.lang.reflect.Method;

public class A {

	private A() {

	}
	
	public static A method1() {

		A a = new A();
		return a;
	}
	
	public void method2() {

		System.out.println("method 2");
	}
	
	public void method3() {

		System.out.println("Method 3");
	}
}
