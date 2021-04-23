package model;

import dao.CommentDao;
import dao.PostDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewPost")
public class ViewComment extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href=\"index.jsp\">Go to Home page</a>");
        out.println("<div class='container'>");
        List<CommentBean> list = CommentDao.view();
        out.println("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Id</th><th>Title</th><th>Description</th><th>Edit</th><th>Delete</th></tr>");
        for(CommentBean commentBean:list){
            out.println("<tr><td>"+commentBean.getId()+"</td><td>"+commentBean.getLogin()+"</td><td>"+commentBean.getComment()
                    +"</td><td><a href='EditUserForm?id="+commentBean.getId()+"'>Edit</a></td><td><a href='DeleteUser?id="
                    +commentBean.getId()+"'>Delete</a></td></tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.close();
    }
}
