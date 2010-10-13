#====================================
#====================================
#====================================
from google.appengine.ext import webapp
import wsgiref.handlers

from google.appengine.ext import db
import Cookie
import random, datetime
from urllib import urlencode

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
#====================================
#====================================
class AllFunctions():

	def init_values(self):
		dna["login_email"]["control"] = "<input type='text' name='login_email' value='valuehere' class='wm' />"
		dna["login_email"]["caption"] = "Email"
		dna["login_email"]["value"] = ""
		dna["login_email"]["valid"] = True
		dna["login_email"]["invalid"] = "Email must be in a valid format."

		dna["login_password"]["control"] = "<input type='password' name='login_password' value='valuehere' class='wm' />"
		dna["login_password"]["caption"] = "Password"
		dna["login_password"]["value"] = ""
		dna["login_password"]["valid"] = True
		dna["login_password"]["invalid"] = "Password must not be empty."

		dna["retype_password"]["control"] = "<input type='password' name='retype_password' value='valuehere' class='wm' />"
		dna["retype_password"]["caption"] = "Retype Password"
		dna["retype_password"]["value"] = ""
		dna["retype_password"]["valid"] = True
		dna["retype_password"]["invalid"] = "Password and retype password do not match."

		dna["login_username"]["control"] = "<input type='text' name='login_username' value='valuehere' class='wm' />"
		dna["login_username"]["caption"] = "Username"
		dna["login_username"]["value"] = ""
		dna["login_username"]["valid"] = True
		dna["login_username"]["invalid"] = "Username must not be empty."

	#====================================
	#====================================
	#====================================
	def can_respond(self):
		return True;

	#====================================
	def get_cookie(self, in_key):
		return self.request.cookies.get(in_key, "")

	#====================================
	def set_cookie(self, in_key, in_value):
		o_cookie = Cookie.SimpleCookie()
		o_cookie[in_key] = in_value
		o_cookie[in_key]["expires"] = 3600*24*365
		o_cookie[in_key]["path"] = "/"
		print o_cookie

	#====================================
	def del_cookie(self, in_key):
		o_cookie = Cookie.SimpleCookie()
		o_cookie[in_key] = ""
		print v_cookie

	#====================================
	def generate_key(self):
		cs = "abcdefghijklmnopqrstuvwxyz0123456789"
		sb = []
		sb.append(cs[random.randint(0,25)])
		for i in range(19): sb.append(cs[random.randint(0,35)])
		return "".join(sb)

	#====================================
	def new_key(self, in_table, in_field):
		s_key = self.generate_key()
		rec = self.sql_select1("SELECT * FROM " + in_table + " WHERE " + in_field + " = '" + s_key + "'")
		if (rec is not None):
			s_key = self.generate_key()
			rec = self.sql_select1("SELECT * FROM " + in_table + " WHERE " + in_field + " = '" + s_key + "'")
			if (rec is not None):
				s_key = self.generate_key()
		return s_key

	#====================================
	def new_id(self, in_name):
		rec = self.sql_select1("SELECT * FROM NextId WHERE name = '" + in_name + "'")
		if (rec is None):
			rec = NextId()
			rec.name = in_name
			rec.value = 1000
		rec.value = rec.value + 1
		rec.put()
		return rec.value

	#====================================
	def last_id(self, in_name):
		rec = self.sql_select1("SELECT * FROM NextId WHERE name = '" + in_name + "'")
		if (rec is None):
			return 1000
		else:
			return rec.value

	#====================================
	#====================================
	#====================================
	def have_login(self, in_need_redirect):
		global g_login0
		answer = True
		if (g_login0 is None):
			s_cookie_key = self.get_cookie("ck")
			if (s_cookie_key ==  ""):
				answer = False
			else:
				rec = self.sql_select1("SELECT * FROM Login0 WHERE cookie_key = '" + s_skey + "'")
				if (rec is not None):
					answer = True
					g_login0 = rec
				else:
					answer = False
					if (in_need_redirect):
						self.rout(self, "/?a=login0")
		return answer





	#====================================
	#====================================
	#====================================
	def now(self):
		return datetime.datetime.now()

	#====================================
	def nowd(self):
		return datetime.date.today()

	#====================================
	def add_seconds(self, in_value, in_seconds):
		return in_value + datetime.timedelta(0,in_seconds)

	#====================================
	def datetime_val(self, in_string):
		answer = None
		try:
			answer = datetime.datetime.strptime(in_string, "%Y-%m-%d %H:%M:%S")
		except ValueError:
			try:
				answer = datetime.datetime.strptime(in_string, "%Y-%m-%d %H:%M")
			except ValueError:
				try:
					answer = datetime.datetime.strptime(in_string, "%Y-%m-%d")
				except ValueError:
					try:
						answer = datetime.datetime.strptime(in_string, "%m/%d/%Y %H:%M:%S")
					except ValueError:
						try:
							answer = datetime.datetime.strptime(in_string, "%m/%d/%Y %H:%M")
						except ValueError:
							try:
								answer = datetime.datetime.strptime(in_string, "%m/%d/%Y")
							except ValueError:
								try:
									answer = datetime.datetime.strptime(in_string, "%m/%d/%y %H:%M:%S")
								except ValueError:
									try:
										answer = datetime.datetime.strptime(in_string, "%m/%d/%y %H:%M")
									except ValueError:
										try:
											answer = datetime.datetime.strptime(in_string, "%m/%d/%y")
										except ValueError:
											answer = now()
		return answer
		
	#====================================
	def ddate6(self, in_value): return in_value.strftime("%Y-%m-%d %H:%M:%S")
	def ddate5(self, in_value): return in_value.strftime("%Y-%m-%d %H:%M")
	def ddate3(self, in_value): return in_value.strftime("%Y-%m-%d")
	def fdate6(self, in_value): return in_value.strftime("%m/%d/%Y %H:%M:%S")
	def fdate5(self, in_value): return in_value.strftime("%m/%d/%Y %H:%M")
	def fdate3(self, in_value): return in_value.strftime("%m/%d/%Y")

	#====================================
	def dnum0(self, in_value): return "%.0f" % in_value
	def dnum2(self, in_value): return "%.2f" % in_value

	#====================================
	def small_words(self, in_value):
		a_words = in_value.split(" ")
		sb = []
		for i in range(len(a_words)):
			s_word = a_words[i]
			l = len(s_word)
			if (l > 0):
				if (l > 30): s_word = s_word[0:30] + " " + s_word[30:]
				if (l > 60): s_word = s_word[0:60] + " " + s_word[60:]
				if (l > 90): s_word = s_word[0:90] + " " + s_word[90:]
				if (l > 120): s_word = s_word[0:120] + " " + s_word[120:]
				if (l > 150): s_word = s_word[0:150]
				if (i == 0): sb.append(s_word)
				else: sb.append(" " + s_word)
		return "".join(sb)

	#====================================
	def strip_string(self, in_value):
		return in_value.replace("'", "&#39;").replace('"', "&#34;").replace("(", "&#40;").replace(")", "&#41;").replace("<", "&#60;").replace(">", "&#62;").replace("    ", " ").replace("   ", " ").replace("  ", " ").replace("  ", " ").replace("  ", " ").strip()

	#====================================
	def strict_string(self, in_value, in_need_br = False):
		s = self.strip_string(self.small_words(in_value))
		if (in_need_br):
			s = s.replace("\r\n", "<br />").replace("<br /><br /><br /><br />", "<br />").replace("<br /><br /><br />", "<br />").replace("<br /><br />", "<br />").replace("<br /><br />", "<br />")
		return s

	#====================================
	def is_numeric(self, in_string):
		answer = True
		try:
			v_num = float(in_string)
		except ValueError:
			answer = False
		return answer

	#====================================
	def is_email(self, in_string):
		answer = True
		i_at = in_string.find("@")
		if (i_at < 1):
			answer = False
		else:
			i_dot = in_string.find(".", i_at)
			if (i_dot < 1): answer = False
		return answer
		
	#====================================
	def int_val(self, in_value):
		return int(round(float(in_value)))

	#====================================
	def float_val(self, in_value):
		return float(in_value)

	#====================================
	def input_raw(self, in_name, in_max_len):
		s = self.request.get(in_name)
		if (in_max_len > 0):
			if (len(s) > in_max_len): s = s[0:in_max_len]
		return s

	#====================================
	def input_text(self, in_name, in_max_len, in_need_br = False):
		s = self.strict_string(self.request.get(in_name), in_need_br)
		if (in_max_len > 0):
			if (len(s) > in_max_len): s = s[0:in_max_len]
		return s

	#====================================
	def input_multiple(self, in_name, in_max_len):
		a = self.request.get_all(in_name)
		ss = []
		for i in range(len(a)):
			s = self.strict_string(a[i])
			if (in_max_len > 0):
				if (len(s) > in_max_len): s = s[0:in_max_len]
			ss.append(s)
		return ss

	#====================================
	def input_split(self, in_name, in_max_len, in_separator):
		a = self.strict_string(self.request.get(in_name)).split(in_separator)
		ss = []
		for i in range(len(a)):
			s = a[i].strip()
			i_len = len(s)
			if (i_len > 0):
				if (in_max_len > 0):
					if (i_len > in_max_len): s = s[0:in_max_len]
				ss.append(s)
		return ss

	#====================================
	def input_checkbox(self, in_name):
		s = self.request.get(in_name)
		if (s == ""): return "0"
		else: return "1"

	#====================================
	def input_checkboxes(self, in_prefix):
		# Do unchecked boxes return their arguments?
		a = self.request.arguments()
		ss = []
		i_len = len(in_prefix)
		for i in range(len(a)):
			s = a[i]
			if (len(s) > i_len):
				if (s[0:i_len] == in_prefix):
					s = s[i_len:]
					if (len(s) < 50):
						ss.append(strict_string(s))
		return ss
		
	#====================================
	def input_int(self, in_name):
		s = self.input_raw(self, in_name, 20)
		if (self.is_numeric(s)):
			return str(int_val(s))
		else:
			return ""

	#====================================
	def input_float(self, in_name):
		s = self.input_raw(self, in_name, 20)
		if (self.is_numeric(s)):
			return str(float_val(s))
		else:
			return ""

	#====================================
	def input_datetime(self, in_name):
		s = self.input_text(in_name, 40)
		d = self.datetime_val(s)
		if (d is None):
			return ""
		else:
			return self.ddate6(d)

	#====================================
	def input_date(self, in_name):
		s = self.input_text(in_name, 40)
		d = self.datetime_val(s)
		if (d is None):
			return ""
		else:
			return self.ddate3(d)

	#====================================
	def input_url(self, in_name, in_value = ""):
		# This function can be used to validate in_value (set in_name = "")
		s = in_value
		if (in_name != ""): s = self.request.get(in_name)
		s = self.strip_string(s)
		if ((s != "") & (s[0:7] != "http://") & (s[0:8] != "https://")): s = "http://" + s
		if (len(s) > 300): s = s[0:300]
		return s

	#====================================
	def input_big(self, in_name, in_max_len = 0):
		# Like input_text, but allow big words.
		s = self.request.get(in_name)
		s = self.strip_string(s)
		if (in_max_len > 0):
			if (len(s) > in_max_len): s = s[0:in_max_len]
		return s

	#====================================
	def input_email(self, in_name):
		s = self.strip_string(self.request.get(in_name))
		if (self.is_email(s)): return s
		else: return ""

	#====================================
	def check_confirm(self):
		if (self.input_checkbox(self, "confirm") == "1"):
			return True
		else:
			self.walert(self, "You need to confirm your action.")
			return False

	#====================================
	def rint(self, in_number):
		x = float(in_number)
		y = long(x)
		z = x - y
		if (z < 0.5): return y
		else: return y + 1


	#====================================
	#====================================
	#====================================
	def sql_select1(self, in_sql):
		q = db.GqlQuery(in_sql + " limit 1")
		# get() returns one record or None.
		return q.get()

	#====================================
	def sql_select(self, in_sql, in_limit = 500, in_offset = 0):
		# GQL behavior: fetch will get up to the limit rows, then skip to offset and return the remainder.
		# Because of this, we better do limit and offset in the where clause.
		# The query string provides a limit clause and an offset clause.
		# OFFSET in a GQL query string does not reduce the number of entities fetched from the datastore.
		# It only affects which results are returned by the fetch() method.
		# recs = self.sql_select()
		# for rec in recs:
		q = db.GqlQuery(in_sql + " limit " + str(in_limit + in_offset))
		return q.fetch(in_limit, in_offset)

	#====================================
	def sql_delete(self, in_sql):
		q = db.GqlQuery(in_sql)
		recs = q.fetch(1000)
		for rec in recs:
			rec.delete()


	#====================================
	#====================================
	#====================================
	def do_logout(self):
		s_cookie_key = self.get_cookie("ck")
		if (s_cookie_key != ""):
			self.del_cookie("ck")
			rec = self.sql_select1("SELECT * FROM Login0 WHERE cookie_key = '" + s_cookie_key + "'")
			if (rec is not None):
				rec.cookie_key = ""
				rec.put()
		self.winfo(self, "You have logged out successfully.")

	#====================================
	def do_login0(self):
	#question0: what do you want?
	#answer = login0:
		#check: do you already have login?
		answer = self.have_login(False)
		if (answer):
		#answer = yes:
			global g_login0
			#show a link to logout
			self.winfo("You are logged in as " + g_login0.login_username + ".<br /><br />Do you want to switch your login? If yes, you need to <a href='/?a=logout'>log out</a> first.")
		else:
		#answer = no:
			#question1: what are your login_email and login_password?
			self.question_login1()

	#====================================
	def do_login1(self):
	#question1: what are your login_email and login_password?
	#answer = login1:
		#check: are login_email and login_password valid?
		answer0 = self.get_input("login_email")
		answer1 = self.get_input("login_password")
		if ((answer0 == false) | (answer1 == false)):
		#answer = 1 no:
			#goto: question1
			self.question_login1()
		else:
		#answer = yes:
			#select1: select * from Login1 using login_email
			global dna, g_invalid
			rec = self.sql_select1("SELECT * FROM Login1 WHERE login_email = '" + dna["login_email"]["value"] + "'")
			if (rec is None):
			#answer = no record:
				#set invalid message to login_email and login_password do not match
				g_invalid = "Email and password do not match.<br />Please try again."
				#goto: question2
				self.question_login2()
			else:
			#answer = yes record:
				#check: does given password match the record
				if (rec.login_password != dna[""]["value"]):
				#answer = no
					#increase login_wrongs
					rec.login_wongs = rec.login_wongs + 1
					rec.put()
					#set invalid message to login_email and login_password do not match
					g_invalid = "Email and password do not match.<br />Please try again."
					#goto: question2
					self.question_login2()
				else:
				#answer = yes
					#get a new cookie_key
					s_cookie_key = self.new_key("Login0", "cookie_key")
					#set cookie_key to cookie
					self.set_cookie("ck", s_cookie_key)
					#create a new session
					i_login_id = rec.login_id
					rec = self.sql_select1("SELECT * FROM Login0 WHERE login_id = " + str(i_login_id))
					if (rec is None):
						self.werror("Log in failed.")
					else:
						rec.cookie_key = s_cookie_key
						rec.put()
						global g_login0
						g_login0 = rec

	#====================================
	def do_register0(self):
	#question0: what do you want?
	#answer = register0:
		#check: do you already have login?
		answer = self.have_login(False)
		if (answer):
		#answer = yes:
			global g_login0
			#show a link to logout
			self.winfo("You are logged in as " + g_login0.login_username + ".<br /><br />Do you want to logout first before doing a new register? If yes, click here to <a href='/?a=logout'>log out</a>.")
		else:
		#answer = no:
			#question1: what are your login_email, login_password, retype_password, login_username?
			self.question_register1()

	#====================================
	def do_register1(self):
	#question1: what are your login_email, login_password, retype_password, login_username?
	#answer = register1:
		#check: are the login_email, login_password, retype_password, login_username valid?
		answer0 = self.get_input("login_email")
		answer1 = self.get_input("login_password")
		answer2 = self.get_input("retype_password")
		answer3 = self.get_input("login_username")
		if ((answer0 == False) | (answer1 == False) | (answer2 == False) | (answer3 == False)):
		#answer = 1 no:
			#goto: question1
			self.question_register1();
		else:
		#answer = yes:
			#check: does login_email already exist?
			global dna
			rec = self.sql_select1("SELECT * FROM Login1 WHERE login_email = '" + dna["login_email"]["value"] + "'")
			if (rec is not None):
			#answer = yes:
				#set valid = false
				dna["login_email"]["valid"] = False
				#change invalid message
				dna["login_email"]["invalid"] = "This email already exists. Please choose another one."
				#goto: question1
				self.question_register1();
			else:
			#answer = no:
				#check: does login_username already exist?
				rec = self.sql_select1("SELECT * FROM Login1 WHERE login_username = '" + dna["login_username"]["value"] + "'")
				if (rec is not None):
				#answer = yes:
					#set valid = false
					dna["login_username"]["valid"] = False
					#change invalid message
					dna["login_username"]["invalid"] = "This username already exists. Please choose another one."
					#goto: question1
					self.question_register1()
				else:
				#answer = no:
					#set login_kind = empty
					s_login_kind = ""
					#set login_until = now + 3 months
					d_login_until = self.add_seconds(self.now(), 60*60*24*92)
					#get a new cookie_key
					s_cookie_key = self.new_key("Login0", "cookie_key")
					#set cookie_key to cookie
					self.set_cookie("ck", s_cookie_key)
					# get a new login_id
					i_login_id = self.new_id("Login0")
					#create a new Login1
					rec = Login1()
					rec.login_id = i_login_id
					rec.login_email = dna["login_email"]["value"]
					rec.login_password = dna["login_password"]["value"]
					rec.login_wrongs = 0
					rec.put()
					#create a new Login0
					rec = Login0()
					rec.login_id = i_login_id
					rec.login_kind = s_login_kind
					rec.login_username = dna["login_username"]["value"]
					rec.login_until = d_login_until
					rec.cookie_key = s_cookie_key
					rec.put()
					#set this session
					global g_login0
					g_login0 = rec
					#winfo: register successful
					self.winfo("You have registered successfully.")





					
	#====================================
	#====================================
	#====================================
	def question_login1(self):
		a_names = ["login_email", "login_password"]
		self.init_values()
		s = self.get_form("post", "login", "login1", "Log In", a_names)
		self.whtml(s)

	#====================================
	def question_register1(self):
		a_names = ["login_email", "login_password", "retype_password", "login_username"]
		self.init_values()
		s = self.get_form("post", "login.php", "register1", "Simple Register Form", a_names)
		self.whtml(s)

		



















		
		
		
		
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
		
	#====================================
	#====================================
	#====================================
	def wln(self, in_value): self.response.out.write("<p>" + in_value + "</p>")
	def btw(self, in_value): self.response.out.write("<p>>" + in_value + "<</p>")

	#====================================
	def url_encode(self, in_name, in_value): return urlencode({in_name:in_value.encode("utf-8")})
	def winfo(self, in_value): self.redirect("/?a=info&" + url_encode("m", in_value))
	def walert(self, in_value): self.redirect("/?a=alert&" + url_encode("m", in_value))
	def werror(self, in_value): self.redirect("/?a=error&" + url_encode("m", in_value))
	def rout(self, in_url): self.redirect(in_url)
		
	#====================================
	def winfo_out(self):
		m = self.input_text("m", 1000)
		s = """<h2>Message</h2>
<br />
<h4>""" + m + """</h4>
<br />
Click the Back button to go back.
"""
		self.whtml(s)

	#====================================
	def do_alert(self):
		m = self.input_text("m", 1000)
		s = """<h2 class="alert">Alert: Correction Needed!</h2>
<br />
<h4>""" + m + """</h4>
<br />
Click the Back button to go back.
"""
		self.whtml(s)

	#====================================
	def do_error(self):
		m = self.input_text("m", 1000)
		s = """<h2 class="error">Error! Something is wrong!</h2>
<br />
<h4>""" + m + """</h4>
<br />
This is an application error. This is NOT a user's error.
<br /><br />
Click the Back button to go back.
"""
		self.whtml(s)
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	#====================================
	def get_input(self, in_name):
		global dna;
		answer = True;
		if (in_name == "login_email"):
			dna[in_name]["value"] = self.input_email(self, in_name)
			if (dna[in_name]["value"] == ""):
				dna[in_name]["value"] = self.input_text(in_name, 100)
				answer = False
		elif (in_name == "login_password"):
			dna[in_name]["value"] = self.input_text(in_name, 50)
			if (dna[in_name]["value"] == ""):
				answer = False
		elif (in_name == "retype_password"):
			dna[in_name]["value"] = self.input_text(in_name, 50)
			if (dna[in_name]["value"] != dna["login_password"]["value"]):
				answer = False
		elif (in_name == "login_username"):
			dna[in_name]["value"] = self.input_text(in_name, 50)
			if (dna[in_name]["value"] == ""):
				answer = False
		dna[in_name]["valid"] = answer
		return answer

	#====================================
	def val(self, in_name):
		global dna
		return dna[in_name]["value"]

	#====================================
	def get_form(self, in_method, in_action, in_answer, in_title, in_names, in_class = "", in_submit = "", in_image = ""):
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
			s_control = dna[s_name]["control"].replace("valuehere", s_value)
			if (dna[s_name]["valid"]):
				s_warn = "<span class='warn'><br />" + dna[s_name]["invalid"] + "</span>"
			sb.append("<tr><td>" + dna[s_name]["caption"] + "</td><td>" + s_control + s_warn + "</td></tr>")
		sb.append("<tr><td>&nbsp;</td><td>" + s_submit + "</td></tr></form></table>")
		return "".join(sb)
		
		
	#====================================
	def do_index(self):
		s = """
Hello, world.
<br /><br />
Click here to <a href='/?a=login0'>login</a>
"""
		self.whtml(s)
		
		
		
#====================================
#====================================
#====================================
class MainPage(webapp.RequestHandler, AllFunctions):
	
	#====================================
	def post(self):
		# Treat post and get the same.
		self.get()

	#====================================
	def get(self):
		if (self.can_respond()):
			# what do you want?
			a = self.input_text("a", 30)
			if (a == "info"):
				self.winfo_out();
			elif (a == "alert"):
				self.walert_out();
			elif (a == "error"):
				self.werror_out();
			elif (a == "login0"):
				self.do_login0();
			elif (a == "login1"):
				self.do_login1();
			elif (a == "register0"):
				self.do_register0();
			elif (a == "register1"):
				self.do_register1();
			else:
				self.do_index();


#====================================
def main():
	# Route all requests to MainPage.
	application = webapp.WSGIApplication([("/.*", MainPage)], debug=True)
	wsgiref.handlers.CGIHandler().run(application)

if __name__ == "__main__": main()
