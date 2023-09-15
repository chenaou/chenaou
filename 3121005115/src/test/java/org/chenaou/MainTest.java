package org.chenaou;


import org.junit.Test;

public class MainTest {
    static String fileAddr="/home/se/testDir/text/orig.txt";//源文件
    static String[] copyFiles={
            "/home/se/testDir/text/orig_0.8_add.txt",
            "/home/se/testDir/text/orig_0.8_del.txt",
            "/home/se/testDir/text/orig_0.8_dis_1.txt",
            "/home/se/testDir/text/orig_0.8_dis_10.txt",
            "/home/se/testDir/text/orig_0.8_dis_15.txt",
    };//疑似抄袭文件

    static String outPutFile="/home/se/testDir/text/out.txt";//输出文件


    //前5组为普通测试
    @Test
    public void mainTestDemo1(){
        String str=copyFiles[0];
        System.out.println("疑似文件："+str);
        System.out.println("源文件："+fileAddr);
        System.out.println("测试结果：");
        Main.main(new String[]{fileAddr,str,outPutFile});
        System.out.println("\n\n");
    }
    @Test
    public void mainTestDemo2(){
        String str=copyFiles[1];
        System.out.println("疑似文件："+str);
        System.out.println("源文件："+fileAddr);
        System.out.println("测试结果：");
        Main.main(new String[]{fileAddr,str,outPutFile});
        System.out.println("\n\n");
    }
    @Test
    public void mainTestDemo3(){
        String str=copyFiles[2];
        System.out.println("疑似文件："+str);
        System.out.println("源文件："+fileAddr);
        System.out.println("测试结果：");
        Main.main(new String[]{fileAddr,str,outPutFile});
        System.out.println("\n\n");
    }
    @Test
    public void mainTestDemo4(){
        String str=copyFiles[3];
        System.out.println("疑似文件："+str);
        System.out.println("源文件："+fileAddr);
        System.out.println("测试结果：");
        Main.main(new String[]{fileAddr,str,outPutFile});
        System.out.println("\n\n");
    }
    @Test
    public void mainTestDemo5(){
        String str=copyFiles[4];
        System.out.println("疑似文件："+str);
        System.out.println("源文件："+fileAddr);
        System.out.println("测试结果：");
        Main.main(new String[]{fileAddr,str,outPutFile});
        System.out.println("\n\n");
    }
    //以下为异常处理测试
    //6.帮助测试
    @Test
    public void helpTest(){
        System.out.println("java -jar main.jar help");
        Main.main(new String[]{"help"});
        System.out.println("\n\n");
    }
    //7.文件无法找到
    @Test
    public void fileNotFoundTest(){
        System.out.println("文件找不到时：");
        Main.main(new String[]{fileAddr,"12345",outPutFile});
        System.out.println("\n\n");
    }
    //8.参数传递有误
    @Test
    public void commondTest(){
        System.out.println("参数错误时：");
        Main.main(new String[]{"666"});
        System.out.println("\n\n");
    }
    static String shortFile="/home/se/testDir/text/short_file.txt";
    static String shortCopyFile="/home/se/testDir/text/short_file2.txt";
    //9.短文本
    @Test
    public void shortTest(){
        System.out.println("文本长度很短时:");
        Main.main(new String[]{shortFile,shortCopyFile,outPutFile});
        System.out.println("短文本依旧可以查重");
        System.out.println("\n\n");
    }
    static String bigFile="/home/se/Picture/pog.png";
    //10.大文件处理
    @Test
    public void bigFileTest(){
        System.out.println("大文件处理");
        Main.main(new String[]{fileAddr,bigFile,outPutFile});
        System.out.println("\n\n");
    }

}
