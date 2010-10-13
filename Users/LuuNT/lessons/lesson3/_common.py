from google.appengine.ext import db
import Cookie
import random, datetime
from urllib import urlencode




#====================================
def wln(self, in_value):
	self.response.out.write("<p>" + unicode(in_value) + "</p>")

#====================================
def btw(self, in_value):
	self.response.out.write("<p>>" + unicode(in_value) + "<</p>")

	

#====================================
#====================================
#====================================
def now():
	return datetime.datetime.now()

#====================================
def nowd():
	return datetime.date.today()

#====================================
def nown(in_add_seconds = 0):
	return int((datetime.datetime.now() + datetime.timedelta(0, in_add_seconds)).strftime("%Y%m%d%H%M%S"))

#====================================
def add_seconds(in_value, in_seconds):
	return in_value + datetime.timedelta(0,in_seconds)

#====================================
	
#====================================
def ddate6(in_value): return in_value.strftime("%Y-%m-%d %H:%M:%S")
def ddate5(in_value): return in_value.strftime("%Y-%m-%d %H:%M")
def ddate3(in_value): return in_value.strftime("%Y-%m-%d")
def fdate6(in_value): return in_value.strftime("%m/%d/%Y %H:%M:%S")
def fdate5(in_value): return in_value.strftime("%m/%d/%Y %H:%M")
def fdate3(in_value): return in_value.strftime("%m/%d/%Y")

def dnum0(in_value): return "%.0f" % in_value
def dnum2(in_value): return "%.2f" % in_value



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
	if (datetime_val(s) is None):
		return ""
	else:
		return ddate6(s)

#====================================
def input_date(self, in_name):
	s = self.input_text(in_name, 40)
	if (self.datetime_val(s) is None):
		return ""
	else:
		return self.ddate3(s)

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
