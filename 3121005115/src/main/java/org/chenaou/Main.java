package org.chenaou;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        if (args.length==1){
            if (args[0].equals("help")){
                System.out.println("java -jar Check.jar [源文件] [疑似抄袭文件] [输出文件]");
                System.out.println("文件均采用绝对路径");
                return;
            }
        }
        if (args.length != 3) {
            System.out.println("参数错误！");
            return;
        }

        LinkedList<String> strings=new LinkedList<>();//用于存储从源文件读取的字符串

        Count count=new Count();//计数器

        //读如文件
        FileReader file1,file2;
        //输出文件
        File file3;
        try {
            file1=new FileReader(args[0]);
            file2=new FileReader(args[1]);
            file3=new File(args[2]);

        } catch (FileNotFoundException e) {
            System.out.println("有文件不存在");
            return;
        }
        if (Count.isBigFile(new File(args[0]))||Count.isBigFile(new File(args[1]))){
            System.out.println("文件可能过大");
            return;
        }
        //扫描文件
        Scanner scannerFile1=new Scanner(file1);
        Scanner scannerFile2=new Scanner(file2);

        //空文件直接得出结果，查重率为零
        if (!scannerFile1.hasNext()||!scannerFile2.hasNext()){
            writeCompute(startTime, count, file3);
            return;
        } else {
            strings.add(scannerFile1.nextLine());
        }
        //正常读取
        while (scannerFile2.hasNext()){
            String tmp=scannerFile2.next();
            StringSim.compare(strings,tmp,count);
            if (!scannerFile1.hasNext()&&!scannerFile2.hasNext()){//源文件读取完毕，但需要扩展
                writeCompute(startTime, count, file3);
                return;
            }
            else if (scannerFile1.hasNext()){
                if (strings.size()>=3){
                    strings.removeFirst();
                }
                strings.add(scannerFile1.next());
            }


            //二次查重
            for (String str:StringSim.map.keySet()){
                StringSim.compare(strings,str,count);
            }

            //清理数据
            StringSim.mapClear(StringSim.map);
        }

        //读取完毕
        count.writeResult(file3);
        double result= count.result*100;
        System.out.printf("查重结束，查重率为：%.2f",result);
        System.out.println("%");
        scannerFile1.close();
        scannerFile2.close();

        long endTime=System.currentTimeMillis();

        long useTime=endTime-startTime;

        System.out.printf("本次查重用时：%dms\n",useTime);




    }

    public static void writeCompute(long startTime, Count count, File file3) {
        count.writeResult(file3);
        double result= count.result*100;

        System.out.printf("查重结束，查重率为：%.2f",result);
        System.out.println("%");

        long endTime=System.currentTimeMillis();
        long useTime=endTime-startTime;
        System.out.printf("本次查重用时：%dms\n",useTime);
    }

}