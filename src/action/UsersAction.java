package action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import entity.Cars;
import entity.Users;
import entity.Workers;
import service.CarsDAO;
import service.UsersDAO;
import service.WorkersDAO;
import service.impl.CarsDAOImpl;
import service.impl.UsersDAOImpl;
import service.impl.WorkersDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	private static final long serialVersionUID = 1L;

	private Users user = new Users();

	// 用户登录动作
	public String login() {
		UsersDAO usersDao = new UsersDAOImpl();
		if (usersDao.usersLogin(user)) 
		{
			// 在session中保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUsername());
			//setAttribute的作用是在session个中存储变量和值，以后可用getAttribute()来获取和使用它。
			
			WorkersDAO workerdao = new WorkersDAOImpl();
			Workers worker = new Workers();
			//存储值班人员的姓名
			worker.setWorkername(user.getUsername());
			//存储值班人员的登记时间
			worker.setWorkerintime(new Date());
			workerdao.addWorkers(worker);
			
			//存储值班人员的登记时间
			
			return "login_success";
		} else {
			return "login_failure";
		}
	}
	
	@Override
	public String queryworker(){
		WorkersDAO wdao = new WorkersDAOImpl();
		List<Workers> list = wdao.queryAllWorkers();
		//放进session中
		System.out.println(list);
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("workers_list",list);
		}
		return "query_success";
	}
	
	@SkipValidation
	@Override
	public Users getModel() {
		return user;
	}

	// 用户注销方法，加上注解取消此方法的表单验证
	@SkipValidation
	public String logout() {
		UsersDAO workerdao = new UsersDAOImpl();
		//存储值班人员的注销时间
		workerdao.Saveouttime();		
		
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

//	@Override
//	public void validate(){
//		//用户名不能为空
//		if("".equals(user.getUsername().trim()))
//		{
//			this.addFieldError("usernameError","用户名不能为空！");
//
//		}
//		if(user.getPassword()<6)
//		{
//			this.addFieldError("passwordError","密码不能小于6位");
//		}
//	}

}
