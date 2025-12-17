package pedidos.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pedidos.models.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PedidosServlet")
public class PedidosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final Conexion conexion = new Conexion();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try (Connection con = conexion.getConnection()) {

            switch (action) {

                case "addCliente" -> {
                    String nombre = request.getParameter("nombreCliente");
                    String email = request.getParameter("emailCliente");

                    String sql = "INSERT INTO clientes(nombre, email) VALUES (?, ?)";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setString(1, nombre);
                        ps.setString(2, email);
                        ps.executeUpdate();
                    }
                }

                case "addProducto" -> {
                    String nombre = request.getParameter("nombreProducto");
                    double precio = Double.parseDouble(request.getParameter("precioProducto"));

                    String sql = "INSERT INTO productos(nombre, precio) VALUES (?, ?)";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setString(1, nombre);
                        ps.setDouble(2, precio);
                        ps.executeUpdate();
                    }
                }

                case "addPedido" -> {
                    int clienteId = Integer.parseInt(request.getParameter("clienteId"));
                    int productoId = Integer.parseInt(request.getParameter("productoId"));
                    int cantidad = Integer.parseInt(request.getParameter("cantidad"));

                    String sql = "INSERT INTO pedidos(cliente_id, producto_id, cantidad) VALUES (?, ?, ?)";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setInt(1, clienteId);
                        ps.setInt(2, productoId);
                        ps.setInt(3, cantidad);
                        ps.executeUpdate();
                    }
                }
            }

        } catch (Exception e) {
            throw new ServletException("Error en doPost de PedidosServlet", e);
        }

        response.sendRedirect("PedidosServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (Connection con = conexion.getConnection();
             PrintWriter out = response.getWriter()) {

            String sql = "SELECT id, nombre, email FROM clientes";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            out.println("<html><body>");
            out.println("<h2>Lista de Clientes</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Nombre</th><th>Email</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("nombre") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }


    // ================== MÉTODOS AUXILIARES ==================

    private List<Cliente> obtenerClientes(Connection con) throws SQLException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, email FROM clientes";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setEmail(rs.getString("email"));
                lista.add(c);
            }
        }
        return lista;
    }

    private List<Producto> obtenerProductos(Connection con) throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, precio FROM productos";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                lista.add(p);
            }
        }
        return lista;
    }

    private List<Pedido> obtenerPedidos(Connection con) throws SQLException {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT id, cliente_id, producto_id, cantidad FROM pedidos";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pedido ped = new Pedido();
                ped.setId(rs.getInt("id"));
                ped.setClienteId(rs.getInt("cliente_id"));
                ped.setProductoId(rs.getInt("producto_id"));
                ped.setCantidad(rs.getInt("cantidad"));
                lista.add(ped);
            }
        }
        return lista;
    }
}
