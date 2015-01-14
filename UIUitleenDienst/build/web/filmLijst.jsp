<%-- 
    Document   : filmLijst
    Created on : 9-jan-2015, 13:58:34
    Author     : Ikke
--%>

<%@page import="DAL.Film"%>
<%@page import="ViewModels.FilmLijstVM"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    FilmLijstVM vm = (FilmLijstVM) session.getAttribute("ViewModel");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
        
        <link type="text/css" rel="stylesheet" href="CSSFilmLijst.css">
        <title>FilmLijst</title>
    </head>
    <body>
        <h1 class="h1">Videotheek</h1>
        
        <div class="zoeken" >
            <h3>Zoeken</h3><br>
            <form method="POST" action="ZoekByTitel" class="form-inline" role="form">
                <div class="form-group">
                    <label for="Titel" class="labelZoeken">Titel:</label>
                    <input type="text" class="form-control" name="Titel" placeholder="Titel">
                </div>
                <button type="submit" class="btn btn-primary btn-sm">Zoeken</button>                
            </form>
            <form method="POST" action="ZoekByGenre" class="form-inline" role="form">
                <div class="form-group">
                    <label for="Genre" class="labelZoeken">Genre:</label>
                    <input type="text" class="form-control" name="Genre" placeholder="Genre">
                </div>
                <input type="submit" class="btn btn-primary btn-sm" value="Zoeken">
            </form>
            <form method="POST" action="ZoekByActeur" class="form-inline" role="form">
                <div class="form-group">
                    <label for="Acteur" class="labelZoeken">Acteur/Actrice:</label>
                    <input type="text" class="form-control" name="Acteur" placeholder="Acteur">
                </div>
                <input type="submit" class="btn btn-primary btn-sm" value="Zoeken">
            </form>
            <label name="Error" class="error" style="visibility: <% if(null == session.getAttribute("Error") || "".equals(session.getAttribute("Error"))){%>hidden<%
            }else{%>visible<%}%>">"${sessionScope.Error}"</label>
        </div>
        
        <div class="lijst">
        <table class="table table-hover">
            <tr>
                <th hidden="true">Id</th>
                <th>Titel</th>
                <th>Genre</th>
                <th>Jaar</th>
                <th>Acteurs/Actrices</th>
                <th></th>
            </tr>
            <%
                for (Film film : vm.getFilms()){
            %>
            <tbody overflow="auto">
            <tr>
                <td hidden="true"><%= film.getFilmID() %></td>
                <td class="titel"><a href="/UIUitleenDienst/DetailsController?Id=<%=film.getFilmID()%>"><%= film.getTitel() %></a></td>
                <td class="genre"><%= film.getGenre() %></td>
                <td class="jaar"><%= film.getJaar() %></td>
                <td class="acteurs"><%= film.getActeurs() %></td>
                <td class="button">
                    <form method="POST" action="Uitlenen?id=<%= film.getFilmID() %>&bool=<%= film.getUitgeleend()%>" role="form">
                        <input id="btnLenen" type="submit" name="btnLenen" class="btn btn-primary btn-sm" 
                               value="<%
                               if(film.getUitgeleend()== false)
                               {
                                   %>Lenen<%
                               }
                               else
                               {
                                   %>Uitgeleend<%
                               }
                                   %>">                        
                    </form>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
        </div>
        
        <div class="details">
            <table>
                <tr>
                    <td><label>Titel:</label></td>
                    <td><textarea rows="1" cols="75"><% if(null == session.getAttribute("Titel")){%><%}else{%>"${sessionScope.Titel}"<%}%></textarea></td>
                </tr>
                <tr>
                    <td><label>Genre:</label></td>
                    <td><textarea rows="1" cols="75"><% if(null == session.getAttribute("Genre")){%><%}else{%>"${sessionScope.Genre}"<%}%></textarea></td>
                </tr>
                <tr>
                    <td><label>Jaar:</label></td>
                    <td><textarea rows="1" cols="75"><% if(null == session.getAttribute("Jaar")){%><%}else{%>"${sessionScope.Jaar}"<%}%></textarea></td>
                </tr>
                <tr>
                    <td><label>Acteurs/Actrices:</label></td>
                    <td><textarea rows="1" cols="75"><% if(null == session.getAttribute("Acteurs")){%><%}else{%>"${sessionScope.Acteurs}"<%}%></textarea></td>
                </tr>
                <tr>
                    <td class="inhoud"><label>Inhoud:</label></td>
                    <td><textarea rows="30" cols="75"><% if(null == session.getAttribute("Inhoud")){%><%}else{%>"${sessionScope.Inhoud}"<%}%></textarea></td>
                </tr>
            </table>
        </div>        
    </body>
</html>
