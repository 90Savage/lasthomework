package org.examples.javaee.class01.servlet;

import org.examples.javaee.class01.jdbc.StudentHomeworkJdbc;
import org.examples.javaee.class01.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * StudentHomeworkServlet
 *
 * @author wangkm
 * @date 2020-03-05
 * @since 0.0.1
 */
@WebServlet("/list")
public class StudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> list = StudentHomeworkJdbc.selectAll();


        req.setAttribute("list", list);

        req.getRequestDispatcher("/Users/apple/IdeaProjects/javaee03/JavaEE-01/src/main/webapps/index.jsp").forward(req, resp);
    }
}
