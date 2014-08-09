/**
		* Demo1234Test.java V1.0 2014-8-9 ÏÂÎç7:49:30
		*
		* Copyright Talkweb Information System Co. ,Ltd. All rights reserved.
		*
		* Modification history(By Time Reason):
		*
		* Description:
		*/

		package com.zhouquan;

import static org.junit.Assert.*;

import org.junit.Test;

		public class Demo1234Test {

	@Test
	public void testConvert2() {
		String str1 = new String();
		String str2 = new String();
		int[] test = new int[]{200000401,204060801,201254012,201204012,234233343,1200000000};
		assertEquals("Ò¼Ê°·¡ÒÚÔª", Demo1234.convert2(1200000000));
		assertEquals("·¡ÒÚÁãËÁ°ÛÁãÒ¼Ôª", Demo1234.convert2(200000401));
		assertEquals("·¡ÒÚÁãËÁ°ÛÁãÂ½ÈfÁã°Æ°ÛÁãÒ¼Ôª", Demo1234.convert2(204060801));
		assertEquals("·¡ÒÚÁãÒ¼°Û·¡Ê°ÎéÈfËÁÇªÁãÒ¼Ê°·¡Ôª", Demo1234.convert2(201254012));
		assertEquals("·¡ÒÚÁãÒ¼°Û·¡Ê°ÎéÈfËÁÇªÁãÒ¼Ê°·¡Ôª", Demo1234.convert2(20125212));
		
	}

}
