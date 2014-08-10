package com.zhouquan;
public class Demo1234 {

	public static String convert(int money){
		//：“壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、萬
		char[] ch1 = new char[]{'零','壹','贰','叁','肆','伍','陆','柒','捌'};
		char[] ch2 = new char[]{'元','拾','佰','仟','萬','拾','佰','仟','亿','拾','佰','仟'};
		
		int index = 0;
		int weight = 0;
		
		int count = money;
		StringBuffer sb = new StringBuffer();
		sb.append(ch2[0]);
		while(count!=0){
			index = count % 10;
			//第一次不需添加单位
			if(index != 0 && weight !=0){
				sb.append(ch2[weight]);  //添加单位
			}
			sb.append(ch1[index]);  //完成数字到字符的转换
			count = count / 10;
			weight++;
		}
		
		
		
		return sb.reverse().toString();
		
	}
	