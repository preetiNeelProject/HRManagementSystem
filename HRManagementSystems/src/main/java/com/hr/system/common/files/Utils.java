package com.hr.system.common.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.system.employee.repository.EmployeeRepository;


@Controller
public class Utils
{
	@Autowired
	private Keys keys;
	
	@Autowired
	EmployeeRepository emp;
	
	public static String getDate()
	{
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    	Date today = Calendar.getInstance().getTime();
    	return df.format(today);
	}
	
	@RequestMapping(value = "/attendance/getEmployeeDetails/{employeeId}", method = RequestMethod.GET)
	public void findEmployeeId(@PathVariable Long employeeId)
	{
		System.out.println(emp.findByEmployeeId(employeeId));
	}
	
	private  String getYear()
	{
		String year=null;
		year=getDate().substring(getDate().lastIndexOf("/")+1);
		return year;
	}
	
	private  String getMonth()
	{
		String mon=getDate().substring(getDate().indexOf(".")+1,getDate().lastIndexOf("."));
		if(mon.equals("01"))
			return "Jan";
		else if(mon.equals("02"))
			return "Feb";
		else if(mon.equals("03"))
			return "Mar";
		else if(mon.equals("04"))
			return "Apr";
		else if(mon.equals("05"))
			return "May";
		else if(mon.equals("06"))
			return "June";
		else if(mon.equals("07"))
			return "July";
		else if(mon.equals("08"))
			return "Aug";
		else if(mon.equals("09"))
			return "Sep";
		else if(mon.equals("10"))
			return "Oct";
		else if(mon.equals("11"))
			return "Nov";
		else
			return "Dec";
	}
	
	public static String getTime()
	{
		DateFormat df = new SimpleDateFormat("hh:mm:ss");
    	Date today = Calendar.getInstance().getTime();
    	return df.format(today);
	}
	
	public static String getMacAddress()
	{
		String mac=null;
		try
		{
			InetAddress ip=InetAddress.getLocalHost();
			NetworkInterface network=NetworkInterface.getByInetAddress(ip);
			byte[] m=network.getHardwareAddress();
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<m.length;i++)
				sb.append(String.format("%02X%s",m[i],(i<m.length-1) ? "-" : ""));
			mac=sb.toString();
		}
		catch(Exception e)
		{mac="N.A.";}
		return mac;
	}
	
	public static String getDeviceName()
	{
		return System.getProperty("user.name");
	}
	
	public String[] getHeader(String header)
	{
		if (header.equals("timesheet"))
			return keys.getTimesheetHeader();
		else if (header.equals("employeeList"))
			return keys.getEmployeeListHeader();
		return null;
	}
	
	public static void downloadFile(HttpServletRequest req,HttpServletResponse response,String name,String fileLocation)
	{
		
		File file=null;
		BufferedInputStream bin=null;
		FileInputStream fin=null;
		ServletOutputStream sos=null;
		try
		{
			file=new File(fileLocation+name+".pdf");
			fin=new FileInputStream(file);
			bin=new BufferedInputStream(fin);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition","Attachment; filename=\""+name+"\"");
			response.setHeader("Pragma","public");
			response.setHeader("Cache-Control","max-age=-1");
			response.setContentLengthLong((long)file.length());
			sos=response.getOutputStream();
			byte[]  buff=new byte[8192];
			int numChars;
			while((numChars=bin.read(buff,0,buff.length))!=-1)
				sos.write(buff,0,numChars);
		}
		catch(Exception e)
		{e.printStackTrace();}
		finally
		{
			try
			{
				if(bin!=null)
					bin.close();
				if(fin!=null)
					fin.close();
				if(sos!=null)
					sos.flush();
				sos.close();
			}
			catch(Exception e)
			{e.printStackTrace();}
		}
		
		
	}
	
	
}