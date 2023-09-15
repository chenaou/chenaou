package org.chenaou;

import java.util.HashMap;
import java.util.LinkedList;

public class StringSim {
    public static HashMap<String,Integer> map=new HashMap<>();//用于存储查重率低的字符串
    //Integer是查询次数

    public static void compare(LinkedList<String> strings, String other, Count count){
        double original=count.repet;
        int all=count.all;
        count.all+=other.length();
        if (other.isEmpty()){
            return;
        }
        StringBuilder tmp=new StringBuilder();
        for(String str:strings){
            tmp.append(str);
        }

        String re=tmp.toString();
        charCount(re,other,count);



        if(count.repet - original / other.length()<0.3){
            if (StringSim.map.containsKey(other)){
                map.put(other,map.get(other)+1);
            }
            else {
                map.put(other,1);
            }
            count.repet=original;
            count.all=all;
        }
    }
    public static void charCount(String re,String other,Count count){
        int index=0;
        for (int i = 0; i < other.length(); i++) {
            for (int j = index; j < re.length(); j++) {
                if (other.charAt(i)==re.charAt(j)){
                    count.repet= count.repet+Count.w;
                    Count.w=0.95;
                    index=j+1;
                    break;
                }else {
                    Count.w=0.05;
                }
            }
        }
    }

    public static void mapClear(HashMap<String,Integer> hashMap){
        LinkedList<String> list = new LinkedList<>(hashMap.keySet());
        for (String str:list) {
            if (hashMap.get(str)>=5){
                hashMap.remove(str);
            }
        }
    }
}
