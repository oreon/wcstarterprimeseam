package mygrp.action.test;

public class OneTest {

	public static void main(String[] args) {
		String qry =  String.format(" SELECT %1 FROM %2 %3 ", "e","p" , "e");
		System.out.println(qry);

	}

}
