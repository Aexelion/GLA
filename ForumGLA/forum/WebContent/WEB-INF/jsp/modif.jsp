<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" xml:lang="en-gb"
	lang="en-gb">
	<head>
	
	<title>Modification du profil</title>
	
	<link rel="stylesheet" href="fichiers/style.css" type="text/css" />
	</head>
	<body class="ltr">
		<div id="wrapcentre">
		
			<table class="tablebg" style="margin-top: 5px;" cellspacing="1"
					cellpadding="0" width="100%">
					<tbody>
						<tr>
							<td class="row1">
								<p class="breadcrumbs">
								<c:choose>
								<c:when test = "${empty username}">
									<a href="/forum/login">Non connect&eacute;</a>
								</c:when>
								<c:otherwise>
									Connect&eacute; <a href="/forum/profil?login=<c:out value="${username}"/>"><c:out value ="${username}"/></a>
									<br/>
									<a href="/forum/logout">D&eacute;connection</a>
								</c:otherwise>
								</c:choose>
								</p>
							</td>
						</tr>
					</tbody>
				</table>
	
			<br style="clear: both;" />
				<br />
					<form action="/forum/modif" method="post">
						<table class="tablebg" cellspacing="1" width="100%">
							<tbody>
								<tr>
									<th colspan="2"><c:out value ="Modification du profil de ${username}"/></th>
								</tr>
		
								<tr>
									<td class="row2">
		
										<table style="width: 100%;" cellspacing="1" cellpadding="4" align="center">
											<tbody>
												<tr>
													<td valign="top">
														<b class="gensmall">Pr&eacute;nom : </b>
													</td>
													<td><input class="post" name="prenom" size="25" type="text" value="<c:if test="${user.prenom != ''}"><c:out value="${user.prenom}"/></c:if>" /></td>
												</tr>
												<tr>
													<td valign="top">
														<b class="gensmall">Nom : </b>
													</td>
													<td><input class="post" name="nom" size="25" type="text" value="<c:if test="${user.nom != ''}"><c:out value="${user.nom}"/></c:if>" /></td>
												</tr>
												<tr>
													<td valign="top">
														<b class="gensmall">Age : </b>
													</td>
													<td><input class="post" name="age" type="number" min="1" value="<c:if test="${user.age > 0}"><c:out value="${user.age}"/></c:if>" /></td>
												</tr>
												<tr>
													<td valign="top">
														<b class="gensmall">Description : </b>
													</td>
													<td><textarea rows="10" cols="64" name="descr" placeholder="Entrez votre description ici..." ><c:if test="${user.description != ''}"><c:out value="${user.description}"/></c:if></textarea></td>
												</tr>
												<tr>
													<td>
														<input type="submit" value="Mettre à jour le profil" />
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				<table class="tablebg" style="margin-top: 5px;" cellspacing="1"
					cellpadding="0" width="100%">
					<tbody>
						<tr>
							<td class="row1">
								<a href="/forum/home"><p class="breadcrumbs">Index du forum</p></a>
							</td>
						</tr>
					</tbody>
				</table>
		</div>
	</body>
</html>
