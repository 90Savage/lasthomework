package org.examples.javaee.class01.servlet;
import org.examples.javaee.class01.jdbc.StudentJdbc;
import org.examples.javaee.class01.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        Student student = new Student();
        student.setId(Long.parseLong(req.getParameter("id")));
        student.setName(req.getParameter("name"));
        Date date = new Date();
        student.setCreateTime(date);

        boolean result = StudentJdbc.addStudent(student);

        req.setAttribute("isOK", result);  //用来判断是否添加作业成功
        req.setAttribute("type","addStudent");
        req.getRequestDispatcher("jsp/t_return.jsp").forward(req,resp);
    }
}
