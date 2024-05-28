package es.unex.cum.tw.reyesmagos.controller;

import java.io.IOException;

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


@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private UsuarioService userService = new UsuarioServiceBD();
	//private UsuarioService userService = new UsuarioServiceMemory();
	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	public void processRequest(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String accion = req.getParameter("action");
		if (accion.equals("UsuarioLogin")) {
			doLogin(req, res);
		} else if (accion.equals("UsuarioAlta")) {
			darAlta(req, res);
		} else {
			req.getRequestDispatcher("Error.jsp?error=No hay acción").forward(req, res);
		}

	}

	public void doLogin(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String username = req.getParameter("user");
		String passRecibido = req.getParameter("password");
		try {
			
			boolean result = userService.authenticate(username, passRecibido);
			Usuario user = userService.getUserByUsername(username);
			if (result == true) {
				HttpSession session = req.getSession(true);
				session.setAttribute("id", String.valueOf(user.getId()));
				session.setAttribute("nombre", user.getNombre());
				session.setAttribute("username", user.getUsername());
				req.setAttribute("mensaje", "Autenticacion correcta");
				req.getRequestDispatcher("./WEB-INF/Principal.jsp").forward(req, res);
			} else {
				res.sendRedirect("Error.jsp?error=Error en Password");
				return;
			}
		} catch (Exception e2) {
			// Error SQL: login/passwd mal
			req.getRequestDispatcher("Error.jsp?error=ERROR:Fallo en SQL").forward(req, res);
		}
	}

	public void darAlta(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String n = req.getParameter("nombre");
		String apel = req.getParameter("apellidos");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		Usuario usuario1 = new Usuario(-1, n, apel, email, username, pass);

		try {
			boolean result = userService.register(usuario1);
			if (result) {
				req.setAttribute("mensaje", "Dado de alta correctamente");
				req.getRequestDispatcher("./Login.jsp").forward(req, res);
				return;
			} else {
				req.getRequestDispatcher("Error.jsp?error=El usuario ya existe").forward(req, res);;
				return;
			}
		} catch (Exception e2) {
			// Error SQL: login/passwd mal
			req.getRequestDispatcher("Error.jsp?error=ERROR:Fallo en SQL").forward(req, res);
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
