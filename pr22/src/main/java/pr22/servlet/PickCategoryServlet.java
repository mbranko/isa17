package pr22.servlet;

import pr22.dao.CategoryDao;
import pr22.entity.Category;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PickCategoryServlet extends HttpServlet {

  @EJB
  private CategoryDao categoryDao;
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html; charset=utf-8");
    request.setCharacterEncoding(response.getCharacterEncoding());
    ServletContext ctx = getServletConfig().getServletContext();
    HttpSession session = request.getSession(true);
    
    try {
      String sCategoryId = request.getParameter("id");
      int categoryId = Integer.parseInt(sCategoryId);
      Category category = categoryDao.loadWithChildren(categoryId);
      session.setAttribute("category", category);
      
      ctx.getRequestDispatcher("/category.jsp").forward(request, response);
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
  }

  private static final long serialVersionUID = -7644432609287904592L;
}
