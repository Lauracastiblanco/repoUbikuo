<%-- 
    Document   : pedido
    Created on : 26/04/2023, 07:41:07 AM
    Author     : APRENDIZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido del Proveedor</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="w-50 p-3">
                <div class="card">
                    <form method="post" action="Controlador?menu=pedidoProv">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del pedido</label>
                            </div>
                           <div class="form-group mt-4"> 
                                <div class="row g-2">
                                    <div class="col">
                                        <label>Fecha Pedido</label>
                                        <input class="form-control" type="date" name="" value="">
                                    </div>
                                    <div class="col">
                                        <label>Fecha Entrega</label>
                                        <input class="form-control" type="date" name="" value="">
                                    </div>
                                </div>
                           </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <select class="form-select" name="prodEstado" value="">
                                    <option value="activo">Activo</option>
                                    <option value="inactivo">Inactivo</option>
                                </select><br>
                            </div>
                           <div class="form-group mt-1">
                               <label>Datos del proveedor</label>
                           </div>
                           <div class="form-group d-flex mt-4 row g-6">
                               <div class="col-sm-6 d-flex">
                                   <input type="text" name="idProveedor" value="${p.getId_prov()}" class="form-control" placeholder="Id Proveedor">
                                   <button type="submit" class="btn btn-outline-secondary"  name="accion" value="buscarProveedor" >Buscar</button>
                                </div>

                                <div class="col-sm-6">
                                    <input type="text" name="nombreproveedor" value="${p.getPronombre()}" placeholder="Datos Proveedor"class="form-control">
                                </div>
                            </div>
                            <div class="form-group mt-4"> 
                                <label>Datos productos</label>
                            </div>
                            <div class="form-group d-flex row g-6 mt-3">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="idProducto" class="form-control" value="${producto.getId_prod()}" placeholder="Id Producto">
                                    <button type="submit" class="btn btn-outline-secondary"  name="accion" value="buscarProducto" >Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreProducto" value="${producto.getProdNombre()}" placeholder="Datos Producto"class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex row g-6 mt-4">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precioProducto" value="${producto.getProdPrecio()}"class="form-control" placeholder="$0.0">
                                    <input type="hidden" name="opcion" value="">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cantProducto" class="form-control" placeholder="">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stockPorducto" value="${producto.getProdstock_disp()}" placeholder="Stock" class="form-control">
                                </div>
                            </div>
                            <div>
                                <button type="submit" name="accion" value="agregarProducto"class="form-group btn btn-outline-secondary mt-4" >Agregar Producto</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            
            <div class="w-100 p-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-row-reverse">
                            <div class="d-flex">
                                <lable>Id Pedido</lable>
                                <input type="text" value="${numeroSerie}"name="numeroSerie" class="form-control">
                            </div>
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Item</th>
                                    <th>Id Proveedor</th>
                                    <!--<th>Fecha Pedido</th> -->
                                    <!--<th>Fecha Entrega</th>c
                                    <!--<th>Estado</th>-->
                                    <th>Id Producto</th>
                                    <th>Descripcion</th>
                                    <th>Cantidad</th>
                                    <th>Precio</th>
                                    <th>SubTotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdProveedor()}</td>
                                    <td>${list.getIdProducto()}</td>
                                    <td>${list.getProPedDescripcion()}</td>
                                    <td>${list.getProPedCantidad()}</td>
                                    <td>${list.getProPedPrecio()}</td>
                                    <td>${list.getProPedSubTotal()}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div>
                        <div class="card-footer d-flex">
                            <div class="col-sm-6">
                                <a class="btn btn-success" href="Controlador?menu=pedidoProv&accion=generarVenta">Generar Venta</a>
                                <input type="hidden" name="accion" value="" >
                                <button class="btn btn-danger">Cancelar</button>
                                <input type="hidden" name="accion" value="" >
                            </div>
                            <div class="col-sm-3">
                                <input type="text" name="totalPagar" value="$/. ${totalPagar}0" class="form-control text-center fw-bold">
                            </div>
                        </div>

                    </div>
                </div>
                
            </div>
        </div>
                                
        <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
