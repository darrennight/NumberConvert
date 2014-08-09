package com.zhouquan;
public class Chinese
    {
        public String returnResult(long num)
        {
            String numStr = null ;
            //��Ҫ�����ǰ������ַ������շָ�Ϊ�ĸ�һ���ĸ�һ��ģ�����Ĳ��ܡ�
            if (numStr.length() > 8 & numStr.length() < 16)
            {
                //����һ�����飬�洢�����������ָ�����ַ�����Ȼ�����εݹ���á�
                //������ȫ�󣬵õ��ܵĴ�д�ַ�����
                String[] firstSplit = new String[2];
                firstSplit[0] = numStr.substring(0, numStr.length() - 8);
                firstSplit[1] = numStr.substring(numStr.length() - 8, 8);
                String result1 = getString(firstSplit[0]) + "�|";
                String result2 = getString(firstSplit[1]);
                return result1 + result2;
            }
            else
            {
                return getString(numStr);
            }
        }
            //����һ�εݹ���ã��õ�������λ���ֵĴ����ִ�
        public String getString(String str)
        {
            if (str.length() > 4)
            {
                String[] secondSplit = new String[2];
                secondSplit[0] = str.substring(0, str.length() - 4);
                secondSplit[1] = str.substring(str.length() - 4, 4);
                String result1 = getRe(secondSplit[0]);
                String result2 = getRe(secondSplit[1]);
                //ȷ���Ƿ�ӡ�����
                if (!secondSplit[0].equals("0000"))
                {
                    result1 += "�f";
                }
                return result1 + result2;
            }
            else
            {
                return getRe(str);
            }
        }
        int[] value = { 1000, 100, 10 };
        //����λ�����ڵ��ַ�������Ϊ��ȷ�Ĵ�д�ƺ� ����1234 ���أ�һǧ������ʮ��
        public String getRe(String doWith)
        {
            char[] number = doWith.toCharArray();
            int length = number.length;
            String re = "";
            for (int i = 0; i < length; i++)
            {
                switch (number[i])
                {
                    case '0':
                        if (re.endsWith("��"))
                        {
                            re += "";
                        }
                        else
                        {
                            re += "��";
                        }
                        break;
                    case '1':
                        re += "Ҽ";
                        break;
                    case '2':
                        re += "��";
                        break;
                    case '3':
                        re += "��";
                        break;
                    case '4':
                        re += "��";
                        break;
                    case '5':
                        re += "��";
                        break;
                    case '6':
                        re += "½";
                        break;
                    case '7':
                        re += "��";
                        break;
                    case '8':
                        re += "��";
                        break;
                    case '9':
                        re += "��";
                        break;
                }
                int index = (int)Math.pow(10, length - i - 1);
                if (number[i] == '0')
                {
                    index = -1;
                }
                switch (index)
                {
                    case 1000:
                        re += "Ǫ";
                        break;
                    case 100:
                        re += "��";
                        break;
                    case 10:
                        re += "ʰ";
                        break;
                }
            }
            if (re.endsWith("��"))
            {
                re = re.substring(0, re.length() - 1);
            }
            return re;
        }
    }