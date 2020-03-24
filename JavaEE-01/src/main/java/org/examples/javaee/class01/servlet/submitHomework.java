package org.examples.javaee.class01.servlet;


import org.examples.javaee.class01.jdbc.HomeworkJdbc;
import org.examples.javaee.class01.model.Homework;
import org.examples.javaee.class01.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/submit")
public class submitHomework extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        Homework homework = HomeworkJdbc.showHomeworkDetails(id);//访问数据库
        req.setAttribute("homework",homework);
        req.getRequestDispatcher("jsp/submitHomework.jsp").forward(req,resp); //展示内容
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        StudentHomework studentHomework = new StudentHomework();

        studentHomework.setStudentId(Long.parseLong(req.getParameter("studentId")));
        studentHomework.setHomeworkId(Long.parseLong(req.getParameter("homeworkId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        Date date = new Date();
        studentHomework.setCreateTime(date);

        boolean result = HomeworkJdbc.addStudentHomework(studentHomework);

        req.setAttribute("isOK", result);   //用于判断是否提交成功
        req.setAttribute("type","addStudentHomework");
        req.getRequestDispatcher("jsp/s_return.jsp").forward(req,resp);
    }
}