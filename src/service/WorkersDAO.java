package service;

import java.util.List;

import entity.Workers;

public interface WorkersDAO {
	
	//���ֵ����Ա����
		public boolean addWorkers(Workers w);
		public String getWorkername();
		public List<Workers> queryAllWorkers();
}
