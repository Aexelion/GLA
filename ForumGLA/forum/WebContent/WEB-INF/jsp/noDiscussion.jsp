<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" xml:lang="en-gb"
	lang="en-gb">
	<head>
	
	<title>Aucune discussion</title>
	
	
	
	<link rel="stylesheet" href="fichiers/style.css" type="text/css" />
	
	</head>
	<body class="ltr">
	
		<div id="wrapcentre">
	
	
	
			<div id="pagecontent">
	
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
	
				<br clear="all" />
				
	
				<br clear="all" />
	
				<table class="tablebg" cellspacing="1" width="100%">
					<tbody>
						<tr class="row2">
	
							<td valign="middle" align="center"><b class="postauthor">Admin tout puissant</b>
							</td>
							<td width="100%" height="25">
								<table cellspacing="0" width="100%">
									<tbody>
										<tr>
	
											<td class="gensmall" width="100%">
												<div style="float: left;">&nbsp;
													<b>Fil de discussion :</b> Ceci n'est pas une discussion. Ceci est un easter egg !!
												</div>
												<div style="float: right;">
													<b>Posted:</b> 20 Niv&ocirc;se, an CCII&nbsp;
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
	
					<tr class="row2">
	
						<td class="profile" valign="top">
							<table cellspacing="4" align="center" width="150">
	
							</table> <span class="postdetails"> <b>Posts:</b> 0
						</span>
	
						</td>
						<td valign="top">
							<table cellspacing="5" width="100%">
								<tbody>
									<tr>
										<td>
											<div class="postbody">Ceci n'est pas une discussion, pour voir l'ensemble des discussions valides :<br/>
											<a href=/forum/home>&gt;cliquez ici&lt;</a>
											</div>
											<br clear="all" /><br />
											<table cellspacing="0" width="100%">
												<tbody>
													<tr valign="middle">
														<td class="gensmall" align="right"></td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
	
					<tr>
						<td class="spacer" colspan="2" height="1"><img src="fichiers/spacer.gif" alt="" width="1" height="1" /></td>
					</tr>
				</table>
	
	
			</div>
		
			<br clear="all" />
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
