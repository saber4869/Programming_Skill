package com.main;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test {

	  @Before//说明在测试函数执行之前会首先执行这个函数 @Before符号必须写
	    public void start() {
	        System.out.println("Code Start!");
	    }

	    @After//说明在测试函数执行之后会接着执行这个函数  @After符号必须写
	    public void end() {
	        System.out.println("Code End!");
	    }

	    // @Test : 表示这是一个测试用例，只有标识了改符号的函数才会被执行测试
	    @Test
	    public void testAdd() throws IOException {
	        String str = "abc";
	        System.out.println(str);
	        Main hello = new Main();
	        hello.main(null);
	    }

}
