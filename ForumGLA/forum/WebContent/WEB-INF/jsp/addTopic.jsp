<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" xml:lang="en-gb"
	lang="en-gb">
	<head>
		<meta charset="UTF-8">
		<title>Ajout de message</title>
	</head>
	<body>
		<form action="", method='post'>
			<fieldset>
				<legend>Nouveau sujet de discussion :</legend>
				Sujet :
				<br/>
				<input type="text" name="subject" placeholder="Titre"/>
				<br/>
				Texte :
				<br/>
				<textarea rows="10" cols="75" name="messageContent" placeholder="Entrez votre texte ici..."></textarea>
				<br/>
				<input type="submit"/>
			</fieldset>
		</form>
	</body>
</html>