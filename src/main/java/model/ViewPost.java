package model;

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
public class ViewPost extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<a href=\"index.jsp\">Go to Home page</a>");
        out.println("<div class='container'>");
        List<PostBean> list = PostDao.view();
        out.println("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Id</th><th>Title</th><th>Description</th><th>Edit</th><th>Delete</th></tr>");
        for(PostBean postBean:list){
            out.println("<tr><td>"+postBean.getId()+"</td><td>"+postBean.getTitle()+"</td><td>"+postBean.getDescription()
                    +"</td><td><a href='EditUserForm?id="+postBean.getId()+"'>Edit</a></td><td><a href='DeleteUser?id="
                    +postBean.getId()+"'>Delete</a></td></tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.close();
    }
}
