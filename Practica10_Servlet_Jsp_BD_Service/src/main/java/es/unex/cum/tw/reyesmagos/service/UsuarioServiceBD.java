package es.unex.cum.tw.reyesmagos.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.unex.cum.tw.reyesmagos.controller.ProductosController;
import es.unex.cum.tw.reyesmagos.model.Usuario;
import util.ConexionUtil;

public class UsuarioServiceBD implements UsuarioService{
	public boolean authenticate(String username, String password) {
		Usuario user = getUserByUsername(username);
		if (user != null && user.getUsername().equals(username)
				&& user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public Usuario getUserByUsername(String username) {
		Usuario user = null;
		ResultSet resultados = null;
		try {
			String query="SELECT * FROM usuarios where username=?";
			PreparedStatement sentencia=(PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1,username);
			resultados = sentencia.executeQuery();
			
			if (resultados.next() == false) {
				return null;
			} else {
				user = new Usuario(
						Integer.parseInt(resultados.getString("id")),
						resultados.getString("Nombre"),
						resultados.getString("Apellidos"),
						resultados.getString("email"),
						resultados.getString("username"),
						resultados.getString("password"));

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Se cierra resultSet
			if (resultados != null) {
				try {
					resultados.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductosController.class.getName()).log(
							Level.SEVERE, "No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return user;
	}

	public Usuario getUserByUserId(String userId) {
		Usuario user = null;
		ResultSet resultados = null;
		try {
			String query="SELECT * FROM usuarios where Id=?";
			PreparedStatement sentencia=(PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1,userId);
			resultados = sentencia.executeQuery();
			if (resultados.next() == false) {
				return null;
			} else {
				user = new Usuario(
						Integer.parseInt(resultados.getString("id")),
						resultados.getString("Nombre"),
						resultados.getString("Apellidos"),
						resultados.getString("email"),
						resultados.getString("username"),
						resultados.getString("password"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Se cierra resultSet
			if (resultados != null) {
				try {
					resultados.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductosController.class.getName()).log(
							Level.SEVERE, "No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return user;
	}

	public List<Usuario> getListOfUsers() {
		Usuario user = null;
		ResultSet resultados = null;
		List<Usuario> l = new ArrayList<Usuario>();
		try {
			String query="SELECT * FROM usuarios";
			PreparedStatement sentencia=(PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			resultados = sentencia.executeQuery();

			while (resultados.next()) {
				user = new Usuario(
						Integer.parseInt(resultados.getString("id")),
						resultados.getString("Nombre"),
						resultados.getString("Apellidos"),
						resultados.getString("email"),
						resultados.getString("username"),
						resultados.getString("password"));
				l.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Se cierra resultSet
			if (resultados != null) {
				try {
					resultados.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductosController.class.getName()).log(
							Level.SEVERE, "No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return l;
	}

	public boolean register(Usuario user) {
		ResultSet resultados = null;
		if (getUserByUsername(user.getUsername()) != null)
			return false;

		try {
			
			String query = "INSERT INTO usuarios (nombre,apellidos,email,username,password) " + "VALUES (?,?,?,?,?)";
			PreparedStatement sentencia=(PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			synchronized (sentencia) {
				sentencia.setString(1, user.getNombre());
				sentencia.setString(2, user.getApellidos());
				sentencia.setString(3, user.getEmail());
				sentencia.setString(4, user.getUsername());
				sentencia.setString(5, user.getPassword());
				sentencia.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Se cierra resultSet
			if (resultados != null) {
				try {
					resultados.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductosController.class.getName()).log(
							Level.SEVERE, "No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return true;
	}
	
	public boolean deleteByUserId(String userId) {
		PreparedStatement sentencia = null;
		try {
			String query = "DELETE FROM usuarios WHERE id = ?";
			sentencia = (PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1, userId);
			return sentencia.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sentencia != null) {
				try {
					sentencia.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
