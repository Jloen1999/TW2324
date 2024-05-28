package es.unex.cum.tw.reyesmagos.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import es.unex.cum.tw.reyesmagos.model.Producto;
import es.unex.cum.tw.reyesmagos.model.Usuario;
import es.unex.cum.tw.reyesmagos.service.UsuarioService;
import es.unex.cum.tw.reyesmagos.service.UsuarioServiceBD;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Restringido/InfoUsuarioController")
public class InfoUsuarioController extends HttpServlet {
	private UsuarioService userService = new UsuarioServiceBD();
	//private UsuarioService userService = new UsuarioServiceMemory();
	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	public void processRequest(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String accion = req.getParameter("action");
		if (accion.equals("InfoUsuario")) {
			info(req, res);
		} else if (accion.equals("eliminarUsuario")) {
			delete(req, res);
		} else {
			req.getRequestDispatcher("Error.jsp?error=No hay acción").forward(req, res);
		}

	}

	public void info(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		Usuario result = userService.getUserByUserId(id);
		if (result == null) {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=ERROR: No se ha encontrado el usuario").forward(req, res);
			return;
		} else {
			req.setAttribute("usuario", result);
			req.getRequestDispatcher("../WEB-INF/InfoUsuario.jsp").forward(req, res);
		}
	}

	public void delete(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String id = req.getParameter("idUsuario");
		Boolean result = userService.deleteByUserId(id);
		if (!result) {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=ERROR: No se ha encontrado el usuario").forward(req, res);
			return;
		} else {
			res.sendRedirect("../Inicio.html");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		processRequest(req, res);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		processRequest(req, res);
	}

	@Override
	public void destroy() {
	}
}
