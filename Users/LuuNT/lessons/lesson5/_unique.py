from google.appengine.ext import db
from _common import *

#====================================
#====================================
#====================================
class NextId(db.Model):
	name = db.StringProperty()
	value = db.IntegerProperty()

#====================================
class Login0(db.Model):
	login_id = db.IntegerProperty()
	login_kind = db.StringProperty()
	login_username = db.StringProperty()
	login_until = db.DateTimeProperty()
	cookie_key = db.StringProperty()

#====================================
class Login1(db.Model):
	login_id = db.IntegerProperty()
	login_email = db.StringProperty()
	login_password = db.StringProperty()
	login_wrongs = db.IntegerProperty()

#====================================
#====================================
#====================================
#App Engine seems to cache these objects. Therefore, always update the reference when the database changes.
#For example, after us_do_login(), g_login0 is not None.
#If we visit other pages, this line g_login0 = None does not return g_login0 to None. Instead, the old object g_login0 is alive.
g_login0 = None
g_invalid = ""

#====================================
dna = {}
dna["login_email"] = {}
dna["login_email"]["control"] = "<input type='text' name='login_email' value='valuehere' class='wm' />"
dna["login_email"]["caption"] = "Email"
dna["login_email"]["value"] = ""
dna["login_email"]["valid"] = True
dna["login_email"]["invalid"] = "Email must be in a valid format."

dna["login_password"] = {}
dna["login_password"]["control"] = "<input type='password' name='login_password' value='valuehere' class='wm' />"
dna["login_password"]["caption"] = "Password"
dna["login_password"]["value"] = ""
dna["login_password"]["valid"] = True
dna["login_password"]["invalid"] = "Password must not be empty."

dna["retype_password"] = {}
dna["retype_password"]["control"] = "<input type='password' name='retype_password' value='valuehere' class='wm' />"
dna["retype_password"]["caption"] = "Retype Password"
dna["retype_password"]["value"] = ""
dna["retype_password"]["valid"] = True
dna["retype_password"]["invalid"] = "Password and retype password do not match."

dna["login_username"] = {}
dna["login_username"]["control"] = "<input type='text' name='login_username' value='valuehere' class='wm' />"
dna["login_username"]["caption"] = "Username"
dna["login_username"]["value"] = ""
dna["login_username"]["valid"] = True
dna["login_username"]["invalid"] = "Username must not be empty."

#====================================
def get_input(self, in_name):
	global dna;
	answer = True;
	if (in_name == "login_email"):
		dna[in_name]["value"] = input_email(self, in_name)
		if (dna[in_name]["value"] == ""):
			dna[in_name]["value"] = input_text(self, in_name, 100)
			answer = False
	elif (in_name == "login_password"):
		dna[in_name]["value"] = input_text(self, in_name, 50)
		if (dna[in_name]["value"] == ""):
			answer = False
	elif (in_name == "retype_password"):
		dna[in_name]["value"] = input_text(self, in_name, 50)
		if (dna[in_name]["value"] != dna["login_password"]["value"]):
			answer = False
	elif (in_name == "login_username"):
		dna[in_name]["value"] = input_text(self, in_name, 50)
		if (dna[in_name]["value"] == ""):
			answer = False
	dna[in_name]["valid"] = answer
	return answer

#====================================
def val(in_name):
	global dna
	return dna[in_name]["value"]

#====================================
def get_form(in_method, in_action, in_answer, in_title, in_names, in_class = "", in_submit = "", in_image = ""):
	global g_invalid
	if (g_invalid != ""):
		g_invalid = "<span class='warn'><br />" + g_invalid + "</span>"
	
	s_spacing = "0"
	if (in_class == ""):
		in_class = "form"
		s_spacing = "1"
	if ((in_submit == "") & (in_image == "")):
		in_submit = "Submit"
	if (in_image == ""):
		s_submit = "<input type='submit' value='" + in_submit + "' />"
	else:
		s_submit = "<input type='image' src='" + in_image + "' />"
	
	s = "<table class='" + in_class + "' cellspacing='" + s_spacing + "'><form method='" + in_method + "' action='" + in_action + "'><input type='hidden' name='a' value='" + in_answer + "' /><tr><th colspan='2'>" + in_title + g_invalid + "</th></tr>"

	global dna
	sb = []
	for s_name in in_names:
		s_value = dna[s_name]["value"]
		s_control = replace(dna[s_name]["control"], "valuehere", s_value)
		if (p_dna[s_name]["valid"]):
			s_warn = "<span class='warn'><br />" + dna[s_name]["invalid"] + "</span>"
		sb.append("<tr><td>" + dna[s_name]["caption"] + "</td><td>" + s_control + s_warn + "</td></tr>")
	sb.append("<tr><td>&nbsp;</td><td>" + s_submit + "</td></tr></form></table>")
	return "".join(sb)

#====================================
def whtml(self, in_content, in_title = ""):
	if (in_title == ""): in_title = "Good"	
	s = """
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>{s_title}</title>
<link rel="stylesheet" href="f/style.css" type="text/css" media="screen" />
</head>
<body>
<div class="body">
	<div class="header">
		this is header
	</div>
	<div class="content">
		<div class="cleft">this is left</div>
		<div class="ccenter">""" + in_content + """</div>
		<div class="cright">this is right</div>
		<div class="clear">&nbsp;</div>
	</div>
	<div class="footer">this is footer</div>
</div>
</body>
</html>
"""
	self.response.out.write(s)

