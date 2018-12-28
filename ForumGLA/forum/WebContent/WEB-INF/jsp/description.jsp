<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" xml:lang="en-gb"
	lang="en-gb">
	<head>
	
	<title>Description de <c:out value ="${param['login']}"/></title>
	
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
					<table class="tablebg" cellspacing="1" width="100%">
						<tbody>
							<tr>
								<th colspan="2"><c:out value ="Profil de ${param['login']}"/></th>
							</tr>
	
							<tr>
								<td class="row2">
	
									<table style="width: 100%;" cellspacing="1" cellpadding="4" align="center">
										<tbody>
											<tr>
												<td valign="top">
													<b class="gensmall">Pr&eacute;nom : <c:if test="${user.prenom != ''}"><c:out value="${user.prenom}"/></c:if>
													</b>
												</td>
											</tr>
											<tr>
												<td valign="top">
													<b class="gensmall">Nom : <c:if test="${user.nom != ''}"><c:out value="${user.nom}"/></c:if>
													</b>
												</td>
											</tr>
											<tr>
												<td valign="top">
													<b class="gensmall">Age : <c:if test="${user.age > 0}"><c:out value="${user.age}"/></c:if>
													</b>
												</td>
											</tr>
											<tr>
												<td valign="top">
													<b class="gensmall">Description : <c:if test="${user.description != ''}"><c:out value="${user.description}"/></c:if>
													</b>
												</td>
											</tr>
	
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>

				<table class="tablebg" style="margin-top: 5px;" cellspacing="1"
					cellpadding="0" width="100%">
					<tbody>
						<tr>
							<td class="row1">
								<c:if test="${param['login'] == username}">
								<a href="/forum/modif"><p class="breadcrumbs">Modification du profil</p></a>
								<br/>
								<br/>
								</c:if>
								<a href="/forum/home"><p class="breadcrumbs">Index du forum</p></a>
							</td>
						</tr>
					</tbody>
				</table>
		</div>
	</body>
</html>
