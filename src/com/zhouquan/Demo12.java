package com.zhouquan;
public class Demo12 {

	public static String convert(int money){
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
		
		
		return sb.reverse().toString();
		
	}
	