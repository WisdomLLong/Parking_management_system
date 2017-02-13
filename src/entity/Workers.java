package entity;

import java.util.Date;

//”√ªß¿‡
public class Workers {
	
	private int wid;
	private String workername;
	private Date workerintime;
	private Date workerouttime;
	
	public Workers()
	{
		
	}
		

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getWorkername() {
		return workername;
	}

	public void setWorkername(String workername) {
		this.workername = workername;
	}


	public Date getWorkerintime() {
		return workerintime;
	}


	public void setWorkerintime(Date workerintime) {
		this.workerintime = workerintime;
	}


	public Date getWorkerouttime() {
		return workerouttime;
	}


	public void setWorkerouttime(Date workerouttime) {
		this.workerouttime = workerouttime;
	}
	
	
			
}
