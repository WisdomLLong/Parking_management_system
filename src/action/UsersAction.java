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

	// �û���¼����
	public String login() {
		UsersDAO usersDao = new UsersDAOImpl();
		if (usersDao.usersLogin(user)) 
		{
			// ��session�б����¼�ɹ����û���
			session.setAttribute("loginUserName", user.getUsername());
			//setAttribute����������session���д洢������ֵ���Ժ����getAttribute()����ȡ��ʹ������
			
			WorkersDAO workerdao = new WorkersDAOImpl();
			Workers worker = new Workers();
			//�洢ֵ����Ա������
			worker.setWorkername(user.getUsername());
			//�洢ֵ����Ա�ĵǼ�ʱ��
			worker.setWorkerintime(new Date());
			workerdao.addWorkers(worker);
			
			//�洢ֵ����Ա�ĵǼ�ʱ��
			
			return "login_success";
		} else {
			return "login_failure";
		}
	}
	
	@Override
	public String queryworker(){
		WorkersDAO wdao = new WorkersDAOImpl();
		List<Workers> list = wdao.queryAllWorkers();
		//�Ž�session��
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

	// �û�ע������������ע��ȡ���˷����ı���֤
	@SkipValidation
	public String logout() {
		UsersDAO workerdao = new UsersDAOImpl();
		//�洢ֵ����Ա��ע��ʱ��
		workerdao.Saveouttime();		
		
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

//	@Override
//	public void validate(){
//		//�û�������Ϊ��
//		if("".equals(user.getUsername().trim()))
//		{
//			this.addFieldError("usernameError","�û�������Ϊ�գ�");
//
//		}
//		if(user.getPassword()<6)
//		{
//			this.addFieldError("passwordError","���벻��С��6λ");
//		}
//	}

}
