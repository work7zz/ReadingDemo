package com.example.readingdemo.something;

/**
 * Created by yuzhiqi on 2019/03/03
 *
 * @author 于治麒 yuzhiqi@bytedance.com
 */
public class Translation {
    private int status;
    private content content;
    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }


    public String getResult(){
        return content.out;
    }

    public String getContent(){
        return  "\n\tstatus:" + status +
                "\n\tfrom:" + content.from +
                "\n\tto:" + content.to +
                "\n\tout:" + content.out;

    }
}
