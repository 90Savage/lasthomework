package org.examples.javaee.class01.servlet;


import org.examples.javaee.class01.jdbc.HomeworkJdbc;
import org.examples.javaee.class01.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/showHomework")
public class ShowAllHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从数据库读取所有作业记录
        List<Homework> list = HomeworkJdbc.showHomework();

        req.setAttribute("list",list);

        req.getRequestDispatcher("jsp/showAllHomework.jsp").forward(req,resp);
    }
}