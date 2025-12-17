<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Sistema de Pedidos</title>
</head>
<body>

<h1>Gestión de Sistema de Pedidos</h1>

<h2>Agregar Cliente</h2>
<form action="PedidosServlet" method="post">
    <input type="hidden" name="action" value="addCliente">
    Nombre: <input type="text" name="nombreCliente"><br>
    Email: <input type="email" name="emailCliente"><br>
    <button type="submit">Guardar Cliente</button>
</form>

<h2>Agregar Producto</h2>
<form action="PedidosServlet" method="post">
    <input type="hidden" name="action" value="addProducto">
    Nombre: <input type="text" name="nombreProducto"><br>
    Precio: <input type="text" name="precioProducto"><br>
    <button type="submit">Guardar Producto</button>
</form>

<h2>Agregar Pedido</h2>
<form action="PedidosServlet" method="post">
    <input type="hidden" name="action" value="addPedido">
    ID Cliente: <input type="text" name="clienteId"><br>
    ID Producto: <input type="text" name="productoId"><br>
    Cantidad: <input type="number" name="cantidad"><br>
    <button type="submit">Guardar Pedido</button>
</form>

</body>
</html>

