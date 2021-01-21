package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;
import model.User;




@WebServlet(urlPatterns= {"/blog"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		String[] arr = blogDetails.split(",");
		String title = arr[0];
		String description = arr[1];
		//String postedOn = arr[2];
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		//LocalDate localDate = LocalDate.parse(postedOn, formatter);
		
		Blog blog = new Blog(arr[0], arr[1], LocalDate.now());
		System.out.println("Blog Title: " + blog.getTitle());
		System.out.println("Blog Description: " + blog.getDescription());
		System.out.println("Posted on: " + LocalDate.now());
		User user = new User(null, null, null);

		
		if(blog!=null) {
			request.setAttribute("blog", blog);
			request.setAttribute("user",user);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
	
	}

}

/*
Blog Title: A blog on Java.
Blog Description: This sample blog explains about Java basics.
Posted on: 2020-03-03 */
