package service;

import java.util.List;

import entity.Workers;

public interface WorkersDAO {
	
	//添加值班人员资料
		public boolean addWorkers(Workers w);
		public String getWorkername();
		public List<Workers> queryAllWorkers();
}
