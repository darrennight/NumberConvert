/**
 * Demo.java V1.0 2014-8-8 下午9:13:37
 *
 * Copyright Talkweb Information System Co. ,Ltd. All rights reserved.
 *
 * Modification history(By Time Reason):
 *
 * Description:
 */
package com.zhouquan.app;
public class MyConvert{

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
	
	
			/**
			* 功能描述：
			*
			* 创建人：ZHOUQUAN 
			* <p>创建日期 ：2014-8-9 下午7:06:52</p>
			*
			* @param money
			* @return
			*
			* <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
			*/
	public static String convert2(int money){
		//：“壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、萬
		char[] ch1 = new char[]{'零','壹','贰','叁','肆','伍','陆','柒','捌'};
		char[] ch2 = new char[]{'元','拾','佰','仟','萬','拾','佰','仟','亿','拾','佰','仟'};
		
		int index = 0;
		int weight = 0;
		
		int count = money;
		StringBuffer sb = new StringBuffer();
		while(count!=0){
			index = count % 10;
			sb.append(ch2[weight]);  //添加单位
			sb.append(ch1[index]);  //完成数字到字符的转换
			count = count / 10;
			weight++;
		}
		
		//对字符串进行处理，使之符合人的习惯
		StringBuffer result = new StringBuffer();
		result = sb.reverse();
		int i = 0;
		while(i < result.length()){
			int j = i + result.substring(i).indexOf('零');
			if(j<i)
				break;
			else{
				//此处用switch语句代替条件语句，使代码的结构更加的清晰
				char nextch = result.charAt(j+1);
				switch(nextch)
				{
				case '拾':
				case '佰':
				case '仟':
					if(result.charAt(j+2)!='零'){
						result.deleteCharAt(j+1);//删除单位
						i=j+1; //指针向前移一位
					}else{
						result.delete(j, j+2); //删除零和单位
						i=j; //指针不变
					}
					break;
				case '萬':
					if(result.charAt(j-1)!='亿'){
						result.deleteCharAt(j);  //删除零
						i=j+1;
					}else{
						result.delete(j, j+2);//删除零和单位
						i=j;
					}
					break;
				case '元':
					result.deleteCharAt(j); 
					break;
				}
			} 
		}
		return result.toString();
	}
	
	public static String convert3(double money){
		//：“壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、萬
		char[] ch1 = new char[]{'零','壹','贰','叁','肆','伍','陆','柒','捌'};
		char[] ch2 = new char[]{'分','角','元','拾','佰','仟','萬','拾','佰','仟','亿','拾','佰','仟'};
		int index = 0;
		int weight = 0;
		int count = (int) (money*100);
		StringBuffer sb = new StringBuffer();
		while(count!=0){
			index = count % 10;
			sb.append(ch2[weight]);  //添加单位
			sb.append(ch1[index]);  //完成数字到字符的转换
			count = count / 10;
			weight++;
		}
		
		//对字符串进行处理，使之符合人的习惯
		StringBuffer result = new StringBuffer();
		result = sb.reverse();
		int i = 0;
		while(i < result.length()){
			int j = i + result.substring(i).indexOf('零');
			if(j<i)
				break;  //说明不存在零这个特殊情况
			else{
				char nextch = result.charAt(j+1);
				switch(nextch)
				{
				case '拾':
				case '佰':
				case '仟':
					if(result.charAt(j+2)!='零'){
						result.deleteCharAt(j+1);//删除单位
						i=j+1;
					}else{
						result.delete(j, j+2); //删除零和单位
						i=j;
					}
					break;
				case '萬':
					if(result.charAt(j-1)!='亿'){
						result.deleteCharAt(j);  //删除零
						i=j+1;
					}else{
						result.delete(j, j+2);//删除零和单位
						i=j;
					}
					break;
				case '元':
					result.deleteCharAt(j); 
					break;
				case '角':
					result.deleteCharAt(j+1);//删除单位
					i=j+1;
					break;
				case '分':
					if(result.charAt(j-1)!='角')
						result.append('整');
					i=result.length();
					break;
				default:
				break;
					
				}
			} 
		}
		return result.toString();
	}
	
	public static String convert4(double money){
		//：“壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、萬
		char[] ch1 = new char[]{'零','壹','贰','叁','肆','伍','陆','柒','捌'};
		char[] ch2 = new char[]{'分','角','元','拾','佰','仟','萬','拾','佰','仟',
								'亿','拾','佰','仟','萬','拾','佰','仟','亿'};
		int index = 0;
		int weight = 0;
		long count = (long) (money*100);
		StringBuffer sb = new StringBuffer();
		while(count!=0){
			index = (int) (count % 10);
//			System.out.println(index);
			sb.append(ch2[weight]);  //添加单位
			sb.append(ch1[index]);  //完成数字到字符的转换
			count = count / 10;
			weight++;
		}
		
		//对字符串进行处理，使之符合人的习惯
		StringBuffer result = new StringBuffer();
		result = sb.reverse();
		//2000 0000 0401.0012
//		System.out.println(result.toString());
		int i = 0;
		while(i < result.length()){
			int j = i + result.substring(i).indexOf('零');
			if(j<i)
				break;  //说明不存在零这个特殊情况
			else{
				char nextch = result.charAt(j+1);
				switch(nextch)
				{
				case '拾':
				case '佰':
				case '仟':
					if(result.charAt(j+2)!='零'){
						result.deleteCharAt(j+1);//删除单位
						i=j+1;
					}else{
						result.delete(j, j+2); //删除零和单位
						i=j;
					}
					break;
				case '萬':
					if(result.charAt(j-1)!='亿'){
						result.deleteCharAt(j);  //删除零
						i=j+1;
					}else{
						result.delete(j, j+2);//删除零和单位
						i=j;
					}
					break;
				case '亿':
						result.deleteCharAt(j);  //删除零
						i=j+1;
					break;
				case '元':
					result.deleteCharAt(j); 
					break;
				case '角':
					result.deleteCharAt(j+1);//删除单位
					i=j+1;
					break;
				case '分':
					if(result.charAt(j-1)!='角'){
						result.delete(j-1, j+2);
						result.append('整');
					}
					i=result.length();
					break;
					
				}
			} 
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		String str1 = new String();
		String str2 = new String();
		String str3 = new String();
		//922 3372 0368 5477 5808
		int[] test = new int[]{200000401,204060801,201254012,201204012,234233343,1200000000};
		double[] test2 = new double[]{200000000401.0012,2041232330801.1023,
				2022300003012012.01254,40000000000000000.1244};
		for(int i = 0;i<test2.length;i++){
//			str1 = Demo1234.convert(test[i]);
//			str2 = Demo1234.convert2(test[i]);
////			System.out.println("第" + i + "个数" + test[i] + str1);
//			System.out.println("第" + i + "个数" + test[i] +str2);
			
//			str3 = Demo1234.convert4(40000000000000000.1244);
//			System.out.println("第" + i + "个数" + test2[i] +str3);
		}
		//注意java long的最大数据为922 3372 0368 5477 5808，但此处却超出了double类型表示的范围
		str3 = MyConvert.convert4(40000000000000000.1244);
		System.out.println(str3);
		System.out.println();
	}
	
}


/*if(nextch == '拾' || nextch == '佰' || nextch == '仟'){
if(result.charAt(j+2)!='零'){
	result.deleteCharAt(j+1);//删除单位
	i=j+1;
}else{
	result.delete(j, j+2); //删除零和单位
	i=j;
}
}else{
if(nextch == '萬'){
	if(result.charAt(j-1)!='亿'){
		result.deleteCharAt(j);  //删除零
		i=j+1;
	}else{
		result.delete(j, j+2);//删除零和单位
		i=j;
	}
		
}else{
	result.deleteCharAt(j); //?????
	break;
}

}*/