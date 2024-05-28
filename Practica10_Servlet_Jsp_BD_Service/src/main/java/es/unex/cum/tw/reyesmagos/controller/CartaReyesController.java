package es.unex.cum.tw.reyesmagos.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import es.unex.cum.tw.reyesmagos.model.Carta;
import es.unex.cum.tw.reyesmagos.service.CartaService;
import es.unex.cum.tw.reyesmagos.service.CartaServiceBD;
import es.unex.cum.tw.reyesmagos.service.CartaServiceMemory;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Configuracion
 */
@WebServlet(urlPatterns = "/Restringido/CartaReyesController")
public class CartaReyesController extends HttpServlet {
	private CartaService c = new CartaServiceBD();
	//private CartaService c= new CartaServiceMemory();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	public void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		/*
		 * //No hace falta por filter ServletContext contexto = req.getServletContext();
		 * HttpSession session = req.getSession();
		 * 
		 * String id = (String) session.getAttribute("Id"); if (id != null &&
		 * !id.equals("")) {
		 */
		String accion = req.getParameter("action");
		if (accion.equals("anadirCarta")) {
			anadirCarta(req, res);
		} else if (accion.equals("VerCarta")) {
			verCarta(req, res);
		} else if (accion.equals("eliminarCarta")) {
			eliminarCarta(req, res);
		} else {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=No hay acción").forward(req, res);
		}
		/*
		 * } else { res.sendRedirect("Error.jsp?error=ERROR: Problema con la sesión"); }
		 */
	}

	public void anadirCarta(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		String idP = req.getParameter("idProducto");
		try {
			if (!c.anadirCarta(idP, id)) {
				req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=No hay productos en la carta").forward(req,res);
			} else {
				req.setAttribute("mensaje", "Añadido al carrito perfectamente");
				req.getRequestDispatcher("../WEB-INF/Principal.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}
	}

	public void eliminarCarta(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		String idP = (String) req.getParameter("idP");
		try {

			if (!c.eliminarCarta(idP, id)) {
				req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=ERROR: No hay productos").forward(req, res);
				return;
			} else {
				req.setAttribute("mensaje", "Eliminado del carrito perfectamente");
				req.getRequestDispatcher("../WEB-INF/Principal.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador");

		}
	}

	public void verCarta(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		String idP = (String) req.getParameter("idProducto");

		try {

			List<Carta> result = c.verCarta(idP, id);
			if (result == null) {
				req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=ERROR: No hay productos").forward(req, res);
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("../WEB-INF/VerCarta.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher(
					"../WEB-INF/Principal.jsp?mensaje=ERROR: Error en la consulta. Hable con administrador").forward(req, res);

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
