package org.examples.javaee.class01.servlet;


import org.examples.javaee.class01.jdbc.HomeworkJdbc;
import org.examples.javaee.class01.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/add")
public class AddStudentHomeworkServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentHomework sh = new StudentHomework();
        /**
         * 赋值
         */
        sh.setStudentId(Long.getLong(req.getParameter("student_id")));
        HomeworkJdbc.addStudentHomework(sh);

        resp.sendRedirect("list");
    }
}