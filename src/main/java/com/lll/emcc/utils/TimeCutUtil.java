package com.lll.emcc.utils;


import org.junit.Test;

/**
 * 
 * @Description:TODO
 * @version 1.0
 * @since JDK1.8
 * @author  lele lu
 * @company 从控制器接收的字幕时间划分为秒，传递给html5播放器定位播放
 * @copyright (c) 2018 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2018年12月13日 下午2:34:52
 
 */
public class TimeCutUtil {
	/**
	 * 时间分割
	 * @param hours 字幕时间中的小时单位
	 * @param minutes 分钟单位
	 * @param second 秒
	 * @param seconds 需要发送给控制器的结果秒数
	 * 
	 */
	
	/**
	 * 分割开始时间
	 * @param startTime
	 * @return
	 */
	public static String timeCutStart(String startTime) {
		String hours;
		String minutes;
		String second;
		Integer seconds;
		startTime = startTime.trim();
		//时间格式  0:0:15,749划分为时分秒先通过split根据‘：’分割
		String[] split = startTime.split(":");
		hours = split[0];
		minutes = split[1];
		second = split[2];
		//分割秒取‘,’号前的
		String[] split2 = second.split(",");
		seconds = Integer.parseInt(hours)*3600+Integer.parseInt(minutes)*60
		+Integer.parseInt(split2[0])-10;
		return seconds.toString();
	}
	/**
	 * 分割结束时间
	 * @param endTime
	 * @return
	 */
	public static String timeCutEnd(String endTime) {
		String hours;
		String minutes;
		String second;
		Integer seconds;
		//时间格式  0:0:15,749划分为时分秒先通过split根据‘：’分割
		endTime = endTime.trim();
		String[] split = endTime.split(":");
		hours = split[0];
		minutes = split[1];
		second = split[2];
		//分割秒取‘,’号前的
		String[] split2 = second.split(",");
		seconds = Integer.parseInt(hours)*3600+Integer.parseInt(minutes)*60
		+Integer.parseInt(split2[0])+10;
		return seconds.toString();
	}
	@Test
	public void test() {
		TimeCutUtil tc = new TimeCutUtil();
		String timeCutStart = tc.timeCutStart("0:0:15,749");
		String timeCutEnd = tc.timeCutEnd("0:0:18,749");
		System.out.println(timeCutStart);
		System.out.println(timeCutEnd);
	}
}
