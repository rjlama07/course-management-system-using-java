package Controller;

import java.util.Date;


public class Greet {
    public String getDate(String type){
        type=type.toLowerCase();
        Date date=new Date();
		String[] dateList=date.toString().split(" ", 6);
        String dateNow=dateList[0]+dateList[1]+dateList[2];
        String timeNow=dateList[3]+dateList[4]+dateList[5];
        if(type.equals("date"))
        {
            return dateNow;
        }
        else if(type.equals("time")){ 
            return timeNow.split(":", 4)[0];
        }
        else
        {
            return "Invalid paranthasis";
        }  
    }
    public String day(int time)
    {
        if(time>=5 && time<12)
        {
          return "Good Morning";
        }
        else if(time>=12 && time<17)
        {
            return "Good Afternoon";
        }
        else if(time>=17 && time<=19)
        {
        	return "Good Evening";
        }
        else {
            return "Hello";
        }
    }
    public String greetUser(String name)
    {
        Greet datetime=new Greet();
        int time=Integer.parseInt(datetime.getDate("time"));
        String greet= datetime.day(time);
        return greet+" "+name;
    }
    
}
