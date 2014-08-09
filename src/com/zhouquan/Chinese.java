package com.zhouquan;
public class Chinese
    {
        public String returnResult(long num)
        {
            String numStr = null ;
            //主要理念是把数字字符串最终分隔为四个一组四个一组的，不足的不管。
            if (numStr.length() > 8 & numStr.length() < 16)
            {
                //定义一个数组，存储整个字条串分隔后的字符串。然后两次递归调用。
                //调用完全后，得到总的大写字符串。
                String[] firstSplit = new String[2];
                firstSplit[0] = numStr.substring(0, numStr.length() - 8);
                firstSplit[1] = numStr.substring(numStr.length() - 8, 8);
                String result1 = getString(firstSplit[0]) + "億";
                String result2 = getString(firstSplit[1]);
                return result1 + result2;
            }
            else
            {
                return getString(numStr);
            }
        }
            //进行一次递归调用，得到两组四位数字的大字字串
        public String getString(String str)
        {
            if (str.length() > 4)
            {
                String[] secondSplit = new String[2];
                secondSplit[0] = str.substring(0, str.length() - 4);
                secondSplit[1] = str.substring(str.length() - 4, 4);
                String result1 = getRe(secondSplit[0]);
                String result2 = getRe(secondSplit[1]);
                //确定是否加“万”字
                if (!secondSplit[0].equals("0000"))
                {
                    result1 += "萬";
                }
                return result1 + result2;
            }
            else
            {
                return getRe(str);
            }
        }
        int[] value = { 1000, 100, 10 };
        //将四位数以内的字符串返回为正确的大写称呼 比如1234 返回：一千二百三十四
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
                        if (re.endsWith("零"))
                        {
                            re += "";
                        }
                        else
                        {
                            re += "零";
                        }
                        break;
                    case '1':
                        re += "壹";
                        break;
                    case '2':
                        re += "贰";
                        break;
                    case '3':
                        re += "叁";
                        break;
                    case '4':
                        re += "肆";
                        break;
                    case '5':
                        re += "伍";
                        break;
                    case '6':
                        re += "陆";
                        break;
                    case '7':
                        re += "柒";
                        break;
                    case '8':
                        re += "捌";
                        break;
                    case '9':
                        re += "玖";
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
                        re += "仟";
                        break;
                    case 100:
                        re += "佰";
                        break;
                    case 10:
                        re += "拾";
                        break;
                }
            }
            if (re.endsWith("零"))
            {
                re = re.substring(0, re.length() - 1);
            }
            return re;
        }
    }