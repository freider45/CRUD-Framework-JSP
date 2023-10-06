<%@page import="java.util.ArrayList"%>
<%@page import="javaBeans.Categoria" %>
<%@page import="cad.CategoriCad" %>

<div class="left-sidebar">
    <h2>Categorías</h2>
    <div class="panel-group category-products" id="accordian"><!--category-productsr-->
        <%!
            ArrayList<Categoria> lista = CategoriCad.listar() ;
            int codigo = 0;
        %>
        <%
        try{  
            if (lista != null) {
                for (int i = 0; i < lista.size(); i++) {
                    codigo = lista.get(i).getCodigo();
        %>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a <% if(CategoriCad.esSuperior(codigo)) {%> data-toggle="collapse" data-parent="#accordian" <% } %> href="#<%= lista.get(i).getCodigo() %>">
                        <% if(CategoriCad.esSuperior(codigo)) {%><span class="badge pull-right"><i class="fa fa-plus"></i></span><% } %>
                            <%= lista.get(i).getNombre() %>
                    </a>
                </h4>
            </div>
            <div id="<%= lista.get(i).getCodigo() %>" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul>
                        <% ArrayList<Categoria> listaSub = CategoriCad.listarSubCategorias(codigo); %>
                        <%= listaSub.get(i).getNombre() %>
                    </ul>
                </div>
            </div>
        </div>
        <%
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        %>
    </div><!--/category-products-->

        <div class="brands_products"><!--brands_products-->
                <h2>Marcas</h2>
                <div class="brands-name">
                        <ul class="nav nav-pills nav-stacked">
                                <li><a href="#"> <span class="pull-right">(56)</span>Nike</a></li>
                                <li><a href="#"> <span class="pull-right">(27)</span>Adidas</a></li>
                                <li><a href="#"> <span class="pull-right">(32)</span>Polo</a></li>
                                <li><a href="#"> <span class="pull-right">(5)</span>Puma</a></li>
                                <li><a href="#"> <span class="pull-right">(9)</span>Boude</a></li>
                                <li><a href="#"> <span class="pull-right">(4)</span>ACB</a></li>
                        </ul>
                </div>
        </div><!--/brands_products-->

        <div class="shipping text-center"><!--shipping-->
                <img src="images/home/shipping.jpg" alt="" />
        </div><!--/shipping-->

</div>