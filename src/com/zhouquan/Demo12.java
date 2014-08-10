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
		
		
		return sb.reverse().toString();
		
	}
	