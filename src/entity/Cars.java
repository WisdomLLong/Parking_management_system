package entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

//≥µ¡æ¿‡
public class Cars {

	private String cid;
	private String cnum;
	private String name;
	private String cbrand;
	private String ctype;
	private Date ctime;
	private Date outtime;
	private String money;
	private String worker;
	
	public Cars()
	{
		
	}
		
	public Cars(String cid, String cnum, String name, String cbrand, String ctype, Date ctime ) {
		//super();
		this.cid = cid;
		this.cnum = cnum;
		this.name = name;
		this.cbrand = cbrand;
		this.ctype = ctype;
		this.ctime = ctime;
	}
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCbrand() {
		return cbrand;
	}

	public void setCbrand(String cbrand) {
		this.cbrand = cbrand;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}	
	
	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}
	
	public Date getOuttime() {
		return outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String toString()  
    {  
        return "[cid="+this.cid+",cnum="+this.cnum+",name="+this.name+",cbrand="+this.cbrand+",ctype="+this.ctype+",ctime="+this.ctime+"]";  
    }  
	
//	public String toString(){
//		return ToStringBuilder.reflectionToString(this);
//	}
	
}
