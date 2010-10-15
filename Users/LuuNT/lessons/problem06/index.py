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
class Login(db.Model):
	login_id = db.IntegerProperty()
	cookie_key = db.StringProperty()
	login_kind = db.IntegerProperty()
	login_email = db.StringProperty()
	login_password = db.StringProperty()
	login_username = db.StringProperty()
	login_until = db.DateTimeProperty()
	login_wrongs = db.IntegerProperty()

#====================================
class PicLink(db.Model):
	login_id = db.IntegerProperty()
	piclink_id = db.IntegerProperty()
	piclink_time = db.DateTimeProperty()
	piclink_url = db.StringProperty()

#====================================
#====================================
#====================================
#App Engine seems to cache these objects. Therefore, always update the reference when the database changes.
#For example, after us_do_login(), g_login is not None.
#If we visit other pages, this line g_login = None does not return g_login to None. Instead, the old object g_login is alive.
g_login = None
g_invalid = ""

#====================================
dna = {}
dna["login_email"] = {}
dna["login_password"] = {}
dna["retype_password"] = {}
dna["login_username"] = {}
dna["piclink_id"] = {}
dna["piclink_url"] = {}



	
#====================================
#====================================
#====================================
class AllFunctions():

	def init_values(self):
		global dna, g_invalid
		g_invalid = ""

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

		dna["piclink_id"]["control"] = "<input type='hidden' name='piclink_id' value='valuehere' />"
		dna["piclink_id"]["caption"] = ""
		dna["piclink_id"]["value"] = ""
		dna["piclink_id"]["valid"] = True
		dna["piclink_id"]["invalid"] = ""

		dna["piclink_url"]["control"] = "<input type='text' name='piclink_url' value='valuehere' class='wm' />"
		dna["piclink_url"]["caption"] = "Picture Url"
		dna["piclink_url"]["value"] = ""
		dna["piclink_url"]["valid"] = True
		dna["piclink_url"]["invalid"] = "Url must be valid."

		
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
		o_cookie[in_key] = "aaa"
		print o_cookie

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
	def have_login(self):
		global g_login
		result = False
		if (g_login is not None):
			result = True
		else:
			s_cookie_key = self.get_cookie("ck")
			if (s_cookie_key !=  ""):
				rec = self.sql_select1("SELECT * FROM Login WHERE cookie_key = '" + s_cookie_key + "'")
				if (rec is not None):
					result = True
					g_login = rec
		return result

	#====================================
	def prompt_login(self):
		result = self.have_login()
		if (result == False):
			self.rout("/?answer=login0")
		return result

	#====================================
	def prompt_admin(self):
		result = self.prompt_login()
		if (result == True):
			global g_login
			if (g_login.login_kind != 99):
				result = False
				self.walert("You do not have authority. Please <a href='/?answer=logout'>log out</a> and use another login with authority.")
		return result



	#====================================
	#====================================
	#====================================
	def now(self):
		return datetime.datetime.now()

	#====================================
	def nowd(self):
		return datetime.date.today()

	#====================================
	def equal_dates6(self, in_date1, in_date2):
		s1 = self.ddate6(in_date1)
		s2 = self.ddate6(in_date2)
		return (s1 == s2)

	#====================================
	def equal_dates3(self, in_date1, in_date2):
		s1 = self.ddate3(in_date1)
		s2 = self.ddate3(in_date2)
		return (s1 == s2)

	#====================================
	def add_seconds(self, in_value, in_seconds):
		return in_value + datetime.timedelta(0,in_seconds)

	#====================================
	def datetime_val(self, in_string):
		result = None
		try:
			result = datetime.datetime.strptime(in_string, "%Y-%m-%d %H:%M:%S")
		except ValueError:
			try:
				result = datetime.datetime.strptime(in_string, "%Y-%m-%d %H:%M")
			except ValueError:
				try:
					result = datetime.datetime.strptime(in_string, "%Y-%m-%d")
				except ValueError:
					try:
						result = datetime.datetime.strptime(in_string, "%m/%d/%Y %H:%M:%S")
					except ValueError:
						try:
							result = datetime.datetime.strptime(in_string, "%m/%d/%Y %H:%M")
						except ValueError:
							try:
								result = datetime.datetime.strptime(in_string, "%m/%d/%Y")
							except ValueError:
								try:
									result = datetime.datetime.strptime(in_string, "%m/%d/%y %H:%M:%S")
								except ValueError:
									try:
										result = datetime.datetime.strptime(in_string, "%m/%d/%y %H:%M")
									except ValueError:
										try:
											result = datetime.datetime.strptime(in_string, "%m/%d/%y")
										except ValueError:
											result = now()
		return result
		
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
		result = True
		try:
			v_num = float(in_string)
		except ValueError:
			result = False
		return result

	#====================================
	def is_email(self, in_string):
		result = True
		i_at = in_string.find("@")
		if (i_at < 1):
			result = False
		else:
			i_dot = in_string.find(".", i_at)
			if (i_dot < 1): result = False
		return result
		
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
		s = self.input_raw(in_name, 20)
		if (self.is_numeric(s)):
			return str(self.int_val(s))
		else:
			return ""

	#====================================
	def input_float(self, in_name):
		s = self.input_raw(in_name, 20)
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
			self.walert("You need to confirm your action.")
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
		global g_login
		if (g_login is not None):
			g_login = None
		s_cookie_key = self.get_cookie("ck")
		if (s_cookie_key != ""):
			self.del_cookie("ck")
			rec = self.sql_select1("SELECT * FROM Login WHERE cookie_key = '" + s_cookie_key + "'")
			if (rec is not None):
				rec.cookie_key = ""
				rec.put()
		self.winfo("You have successfully logged out.")
		

	#====================================
	def do_login0(self):
	#question0: what do you want?
	#answer0 = login0:
		#check: do you already have login?
		result = self.have_login()
		if (result):
		#result = yes:
			global g_login
			#show a link to logout
			self.winfo("You are logged in as " + g_login.login_username + ".<br /><br />Do you want to switch your login? If yes, you need to <a href='/?answer=logout'>log out</a> first.")
		else:
		#result = no:
			#question1: what are your login_email and login_password?
			self.question_login1()

	#====================================
	def do_login1(self):
	#question1: what are your login_email and login_password?
	#answer1 = login1:
		#check: are login_email and login_password valid?
		result0 = self.get_input("login_email")
		result1 = self.get_input("login_password")
		if ((result0 == False) | (result1 == False)):
		#result = 1 no:
			#goto: question1
			self.question_login1()
		else:
		#result = yes:
			#select1: select * from Login using login_email
			global dna, g_invalid
			rec = self.sql_select1("SELECT * FROM Login WHERE login_email = '" + dna["login_email"]["value"] + "'")
			if (rec is None):
			#result = no record:
				#set invalid message to login_email and login_password do not match
				g_invalid = "Email and password do not match.<br />Please try again."
				#goto: question1
				self.question_login1()
			else:
			#result = yes record:
				#check: does given password match the record
				if (rec.login_password != dna["login_password"]["value"]):
				#result = no
					#increase login_wrongs
					rec.login_wrongs = rec.login_wrongs + 1
					rec.put()
					#set invalid message to login_email and login_password do not match
					g_invalid = "Email and password do not match.<br />Please try again."
					#goto: question1
					self.question_login1()
				else:
				#result = yes
					#get a new cookie_key
					s_cookie_key = self.new_key("Login", "cookie_key")
					#set cookie_key to cookie
					self.set_cookie("ck", s_cookie_key)
					#create a new session
					rec.cookie_key = s_cookie_key
					rec.put()
					global g_login
					g_login = rec
					#winfo: login successful
					self.winfo("You have logged in successfully. Click here to go to <a href='/'>home page.</a>")

	#====================================
	def do_register0(self):
	#question0: what do you want?
	#answer0 = register0:
		#check: do you already have login?
		result = self.have_login()
		if (result):
		#result = yes:
			global g_login
			#show a link to logout
			self.winfo("You are logged in as " + g_login.login_username + ".<br /><br />Do you want to logout first before doing a new register? If yes, click here to <a href='/?answer=logout'>log out</a>.")
		else:
		#result = no:
			#question1: what are your login_email, login_password, retype_password, login_username?
			self.question_register1()

	#====================================
	def do_register1(self):
	#question1: what are your login_email, login_password, retype_password, login_username?
	#answer1 = register1:
		#check: are the login_email, login_password, retype_password, login_username valid?
		result0 = self.get_input("login_email")
		result1 = self.get_input("login_password")
		result2 = self.get_input("retype_password")
		result3 = self.get_input("login_username")
		if ((result0 == False) | (result1 == False) | (result2 == False) | (result3 == False)):
		#result = 1 no:
			#goto: question1
			self.question_register1();
		else:
		#result = yes:
			#check: does login_email already exist?
			global dna
			rec = self.sql_select1("SELECT * FROM Login WHERE login_email = '" + dna["login_email"]["value"] + "'")
			if (rec is not None):
			#result = yes:
				#set valid = false
				dna["login_email"]["valid"] = False
				#change invalid message
				dna["login_email"]["invalid"] = "This email already exists. Please choose another one."
				#goto: question1
				self.question_register1();
			else:
			#result = no:
				#check: does login_username already exist?
				rec = self.sql_select1("SELECT * FROM Login WHERE login_username = '" + dna["login_username"]["value"] + "'")
				if (rec is not None):
				#result = yes:
					#set valid = false
					dna["login_username"]["valid"] = False
					#change invalid message
					dna["login_username"]["invalid"] = "This username already exists. Please choose another one."
					#goto: question1
					self.question_register1()
				else:
				#result = no:
					#set login_kind = 0
					i_login_kind = 0
					#set login_until = now + 3 months
					d_login_until = self.add_seconds(self.now(), 60*60*24*92)
					#get a new cookie_key
					s_cookie_key = self.new_key("Login", "cookie_key")
					#set cookie_key to cookie
					self.set_cookie("ck", s_cookie_key)
					# get a new login_id
					i_login_id = self.new_id("Login")
					#create a new Login
					rec = Login()
					rec.login_id = i_login_id
					rec.cookie_key = s_cookie_key
					rec.login_kind = i_login_kind
					rec.login_email = dna["login_email"]["value"]
					rec.login_password = dna["login_password"]["value"]
					rec.login_username = dna["login_username"]["value"]
					rec.login_until = d_login_until
					rec.login_wrongs = 0
					rec.put()
					#set this session
					global g_login
					g_login = rec
					#winfo: register successful
					self.winfo("You have registered successfully.")





					
	#====================================
	#====================================
	#====================================
	def question_login1(self):
		a_names = ["login_email", "login_password"]
		s = self.get_form("post", "/", "login1", "Log In", a_names)
		self.whtml(s)

	#====================================
	def question_register1(self):
		a_names = ["login_email", "login_password", "retype_password", "login_username"]
		s = self.get_form("post", "/", "register1", "Simple Register Form", a_names)
		self.whtml(s)

		



















		
		
		
		
	#====================================
	def whtml(self, in_content, in_title = ""):
		s_login = ""
		if (self.have_login()):
			global g_login
			s_login = "Hello, " + g_login.login_username + ". <a href='/?answer=logout'>log out</a> | <a href='/?answer=insert_piclink'>Insert Pic Link</a> | <a href='/?answer=select_piclink'>Select Pic Links</a>"
			if (g_login.login_kind == 99):
				s_login = s_login + " <a href='/?answer=login_list'>List Logins</a>"
		else:
			s_login = "<a href='/?answer=login0'>log in</a>"
		
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
		this is header <a href="/">home</a> """ + s_login + """
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
	def winfo(self, in_value): self.redirect("/?answer=info&" + self.url_encode("m", in_value))
	def walert(self, in_value): self.redirect("/?answer=alert&" + self.url_encode("m", in_value))
	def werror(self, in_value): self.redirect("/?answer=error&" + self.url_encode("m", in_value))
	def rout(self, in_url): self.redirect(in_url)
		
	#====================================
	def winfo_out(self):
		m = self.input_raw("m", 1000)
		s = """<h2>Message</h2>
<br />
<h4>""" + m + """</h4>
<br />
Click the Back button to go back.
"""
		self.whtml(s)

	#====================================
	def walert_out(self):
		m = self.input_raw("m", 1000)
		s = """<h2 class="alert">Alert: Correction Needed!</h2>
<br />
<h4>""" + m + """</h4>
<br />
Click the Back button to go back.
"""
		self.whtml(s)

	#====================================
	def werror_out(self):
		m = self.input_raw("m", 1000)
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
	def wconfirm(self, in_answer, in_id_name, in_id_value):
		m = self.input_raw("m", 1000)
		s = """<h2>Confirmation</h2>
<br />
<h4>Are you sure?</h4>
<br />
Answer: <a href='/?confirm=yes&answer=""" + in_answer + """&""" + in_id_name + """=""" + in_id_value + """'>Yes</a> / <a href='/?confirm=no&answer=""" + in_answer + """&""" + in_id_name + """=""" + in_id_value + """'>No</a>
"""
		self.whtml(s)
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	#====================================
	def get_input(self, in_name):
		global dna;
		result = True;
		if (in_name == "login_email"):
			dna[in_name]["value"] = self.input_email(in_name)
			if (dna[in_name]["value"] == ""):
				dna[in_name]["value"] = self.input_text(in_name, 100)
				result = False
		elif (in_name == "login_password"):
			dna[in_name]["value"] = self.input_text(in_name, 50)
			if (dna[in_name]["value"] == ""):
				result = False
		elif (in_name == "retype_password"):
			dna[in_name]["value"] = self.input_text(in_name, 50)
			if (dna[in_name]["value"] != dna["login_password"]["value"]):
				result = False
		elif (in_name == "login_username"):
			dna[in_name]["value"] = self.input_text(in_name, 50)
			if (dna[in_name]["value"] == ""):
				result = False
		elif (in_name == "piclink_id"):
			dna[in_name]["value"] = self.input_int(in_name)
			if (dna[in_name]["value"] == ""):
				result = False
		elif (in_name == "piclink_url"):
			dna[in_name]["value"] = self.input_url(in_name)
			if (dna[in_name]["value"] == ""):
				result = False
		else:
			dna[in_name]["value"] = self.input_text(in_name, 200)
			if (dna[in_name]["value"] == ""):
				result = False
		dna[in_name]["valid"] = result
		return result

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
		
		global dna
		sb = []
		sb.append("<table class='" + in_class + "' cellspacing='" + s_spacing + "'><form method='" + in_method + "' action='" + in_action + "'><input type='hidden' name='answer' value='" + in_answer + "' /><tr><th colspan='2'>" + in_title + g_invalid + "</th></tr>")
		for s_name in in_names:
			s_value = dna[s_name]["value"]
			s_control = dna[s_name]["control"].replace("valuehere", s_value)
			s_warn = ""
			if (dna[s_name]["valid"] == False):
				s_warn = "<span class='warn'><br />" + dna[s_name]["invalid"] + "</span>"
			if (s_control[0:20] == "<input type='hidden'"):
				sb.append(s_control)
			else:
				sb.append("<tr><td>" + dna[s_name]["caption"] + "</td><td>" + s_control + s_warn + "</td></tr>")
		sb.append("<tr><td>&nbsp;</td><td>" + s_submit + "</td></tr></form></table>")
		return "".join(sb)
		
		
	#====================================
	def do_index(self):
		s = """
Hello, world.
<br /><br />
Click here to <a href='/?answer=login0'>login</a>
<br /><br />
Click here to <a href='/?answer=register0'>register</a>
"""
		self.whtml(s)
		
	#====================================
	def do_add_admin(self):
		rec = self.sql_select1("SELECT * FROM Login WHERE login_kind = 99")
		if (rec is not None):
			self.winfo("Admin already exists.")
		else:
			s_login_email = self.input_email("email")
			if (s_login_email == ""):
				self.walert("Wrong email")
			else:
				rec = self.sql_select1("SELECT * FROM Login WHERE login_email = '" + s_login_email + "'")
				if (rec is None):
					self.walert("Record not found.")
				else:
					rec.login_kind = 99
					rec.put()
					self.winfo("Add admin successfully")
	
	#====================================
	def do_login_list(self):
		recs = self.sql_select("SELECT * FROM Login", 10)
		sb = []
		sb.append("<table cellspacing='1' class='form'><tr><th>ID</th><th>Kind</th><th>Email</th><th>Password</th><th>Username</th><th>Until</th><th>Wrongs</th></tr>")
		for rec in recs:
			sb.append("<tr><td>" + str(rec.login_id) + "</td><td>" + str(rec.login_kind) + "</td><td>" + rec.login_email + "</td><td>" + rec.login_password + "</td><td>" + rec.login_username + "</td><td>" + self.fdate3(rec.login_until) + "</td><td>" + str(rec.login_wrongs) + "</td><tr>")
		sb.append("</table>")
		self.whtml("".join(sb))

	#====================================
	def do_test(self):
		self.wln("xyz")


		
		
		
	#====================================
	def form_insert_piclink(self):
		a_names = ["piclink_url"]
		s = self.get_form("post", "/", "insert_piclink_values", "Log In", a_names)
		self.whtml(s)

	#====================================
	def do_insert_piclink_values(self):
		result = self.get_input("piclink_url")
		if (result == False):			
			self.form_insert_piclink()
		else:
			global dna, g_login
			rec = PicLink()
			rec.login_id = g_login.login_id
			rec.piclink_id = self.new_id("PicLink")
			rec.piclink_time = self.now()
			rec.piclink_url = dna["piclink_url"]["value"]
			rec.put()
			self.winfo("Record created.")
				
		
	#====================================
	def do_select_piclink(self):
		global g_login
		
		recs = self.sql_select("Select * from PicLink where login_id = "+str(g_login.login_id)+ " order by piclink_id desc")
		sb = []
		sb.append("<table cellspacing='1' class='form' border = '1'><tr><th>UserID</th><th>PicLinhId</th><th>Pic</th><th>Delete</th><th>Edit</th>")
		for rec in recs:
			sb.append("<tr><td>" +str(rec.login_id)+"</td> <td>"+str(rec.piclink_id)+"</td> <td>"+self.ddate3(rec.piclink_time)+"</td><td><img src='"+str(rec.piclink_url)+" 'width=100 height=100 /> </td><td> <a href='/?answer=delete_piclink&piclink_id="+str(rec.piclink_id)+"'>Delete</a> </td><td> <a href='/?answer=update_piclink&piclink_id="+str(rec.piclink_id)+"'>Edit</a><br/><br/>")
		sb.append("</table>")
		self.whtml("".join(sb))	
	


	#====================================
	def form_update_piclink(self):
		id = self.input_int("piclink_id")
		global g_login, dna
		a = self.input_int("piclink_id")
		self.init_values()
		rec = self.sql_select1("select * from PicLink where piclink_id = " + a + " and login_id = " + str(g_login.login_id))
		a_names =["piclink_url"]
		dna["piclink_url"]["value"] = rec.piclink_url
		if (a != ""):
			s = self.get_form("post", "/?piclink_id="+id, "do_update_piclink", "Log In", a_names)
			self.whtml(s)
			
			
	#====================================
	def do_update_piclink_values(self):
		global g_login, dna
		a = self.input_int("piclink_id")
		result = self.get_input("piclink_url")
		if (result == False):
			self.form_update_piclink()
		if (a != ""):		
			rec = self.sql_select1("SELECT * FROM PicLink WHERE piclink_id = "+a+" and login_id = "+ str(g_login.login_id))
			rec.piclink_url = dna["piclink_url"]["value"]
			rec.piclink_time = self.now()
			rec.put()
			self.winfo("Record updated sucessful.")
		else:
			self.winfo("record not found")
		




	#====================================
	def form_delete_piclink(self):
		id = self.input_int("piclink_id")
		if (id != ""):
			s = "Are you sure?(<a href='/?answer=do_delete_piclink_yes&piclink_id="+id+"'> Yes</a> | <a href='/?answer=do_delete_piclink_no'>No</a>)" 
			self.whtml(s)
		
	#====================================
	def do_delete_piclink_values(self):
		global g_login
		a = self.input_int("piclink_id")
		if (a != ""):			
			sql = "select * from PicLink where piclink_id = " + a + " and login_id = " + str(g_login.login_id)
			self.sql_delete(sql)
			self.do_select_piclink()















		
		
		
		
		
		


	
	
	
	
	
	
	
	
	
	
#====================================
#====================================
#====================================
class MainPage(webapp.RequestHandler, AllFunctions):
	
	#====================================
	def post(self):
		self.what_do_you_want()

	#====================================
	def get(self):
		self.what_do_you_want()

	#====================================
	def what_do_you_want(self):
		# Treat post and get the same.
		if (self.can_respond()):
			self.init_values()
			answer = self.input_text("answer", 30)
			if (answer == "info"):
				self.winfo_out()
			elif (answer == "alert"):
				self.walert_out()
			elif (answer == "error"):
				self.werror_out()
			elif (answer == "logout"):
				self.do_logout()
			elif (answer == "login0"):
				self.do_login0()
			elif (answer == "login1"):
				self.do_login1()
			elif (answer == "register0"):
				self.do_register0()
			elif (answer == "register1"):
				self.do_register1()

			elif (answer == "add_admin"):
				self.do_add_admin()
			elif (answer == "login_list"):
				if (self.prompt_admin()): self.do_login_list()
			elif (answer == "test"):
				self.do_test()

			elif (answer == "insert_piclink"):
				if (self.prompt_login()): self.form_insert_piclink()
			elif (answer == "insert_piclink_values"):
				if (self.prompt_login()): self.do_insert_piclink_values()	
				
			elif (answer == "select_piclink"):
				if (self.prompt_login()): self.do_select_piclink()
				
			elif (answer == "update_piclink"):
				if (self.prompt_login()): self.form_update_piclink()
			elif (answer == "do_update_piclink"):
				if (self.prompt_login()): self.do_update_piclink_values()
				
			elif (answer == "delete_piclink"):
				if (self.prompt_login()): self.form_delete_piclink()
			elif (answer == "do_delete_piclink_yes"):
				if (self.prompt_login()): self.do_delete_piclink_values()
			elif (answer == "do_delete_piclink_no"):
				if (self.prompt_login()): self.do_select_piclink()
				
			

				
				
				
				
				
				
			else:
				self.do_index()


#====================================
def main():
	# Route all requests to MainPage.
	application = webapp.WSGIApplication([("/.*", MainPage)], debug=True)
	wsgiref.handlers.CGIHandler().run(application)

if __name__ == "__main__": main()
