package action;
//瀛︾敓Action绫�

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import entity.Cars;
import entity.CarsSave;
import entity.Workers;
import service.CarsDAO;
import service.CarsSaveDAO;
import service.StudentsDAO;
import service.WorkersDAO;
import service.impl.CarsDAOImpl;
import service.impl.CarsSaveDAOImpl;
import service.impl.StudentsDAOImpl;
import service.impl.WorkersDAOImpl;

public class CarsAction extends SuperAction{

	private  static final long serialVersionUID = 1L;

	//查询车辆动作
	public String query()
	{
		CarsDAO sdao = new CarsDAOImpl();
		List<Cars> list = sdao.queryAllCars();
		//放进session中
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("cars_list",list);
		}
		return "query_success";
	}
	
	//查询车辆动作
		public String querysave()
		{
			CarsDAO sdao = new CarsDAOImpl();
			List<Cars> list = sdao.querysaveAllCars();
			//放进session中
//			System.out.println("目前为止是对的");
			if(list!=null&&list.size()>0)
			{
				session.setAttribute("carssave_list",list);
			}
			return "querysave_success";
		}

	//删除车辆动作
	public String delete()
	{
		double Howmuch = 0.25; 
		CarsSave carsave = new CarsSave();
		CarsSaveDAO csdao = new CarsSaveDAOImpl();
		
		CarsDAO cdao = new CarsDAOImpl();
		Cars car = cdao.queryCarsByCid(request.getParameter("cid"));
		//记录车辆的登出时间
		car.setOuttime(new Date());
		//计算费用
		long millis = (car.getOuttime()).getTime()-(car.getCtime()).getTime();
		long minute = TimeUnit.MILLISECONDS.toMinutes(millis);
		String carmoney = Double.toString(minute*Howmuch);
		System.out.println("这两车的费用是"+request.getParameter("cid"));
		//存储需要交的费用
		car.setMoney(carmoney+"元");
		
		//整体存入CarsSave中去
//		carsave.setCid(1);
		carsave.setCnum(car.getCnum());
		carsave.setName(car.getName());
		carsave.setCbrand(car.getCbrand());
		carsave.setCtype(car.getCtype());
		carsave.setCtime(car.getCtime());
		carsave.setWorker(car.getWorker());
		carsave.setOuttime(car.getOuttime());
		carsave.setMoney(car.getMoney());		
		
		csdao.addCarsSave(carsave);
		
		cdao.deleteCars(request.getParameter("cid")); //调用删除方法
		return "delete_success";
	}
	
	//车辆停入
	public String add() {
		CarsDAO carsDao = new CarsDAOImpl();
		Cars car = new Cars();
		car.setCnum(request.getParameter("cnum"));
		car.setName(request.getParameter("name"));
		car.setCbrand(request.getParameter("cbrand"));	
		car.setCtype(request.getParameter("ctype"));
		//添加页面中写的日期	
		car.setCtime(new Date());
		//将当前的值班人员姓名存入car数据库
		WorkersDAOImpl workerdao = new WorkersDAOImpl();
		System.out.println("我的名字是："+workerdao.getWorkername());
		car.setWorker(workerdao.getWorkername());
		carsDao.addCars(car);		
		return "add_success";
	}
	
	//修改车辆动作
	public String modify()
	{
		//获取传递过来的车辆编号
		String cid = request.getParameter("cid");
		CarsDAO sdao = new CarsDAOImpl();
		Cars c = sdao.queryCarsByCid(cid);
		//保存在会话中
		session.setAttribute("modify_cars", c);
		return "modify_success";
	}
	
	//保存修改后的车辆资料动作
	public String save() throws Exception
	{
		Cars c = new Cars();
		c.setCid(request.getParameter("cid"));
		c.setCnum(request.getParameter("cnum"));
		c.setName(request.getParameter("name"));	
		c.setCbrand(request.getParameter("cbrand"));
		c.setCtype(request.getParameter("ctype"));	
		
		//****从当前数据库中提取数据的方法
		//下面的这些内容保持不变，上面的式需要改变的
		CarsDAO sdao = new CarsDAOImpl();
		Cars c2 = sdao.queryCarsByCid(request.getParameter("cid"));
		
		c.setCtime(c2.getCtime());
		c.setWorker(c2.getWorker());
		c.setOuttime(c2.getOuttime());
		c.setMoney(c2.getMoney());
		
		CarsDAO cdao = new CarsDAOImpl();
		cdao.updateCars(c);
		return "save_success";
		
	}

	
}