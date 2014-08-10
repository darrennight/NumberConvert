/**
 * Demo.java V1.0 2014-8-8 ����9:13:37
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
		//����Ҽ���������������顢½���⡢�ơ�����ʰ���ۡ�Ǫ���f
		char[] ch1 = new char[]{'��','Ҽ','��','��','��','��','½','��','��'};
		char[] ch2 = new char[]{'Ԫ','ʰ','��','Ǫ','�f','ʰ','��','Ǫ','��','ʰ','��','Ǫ'};
		
		int index = 0;
		int weight = 0;
		
		int count = money;
		StringBuffer sb = new StringBuffer();
		sb.append(ch2[0]);
		while(count!=0){
			index = count % 10;
			//��һ�β�����ӵ�λ
			if(index != 0 && weight !=0){
				sb.append(ch2[weight]);  //��ӵ�λ
			}
			sb.append(ch1[index]);  //������ֵ��ַ���ת��
			count = count / 10;
			weight++;
		}
		
		
		
		return sb.reverse().toString();
		
	}
	
	
			/**
			* ����������
			*
			* �����ˣ�ZHOUQUAN 
			* <p>�������� ��2014-8-9 ����7:06:52</p>
			*
			* @param money
			* @return
			*
			* <p>�޸���ʷ ��(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)</p>
			*/
	public static String convert2(int money){
		//����Ҽ���������������顢½���⡢�ơ�����ʰ���ۡ�Ǫ���f
		char[] ch1 = new char[]{'��','Ҽ','��','��','��','��','½','��','��'};
		char[] ch2 = new char[]{'Ԫ','ʰ','��','Ǫ','�f','ʰ','��','Ǫ','��','ʰ','��','Ǫ'};
		
		int index = 0;
		int weight = 0;
		
		int count = money;
		StringBuffer sb = new StringBuffer();
		while(count!=0){
			index = count % 10;
			sb.append(ch2[weight]);  //��ӵ�λ
			sb.append(ch1[index]);  //������ֵ��ַ���ת��
			count = count / 10;
			weight++;
		}
		
		//���ַ������д���ʹ֮�����˵�ϰ��
		StringBuffer result = new StringBuffer();
		result = sb.reverse();
		int i = 0;
		while(i < result.length()){
			int j = i + result.substring(i).indexOf('��');
			if(j<i)
				break;
			else{
				//�˴���switch������������䣬ʹ����Ľṹ���ӵ�����
				char nextch = result.charAt(j+1);
				switch(nextch)
				{
				case 'ʰ':
				case '��':
				case 'Ǫ':
					if(result.charAt(j+2)!='��'){
						result.deleteCharAt(j+1);//ɾ����λ
						i=j+1; //ָ����ǰ��һλ
					}else{
						result.delete(j, j+2); //ɾ����͵�λ
						i=j; //ָ�벻��
					}
					break;
				case '�f':
					if(result.charAt(j-1)!='��'){
						result.deleteCharAt(j);  //ɾ����
						i=j+1;
					}else{
						result.delete(j, j+2);//ɾ����͵�λ
						i=j;
					}
					break;
				case 'Ԫ':
					result.deleteCharAt(j); 
					break;
				}
			} 
		}
		return result.toString();
	}
	
	public static String convert3(double money){
		//����Ҽ���������������顢½���⡢�ơ�����ʰ���ۡ�Ǫ���f
		char[] ch1 = new char[]{'��','Ҽ','��','��','��','��','½','��','��'};
		char[] ch2 = new char[]{'��','��','Ԫ','ʰ','��','Ǫ','�f','ʰ','��','Ǫ','��','ʰ','��','Ǫ'};
		int index = 0;
		int weight = 0;
		int count = (int) (money*100);
		StringBuffer sb = new StringBuffer();
		while(count!=0){
			index = count % 10;
			sb.append(ch2[weight]);  //��ӵ�λ
			sb.append(ch1[index]);  //������ֵ��ַ���ת��
			count = count / 10;
			weight++;
		}
		
		//���ַ������д���ʹ֮�����˵�ϰ��
		StringBuffer result = new StringBuffer();
		result = sb.reverse();
		int i = 0;
		while(i < result.length()){
			int j = i + result.substring(i).indexOf('��');
			if(j<i)
				break;  //˵��������������������
			else{
				char nextch = result.charAt(j+1);
				switch(nextch)
				{
				case 'ʰ':
				case '��':
				case 'Ǫ':
					if(result.charAt(j+2)!='��'){
						result.deleteCharAt(j+1);//ɾ����λ
						i=j+1;
					}else{
						result.delete(j, j+2); //ɾ����͵�λ
						i=j;
					}
					break;
				case '�f':
					if(result.charAt(j-1)!='��'){
						result.deleteCharAt(j);  //ɾ����
						i=j+1;
					}else{
						result.delete(j, j+2);//ɾ����͵�λ
						i=j;
					}
					break;
				case 'Ԫ':
					result.deleteCharAt(j); 
					break;
				case '��':
					result.deleteCharAt(j+1);//ɾ����λ
					i=j+1;
					break;
				case '��':
					if(result.charAt(j-1)!='��')
						result.append('��');
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
		//����Ҽ���������������顢½���⡢�ơ�����ʰ���ۡ�Ǫ���f
		char[] ch1 = new char[]{'��','Ҽ','��','��','��','��','½','��','��'};
		char[] ch2 = new char[]{'��','��','Ԫ','ʰ','��','Ǫ','�f','ʰ','��','Ǫ',
								'��','ʰ','��','Ǫ','�f','ʰ','��','Ǫ','��'};
		int index = 0;
		int weight = 0;
		long count = (long) (money*100);
		StringBuffer sb = new StringBuffer();
		while(count!=0){
			index = (int) (count % 10);
//			System.out.println(index);
			sb.append(ch2[weight]);  //��ӵ�λ
			sb.append(ch1[index]);  //������ֵ��ַ���ת��
			count = count / 10;
			weight++;
		}
		
		//���ַ������д���ʹ֮�����˵�ϰ��
		StringBuffer result = new StringBuffer();
		result = sb.reverse();
		//2000 0000 0401.0012
//		System.out.println(result.toString());
		int i = 0;
		while(i < result.length()){
			int j = i + result.substring(i).indexOf('��');
			if(j<i)
				break;  //˵��������������������
			else{
				char nextch = result.charAt(j+1);
				switch(nextch)
				{
				case 'ʰ':
				case '��':
				case 'Ǫ':
					if(result.charAt(j+2)!='��'){
						result.deleteCharAt(j+1);//ɾ����λ
						i=j+1;
					}else{
						result.delete(j, j+2); //ɾ����͵�λ
						i=j;
					}
					break;
				case '�f':
					if(result.charAt(j-1)!='��'){
						result.deleteCharAt(j);  //ɾ����
						i=j+1;
					}else{
						result.delete(j, j+2);//ɾ����͵�λ
						i=j;
					}
					break;
				case '��':
						result.deleteCharAt(j);  //ɾ����
						i=j+1;
					break;
				case 'Ԫ':
					result.deleteCharAt(j); 
					break;
				case '��':
					result.deleteCharAt(j+1);//ɾ����λ
					i=j+1;
					break;
				case '��':
					if(result.charAt(j-1)!='��'){
						result.delete(j-1, j+2);
						result.append('��');
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
////			System.out.println("��" + i + "����" + test[i] + str1);
//			System.out.println("��" + i + "����" + test[i] +str2);
			
//			str3 = Demo1234.convert4(40000000000000000.1244);
//			System.out.println("��" + i + "����" + test2[i] +str3);
		}
		//ע��java long���������Ϊ922 3372 0368 5477 5808�����˴�ȴ������double���ͱ�ʾ�ķ�Χ
		str3 = MyConvert.convert4(40000000000000000.1244);
		System.out.println(str3);
		System.out.println();
	}
	
}


/*if(nextch == 'ʰ' || nextch == '��' || nextch == 'Ǫ'){
if(result.charAt(j+2)!='��'){
	result.deleteCharAt(j+1);//ɾ����λ
	i=j+1;
}else{
	result.delete(j, j+2); //ɾ����͵�λ
	i=j;
}
}else{
if(nextch == '�f'){
	if(result.charAt(j-1)!='��'){
		result.deleteCharAt(j);  //ɾ����
		i=j+1;
	}else{
		result.delete(j, j+2);//ɾ����͵�λ
		i=j;
	}
		
}else{
	result.deleteCharAt(j); //?????
	break;
}

}*/