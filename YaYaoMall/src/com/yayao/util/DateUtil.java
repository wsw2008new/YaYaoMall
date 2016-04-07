package com.yayao.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 日期格式化类
 * @author yy
 *
 */
public class DateUtil {
	/**
	 * 格式化时间
	 * @return
	 */
	public static String getCurrentTime(){
	Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式
	String nowTime="";
	nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
	return nowTime;
	}
	
	/**
	 * 格式化时间
	 * @return
	 */
	public static String getOrdersTime(){
		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置显示格式
		String nowTime="";
		nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		return nowTime;
	}
	
	/** 
     * 时间戳转换成日期格式字符串 
     * @param seconds 精确到秒的字符串 
     * @param formatStr 
     * @return 
     */  
    public static String timeStamp2Date(String seconds,String format) {  
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
            return "";  
        }  
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";  
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        return sdf.format(new Date(Long.valueOf(seconds+"000")));  
    }  
    /** 
     * 日期格式字符串转换成时间戳 
     * @param date 字符串日期 
     * @param format 如：yyyy-MM-dd HH:mm:ss 
     * @return 
     */  
    public static String date2TimeStamp(String date_str,String format){  
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            return String.valueOf(sdf.parse(date_str).getTime()/1000);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    }  
      
    /** 
     * 取得当前时间戳（精确到秒） 
     * @return 
     */  
    public static String timeStamp(){  
        long time = System.currentTimeMillis();  
        String t = String.valueOf(time/1000);  
        return t;  
    }  
    /**
     * 获取精准时间格式存储数据库
     * @param args
     */
    public static Date getFormatCurrentTime(){  
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    	 String time=getCurrentTime();

    	 Timestamp time1 = null;
		try {
			time1 = new Timestamp(sdf.parse(time).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
    	return time1;  
    }  
    /**
     * 获取两日期之间的相隔天数
     * @param args
     * @throws ParseException 
     */
    public static Long getSeparatedTime() {  
    	String date01 = "2016-3-1 9:20:00";
    	String date02 = "2016-3-2 9:19:00";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date d1 = null;
    	Date d2 = null;
		try {
			d1 = sdf.parse(date01);
			d2 = sdf.parse(date02);
			System.out.println(d1);
			System.out.println(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	long daysBetween = (d2.getTime()-d1.getTime())/(3600*24*1000);//两日期之间相隔的天数 
    	return daysBetween;  
    }  
    /**
     * 获取从起始日期开始几天后的日期
     * @param args
     * @throws ParseException 
     */
    public static Date getFirstToTime(Date firstDate,long coupleDay) {  
    	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date lastDate = new Date(coupleDay*3600*24*1000+firstDate.getTime());//两日期之间相隔的天数 
    	return lastDate;  
    }  
	
    
    //  输出结果：  
    //  timeStamp=1417792627  
    //  date=2014-12-05 23:17:07  
    //  1417792627  
    //static HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    public static void main(String[] args) {  
    	System.out.println(getCurrentTime());
    	System.out.println(getOrdersTime());
    	String timeStamp = timeStamp();  
        System.out.println("timeStamp="+timeStamp);  
          
        String date = timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss");  
        System.out.println("date="+date);  
          
        String timeStamp2 = date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");  
        System.out.println(timeStamp2); 
        System.out.println(getFormatCurrentTime().toLocaleString());
      //  HttpSession session = request.getSession();
       // session.setAttribute("nieyue", "dsfsdfsdf");
        //String nieyue = (String) session.getAttribute("nieyue");
       // System.out.println(session); 
        System.out.println(getSeparatedTime());
        System.out.println(getFirstToTime(new Date(), 25).toLocaleString());
    }  
}
