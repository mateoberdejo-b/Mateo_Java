<%@ page import="java.util.List" %>
<%@ page import="pedidos.models.Cliente, pedidos.models.Producto, pedidos.models.Pedido" %>
<!-- Listados -->
 <h2>Lista de Clientes</h2>
 <table border="1">
 <tr><th>ID</th><th>Nombre</th><th>Email</th></tr>
 <%
 
 
 List<Cliente> clientes = (List<Cliente>) request.getAttribute("cliente");
 if (clientes != null) {
 for (Cliente c : clientes) {
 %>
 
 
 <tr>
 <td><%= c.getId() %></td>
 <td><%= c.getNombre() %></td>
 <td><%= c.getEmail() %></td>
 </tr>
 <% }} %>
 </table>
 <h2>Lista de Productos</h2>
 <table border="1">
 <tr><th>ID</th><th>Nombre</th><th>Precio</th></tr>
 <%
 
 
 List<Producto> productos = (List<Producto>) request.getAttribute("producto");
 if (productos != null) {
 for (Producto p : productos) {
 %>
 
 
 <tr>
 <td><%= p.getId() %></td>
 <td><%= p.getNombre() %></td>
 <td><%= p.getPrecio() %></td>
 </tr>
 <% }} %>
 </table>
 <h2>Lista de Pedidos</h2>
 <table border="1">
 <tr><th>ID</th><th>ID Cliente</th><th>ID
Producto</th><th>Cantidad</th></tr>
 <%
 List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
 if (pedidos != null) {
 for (Pedido ped : pedidos) {
 %>
 
 
 <tr>
 <td><%= ped.getId() %></td>
 <td><%= ped.getClienteId() %></td>
 <td><%= ped.getProductoId() %></td>
 <td><%= ped.getCantidad() %></td>
 </tr>
 <% }} %>
 </table>