package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.OrderService;

import java.io.IOException;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/order/*")
@MultipartConfig()
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = "order/";
		String service = request.getRequestURI().substring((request.getContextPath()+"/"+cate).length());
		System.out.println(service);
		request.setAttribute("mainUrl", cate+service+".jsp");
		try {
			OrderService os = (OrderService)Class.forName("order_p."+service).newInstance();
			os.execute(request, response);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
