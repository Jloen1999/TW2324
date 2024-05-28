package es.unex.cum.tw.reyesmagos.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.ConexionUtil;
import es.unex.cum.tw.reyesmagos.controller.ProductosController;
import es.unex.cum.tw.reyesmagos.model.Carta;
import es.unex.cum.tw.reyesmagos.model.Producto;

public class CartaServiceBD implements CartaService {

	public boolean anadirCarta(String idP, String id) throws IOException, SQLException {
		ResultSet resultado = null;
		PreparedStatement sentencia = null;
		try {

			// Verficamos si existe el producto antes de añadirlo(en caso de existir
			// incrementamos cantidad en 1)
			String query = "SELECT cantidad FROM carta WHERE idCliente = ? AND idProducto = ?";
			sentencia = (PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1, id);
			sentencia.setString(2, idP);
			resultado = sentencia.executeQuery();

			if (resultado.next()) {
				int cantidad = resultado.getInt("cantidad");
				query = "UPDATE carta SET cantidad = ? WHERE idCliente = ? AND idProducto = ?";
				sentencia = (PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
				sentencia.setString(2, id);
				sentencia.setString(3, idP);
				sentencia.setInt(1, cantidad + 1);
				sentencia.executeUpdate();
			} else {
				query = "INSERT INTO carta (idCliente,idProducto,cantidad) " + "VALUES (?,?,?)";
				sentencia = (PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
				sentencia.setString(1, id);
				sentencia.setString(2, idP);
				sentencia.setInt(3, +1);
				sentencia.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultado != null) {
				resultado.close();
			}
			if (sentencia != null) {
				sentencia.close();
			}
		}
		return false;
	}

	public boolean eliminarCarta(String idP, String id) throws IOException, SQLException {
		PreparedStatement sentencia = null;
		try {
			String query = "DELETE FROM carta WHERE idCliente = ? AND idProducto = ?";
			sentencia = (PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			System.out.println("id: "+id);
			System.out.println("idP: "+idP);
			sentencia.setString(1, id);
	        sentencia.setString(2, idP);
			return sentencia.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sentencia != null) {
				sentencia.close();
			}
		}
		return false;
	}

	public List<Carta> verCarta(String idP, String id) throws IOException, SQLException {
		ResultSet resultados = null;
		try {
			String query = "select productos.nombreProd, productos.idProductos, usuarios.nombre, carta.cantidad  from carta inner join usuarios on carta.idCliente = usuarios.id inner join productos on carta.idProducto = productos.idProductos  where idCliente = ?;";
			PreparedStatement sentencia = ConexionUtil.openConnection().prepareStatement(query,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sentencia.setString(1, id);
			resultados = sentencia.executeQuery();
			if (!resultados.next()) {

			} else {
				resultados.beforeFirst();
				ArrayList l = new ArrayList();
				while (resultados.next()) {
					l.add(new Carta(Integer.parseInt(resultados.getString(2)), resultados.getString(3),
							resultados.getString(1), Integer.parseInt(resultados.getString(4))));
				}
				return l;
			}

		} catch (SQLException e2) {

		} finally {
			// Se cierra resultSet
			if (resultados != null) {
				try {
					resultados.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE,
							"No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return null;
	}

}
