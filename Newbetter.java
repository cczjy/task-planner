
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Newbetter {
private int priority;//
private String name;//
private int resttime;//
private int needtime;//
private double counttime;//
private String details;//
private String deadline;//

public Newbetter(int priority, String name, int resttime, int needtime, double counttime, String details, String deadline) {
    this.priority = priority;
    this.name = name;
    this.resttime = resttime;
    this.needtime = needtime;
    this.counttime = counttime;
    this.details = details;
    this.deadline = deadline;
}
public Newbetter() {
	
}
public int getPriority() {
    return priority;
}
public void setPriority(int priority) {
    this.priority = priority;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public int getResttime() {
    return resttime;
}

public void setResttime(int resttime) {
    this.resttime = resttime;
}
public int getNeedtime() {
    return needtime;
}
public void setNeedtime(int needtime) {
    this.needtime = needtime;
}
public double getCounttime() {
    return counttime;
}
public void setCounttime(double counttime) {
    this.counttime = counttime;
}
public String getDetails() {
    return details;
}
public void setDetails(String details) {
    this.details = details;
}
public String getDeadline() {
    return deadline;
}
public void setDeadline(String deadline) {
    this.deadline = deadline;
}
public String [] wordsReader(String file){
    String myfile = file;
    ArrayList <String> lines = new ArrayList <String>();
    try{
        BufferedReader abc = new BufferedReader(new FileReader(myfile));

        String line;
        while((line = abc.readLine()) != null) {
            if(line.length() > 8){
                lines.add(line);
            }
        }
        abc.close();
    }
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            myfile + "'");                
    }
    catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + myfile + "'");                  
    }
    return lines.toArray(new String[]{});
}
public String tostring() {
	return "DEADLINE: "+this.deadline+"\n"+"TITLE: "+this.name+"\n"+"PRIORITY: "+this.priority+"\n"+"DETAILS: "+this.details+"\n"+"DURATION: "+this.needtime+"DAYS"+"\n"+"------------------------------";
}





}
