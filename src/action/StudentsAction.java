package action;
//瀛︾敓Action绫�

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Students;
import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

public class StudentsAction extends SuperAction{

	private  static final long serialVersionUID = 1L;

	//查询学生动作
	public String query()
	{
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		//放进session中
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("students_list",list);
		}
		return "query_success";
	}

	//删除学生动作
	public String delete()
	{
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid); //调用删除方法
		return "delete_success";
	}
	
	//添加学生
	public String add() {
		StudentsDAO studentsDao = new StudentsDAOImpl();
		Students student = new Students();
		student.setSname(request.getParameter("sname"));
		student.setGender(request.getParameter("gender"));
//		student.setBirthday(new Date());
		//添加页面中写的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			student.setBirthday(sdf.parse(request.getParameter("birthday")));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		student.setAddress(request.getParameter("address"));
		studentsDao.addStudents(student);
		return "add_success";
	}
	
	//修改学生资料动作
	public String modify()
	{
		//获取传递过来的学生编号
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//保存在会话中
		session.setAttribute("modify_students", s);
		return "modify_success";
		}
	
	//保存修改后的学生资料动作
	public String save() throws Exception
	{
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.updateStudents(s);
		return "save_success";
		
	}
}