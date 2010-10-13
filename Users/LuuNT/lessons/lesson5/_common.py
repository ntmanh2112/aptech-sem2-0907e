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
def can_respond():
	return True;

#====================================
def get_cookie(self, in_key):
	return self.request.cookies.get(in_key, "")

#====================================
def set_cookie(in_key, in_value):
	o_cookie = Cookie.SimpleCookie()
	o_cookie[in_key] = in_value
	o_cookie[in_key]["expires"] = 3600*24*365
	o_cookie[in_key]["path"] = "/"
	print o_cookie

#====================================
def del_cookie(in_key):
	o_cookie = Cookie.SimpleCookie()
	o_cookie[in_key] = ""
	print v_cookie

#====================================
def generate_key():
	cs = "abcdefghijklmnopqrstuvwxyz0123456789"
	sb = []
	sb.append(cs[random.randint(0,25)])
	for i in range(19): sb.append(cs[random.randint(0,35)])
	return "".join(sb)

#====================================
def new_key(in_table, in_field):
	s_key = generate_key()
	rec = sql_select1("SELECT * FROM " + in_table + " WHERE " + in_field + " = '" + s_key + "'")
	if (rec is not None):
		s_key = generate_key()
		rec = sql_select1("SELECT * FROM " + in_table + " WHERE " + in_field + " = '" + s_key + "'")
		if (rec is not None):
			s_key = generate_key()
	return s_key

#====================================
def new_id(in_name):
	rec = self.sql_select1("SELECT * FROM NextId WHERE name = '" + in_name + "'")
	if (rec is None):
		rec = NextId()
		rec.name = in_name
		rec.value = 1000
	rec.value = rec.value + 1
	rec.put()
	return rec.value

#====================================
def last_id(in_name):
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
		s_cookie_key = get_cookie("ck")
		if (s_cookie_key != ""):
			rec = self.sql_select1("SELECT * FROM Login0 WHERE cookie_key = '" + s_skey + "'")
			if (rec is not None):
				g_login0 = rec
			else:
				answer = False
				if (in_need_redirect):
					rout(self, "/login")
	return answer




#====================================
#====================================
#====================================
def wln(self, in_value):
	self.response.out.write("<p>" + unicode(in_value) + "</p>")

#====================================
def btw(self, in_value):
	self.response.out.write("<p>>" + unicode(in_value) + "<</p>")

#====================================
def url_encode(in_name, in_value): return urlencode({in_name:in_value.encode("utf-8")})
def winfo(self, in_value): self.redirect("/info?a=info&" + url_encode("m", in_value))
def walert(self, in_value): self.redirect("/info?a=alert&" + url_encode("m", in_value))
def werror(self, in_value): self.redirect("/info?a=error&" + url_encode("m", in_value))
def rout(self, in_url): self.redirect(in_url)

#====================================
#====================================
#====================================
def now():
	return datetime.datetime.now()

#====================================
def nowd():
	return datetime.date.today()

#====================================
def add_seconds(in_value, in_seconds):
	return in_value + datetime.timedelta(0,in_seconds)

#====================================
def datetime_val(in_string):
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
def ddate6(in_value): return in_value.strftime("%Y-%m-%d %H:%M:%S")
def ddate5(in_value): return in_value.strftime("%Y-%m-%d %H:%M")
def ddate3(in_value): return in_value.strftime("%Y-%m-%d")
def fdate6(in_value): return in_value.strftime("%m/%d/%Y %H:%M:%S")
def fdate5(in_value): return in_value.strftime("%m/%d/%Y %H:%M")
def fdate3(in_value): return in_value.strftime("%m/%d/%Y")

def dnum0(in_value): return "%.0f" % in_value
def dnum2(in_value): return "%.2f" % in_value

def replace(in_string, in_find, in_replace):
	return in_string.replace(in_find, in_replace)

#====================================
def small_words(in_value):
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
def strip_string(in_value):
	return in_value.replace("'", "&#39;").replace('"', "&#34;").replace("(", "&#40;").replace(")", "&#41;").replace("<", "&#60;").replace(">", "&#62;").replace("    ", " ").replace("   ", " ").replace("  ", " ").replace("  ", " ").replace("  ", " ").strip()

#====================================
def strict_string(in_value, in_need_br = False):
	s = strip_string(small_words(in_value))
	if (in_need_br):
		s = s.replace("\r\n", "<br />").replace("<br /><br /><br /><br />", "<br />").replace("<br /><br /><br />", "<br />").replace("<br /><br />", "<br />").replace("<br /><br />", "<br />")
	return s

#====================================
def is_numeric(in_string):
	answer = True
	try:
		v_num = float(in_string)
	except ValueError:
		answer = False
	return answer

#====================================
def is_email(in_string):
	answer = True
	i_at = in_string.find("@")
	if (i_at < 1):
		answer = False
	else:
		i_dot = in_string.find(".", i_at)
		if (i_dot < 1): answer = False
	return answer
	
#====================================
def int_val(in_value):
	return int(round(float(in_value)))

#====================================
def float_val(in_value):
	return float(in_value)

#====================================
def input_raw(self, in_name, in_max_len):
	s = self.request.get(in_name)
	if (in_max_len > 0):
		if (len(s) > in_max_len): s = s[0:in_max_len]
	return s

#====================================
def input_text(self, in_name, in_max_len, in_need_br = False):
	s = strict_string(self.request.get(in_name), in_need_br)
	if (in_max_len > 0):
		if (len(s) > in_max_len): s = s[0:in_max_len]
	return s

#====================================
def input_multiple(self, in_name, in_max_len):
	a = self.request.get_all(in_name)
	ss = []
	for i in range(len(a)):
		s = strict_string(a[i])
		if (in_max_len > 0):
			if (len(s) > in_max_len): s = s[0:in_max_len]
		ss.append(s)
	return ss

#====================================
def input_split(self, in_name, in_max_len, in_separator):
	a = strict_string(self.request.get(in_name)).split(in_separator)
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
	s = input_raw(self, in_name, 20)
	if (is_numeric(s)):
		return str(int_val(s))
	else:
		return ""

#====================================
def input_float(self, in_name):
	s = input_raw(self, in_name, 20)
	if (is_numeric(s)):
		return str(float_val(s))
	else:
		return ""

#====================================
def input_datetime(self, in_name):
	s = input_text(self, in_name, 40)
	d = datetime_val(s)
	if (d is None):
		return ""
	else:
		return ddate6(d)

#====================================
def input_date(self, in_name):
	s = self.input_text(in_name, 40)
	d = datetime_val(s)
	if (d is None):
		return ""
	else:
		return ddate3(d)

#====================================
def input_url(self, in_name, in_value = ""):
	# This function can be used to validate in_value (set in_name = "")
	s = in_value
	if (in_name != ""): s = self.request.get(in_name)
	s = strip_string(s)
	if ((s != "") & (s[0:7] != "http://") & (s[0:8] != "https://")): s = "http://" + s
	if (len(s) > 300): s = s[0:300]
	return s

#====================================
def input_big(self, in_name, in_max_len = 0):
	# Like input_text, but allow big words.
	s = self.request.get(in_name)
	s = strip_string(s)
	if (in_max_len > 0):
		if (len(s) > in_max_len): s = s[0:in_max_len]
	return s

#====================================
def input_email(self, in_name):
	s = strip_string(self.request.get(in_name))
	if (is_email(s)): return s
	else: return ""

#====================================
def check_confirm(self):
	if (input_checkbox(self, "confirm") == "1"):
		return True
	else:
		walert(self, "You need to confirm your action.")
		return False

#====================================
def rint(in_number):
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
