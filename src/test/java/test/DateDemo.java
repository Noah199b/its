package test;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateDemo {
	 @Test
	 public void test001() {
		 System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
	 }
	 @Test
	 public void test002() {
		 //          012345678901234567
		 String str="resDetail0.do?id=";
		 System.out.println(str.indexOf("?id="));
		 System.out.println(Integer.valueOf(str.substring(str.indexOf("?id=")+4)));
	 }
	 @Test
	 public void test003() {
		 float a=333.3333333333333333f;
		 System.out.println();
	 }
	 
}
