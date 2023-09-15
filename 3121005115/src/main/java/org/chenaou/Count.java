package org.chenaou;

import java.io.*;

public class Count {
    public static double w=0.95;//权重，在0-1之间
    double repet;//疑似重复的字符
    int all;//总字符数
    double result=0.0;
    public Count() {
        repet=0;
        all=0;
    }

    public void writeResult(File file) {
        this.computeResult();
        String resu=String.format("文件查重率：%.2f",this.result);
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            System.exit(0);
        }
        try {
            fos.write(resu.getBytes());
        } catch (IOException e) {
            System.out.println("写入失败");
            System.exit(0);
        }


    }
    public static boolean isBigFile(File file){
        long len;
        len=file.length();
        return len / (1048576) > 3;
    }

    public void computeResult(){
        if (all==0){
            result=0.0;
            return;
        }
        result=repet/all;
    }
}
