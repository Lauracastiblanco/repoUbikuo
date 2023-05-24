<%-- 
    Document   : JM
    Created on : 21/05/2023, 08:07:02 PM
    Author     : Alexander
--%>

<%@page import="ModeloVO.productosVO"%>
<%@page import="java.util.List"%>
<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page import="ModeloDAO.productosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="DetallesPedidoProveedor">
            <div class="productos">
                <div class="datosproductos">
                    <label>Producto</label>
                    <select name="id_prod" id="selectProducto" onchange="inputsProductos()" class="select2" id="miSelect">
                        <option value="">Sele ccione...</option>
                        <%
                            productosDAO prodDAO = new productosDAO();
                            CategoriaDAO catProdDAO = new CategoriaDAO();
                            List<CategoriaVO> listaCategorias = catProdDAO.listarC();
                            for (CategoriaVO catVO : listaCategorias) {
                                List<productosVO> listaProductos = prodDAO.listarCategoria(catVO.getId_cat());
                                if (!listaProductos.isEmpty()) {
                        %>
                        <optgroup label="Categoria: <%=catVO.getCatnombre()%>">
                            <% for (productosVO prodVO : listaProductos) {%>
                            <option class="producto-option" value="<%=prodVO.getId_prod()%>" data-descripcion="<%=prodVO.getProd_descripcion()%>" data-precio="<%=prodVO.getProdprecio()%>" data-stock="<%=prodVO.getProdstock_disp()%>"><%=prodVO.getProdnombre()%> - REF: <%=prodVO.getId_prod()%></option>
                            <% } %>
                        </optgroup>
                        <% }
                            }%>
                    </select>
                    <label>Descripción</label>
                    <input type="text" placeholder="Descripcion" id="prod_descripcion" >
                    <label>Precio</label>
                    <input type="text" placeholder="Precio" id="prodprecio" name="prodprecio">
                    <label>Stock</label>
                    <input type="text" placeholder="Stock" id="prodstock_disp" name="prodstock_disp">
                    <label>Cantidad</label>
                    <input type="text" placeholder="Cantidad" name="dpro_cantidad">
                    <label>Foto</label>
                    <img class="foto-prod" src="ASSETS/Breaker.png" alt=""/>
                    <button class="btn agregar" id="agregar-btn">Agregar al pedido</button>
                    <input  type="hidden" name="opcion" value="1">
                </div>
            </div>
        </form>
    </body>
</html>
