package com.it.utils;

public class JDBCTest {
	
	public static void main(String[] args) {
		try {
			System.out.println(JDBCUtils.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
