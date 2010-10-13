#====================================
#====================================
#====================================
from google.appengine.ext import webapp
import wsgiref.handlers
from _common import *
from _unique import *


#====================================
class MainPage(webapp.RequestHandler):
	
	#====================================
	def post(self):
		# Treat post and get the same.
		self.get()

	#====================================
	def get(self):
		# what do you want?
		a = input_text(self, "a", 30)
		if (a == "logout"):
			do_logout();
		elif (a == "login0"):
			do_login0();
		elif (a == "login1"):
			do_login1();
		elif (a == "register0"):
			do_register0();
		elif (a == "register1"):
			do_register1();
		else:
			do_login0();

	#====================================
	#====================================
	#====================================
	def do_logout():
		s_cookie_key = get_cookie("ck")
		if (s_cookie_key != ""):
			del_cookie("ck")
			rec = sql_select1("SELECT * FROM Login0 WHERE cookie_key = '" + s_cookie_key + "'")
			if (rec is not None):
				rec.cookie_key = ""
				rec.put()
		winfo(self, "You have logged out successfully.")

	#====================================
	function do_login0():
	#question0: what do you want?
	#answer = login0:
		#check: do you already have login?
		answer = have_login(self, False)
		if (answer):
		#answer = yes:
			global g_login0
			#show a link to logout
			winfo("You are logged in as " + g_login0.login_username + ".<br /><br />Do you want to switch your login? If yes, you need to <a href='/login?a=logout'>log out</a> first.")
		else:
		#answer = no:
			#question1: what are your login_email and login_password?
			question_login1()

	#====================================
	function do_login1()
	#question1: what are your login_email and login_password?
	#answer = login1:
		#check: are login_email and login_password valid?
		answer1 = get_input(self, "login_email")
		answer2 = get_input(self, "login_password")
		if (($answer1 == false) | ($answer2 == false)):
		#answer = 1 no:
			#goto: question1
			question_login1()
		else:
		#answer = yes:
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

			#select1: select * from Login1 using login_email
			global dna, g_invalid
			rec = sql_select1("SELECT * FROM Login1 WHERE login_email = '" + dna["login_email"]["value"] . "'")
			if (rec is None)
			#answer = no record:
				#set invalid message to login_email and login_password do not match
				g_invalid = "Email and password do not match.<br />Please try again.";
				#goto: question2
				question_login2()
			else:
			#answer = yes record:
				#check: does given password match the record
				if (rec.login_password != dna[""]["value"]):
				#answer = no
					#increase login_wrongs
					rec.login_wongs = rec.login_wongs + 1
					rec.put()
					#set invalid message to login_email and login_password do not match
					g_invalid = "Email and password do not match.<br />Please try again.";
					#goto: question2
					question_login2()
				else:
				#answer = yes
					#get a new cookie_key
					s_cookie_key = new_key("Login0", "cookie_key")
					#set cookie_key to cookie
					set_cookie("ck", s_cookie_key)
					#create a new session
					
				$rec = $recs[0];
				$s_login_id = $rec[0];
				$s_login_kind = $rec[1];
				$s_login_password = $rec[2];
				$s_login_username = $rec[3];
				$s_login_until = $rec[4];
				//check: does login_password input == selected login_password?
				if ($s_login_password != $p_dna["login_password"]["value"])
				{
				//answer = no:
					//update wrongs
					sql_update("update login_stats set login_wrongs = login_wrongs + 1 where login_id = " . $s_login_id);
					//set invalid message to login_email and login_password do not match
					$p_invalid = "Email and password do not match.<br />Please try again.";
					//goto: question2
					question_login2();
				}
				else
				{
				//answer = yes
					//save this session
					set_session("login_id", $s_login_id);
					set_session("login_kind", $s_login_kind);
					set_session("login_username", $s_login_username);
					set_session("login_until", $s_login_until);
					//update login_datez
					sql_update("update login_stats set login_datez = now() where login_id = " . $s_login_id);
					//check: is login_until valid?
					if (strtotime($s_login_until) < time())
					{
					//answer = no:
						//winfo: inform expired subscription, offer a link to renew subscription
						$s_expire = fdate3($s_login_until);
						winfo("Your subscription was expired on " . $s_expire . ". If you want to renew your subscription, please click here.");
					}
					else
					{
					//answer = yes:
						//go to home page
						rout("index.php");
					}
				}
			}
		}
	}

//========================================
function do_register1()
{
//question1: what do you want?
//answer = register1:
	//check: do you already have login?
	$s_login_id = get_session("login_id");
	$s_login_username = get_session("login_username");
	if ($s_login_id != "")
	{
	//answer = yes:
		//winfo: show a link to logout
		winfo("You are logged in as " . $s_login_username . ".<br /><br />Do you want to logout first before doing a new register? If yes, click here to <a href='login.php?a=logout'>log out</a>.");
	}
	else
	{
	//answer = no:
		//question2: what are your login_email, login_password, retype_password, login_username?
		question_register2();
	}
}

//========================================
function do_register2()
{
//question2: what are your login_email, login_password, retype_password, login_username?
//answer = register2:
	//check: are the login_email, login_password, retype_password, login_username valid?
	$answer1 = get_input("login_email");
	$answer2 = get_input("login_password");
	$answer3 = get_input("retype_password");
	$answer4 = get_input("login_username");
	if (($answer1 == false) || ($answer2 == false) || ($answer3 == false) || ($answer4 == false))
	{
	//answer = 1 no:
		//goto: question2
		question_register2();
	}
	else
	{
	//answer = yes:
		//check: do login_email or login_username already exist?
		global $p_dna;
		$recs = sql_select("select login_email, login_username from login where login_email = '" . $p_dna["login_email"]["value"] . "' or login_username = '" . $p_dna["login_username"]["value"] . "'");
		$e = count($recs);
		if ($e > 0)
		{
		//answer = 1 yes:
			//set valid = false
			//change invalid message
			$s_login_email = $recs[0][0];
			$s_login_username = $recs[0][1];
			if (strtolower($p_dna["login_email"]["value"]) == strtolower($s_login_email))
			{
				$p_dna["login_email"]["valid"] = false;
				$p_dna["login_email"]["invalid"] = "This email already exists. Please choose another one.";
			}
			if (strtolower($p_dna["login_username"]["value"]) == strtolower($s_login_username))
			{
				$p_dna["login_username"]["valid"] = false;
				$p_dna["login_username"]["invalid"] = "This username already exists. Please choose another one.";
			}
			if ($e >= 2)
			{
				$s_login_email = $recs[1][0];
				$s_login_username = $recs[1][1];
				if (strtolower($p_dna["login_email"]["value"]) == strtolower($s_login_email))
				{
					$p_dna["login_email"]["valid"] = false;
					$p_dna["login_email"]["invalid"] = "This email already exists. Please choose another one.";
				}
				if (strtolower($p_dna["login_username"]["value"]) == strtolower($s_login_username))
				{
					$p_dna["login_username"]["valid"] = false;
					$p_dna["login_username"]["invalid"] = "This username already exists. Please choose another one.";
				}
			}
			//goto: question2
			question_register2();
		}
		else
		{
		//answer = no:
			//set login_kind = empty
			$s_login_kind = "";
			//set login_until = now + 3 months
			$s_login_until = date("Y-m-d", time() + (60*60*24*92));
			//create a new login
			$s_login_id = sql_insert("insert into login values(null, '" . $s_login_kind . "', '" . $p_dna["login_email"]["value"] . "','" . $p_dna["login_password"]["value"] ."','" . $p_dna["login_username"]["value"] . "','" . $s_login_until . "')");
			//create a new login_stats
			sql_insert("insert into login_stats values('" . $s_login_id . "', now(), now(), 0)");
			//save this session
			set_session("login_id", $s_login_id);
			set_session("login_kind", "");
			set_session("login_username", $p_dna["login_username"]["value"]);
			set_session("login_until", $s_login_until);
			//winfo: register successful
			winfo("You have registered successfully.");
		}
	}
}

		
		
		
		
		
	#====================================
	#====================================
	#====================================
	def question_login1():
		a_names = []
		a_names[0] = "login_email"
		a_names[1] = "login_password"
		s = get_form("post", "login", "login2", "Log In", a_names)
		whtml(self, s)

	#====================================
	def question_register1():
		a_names = []
		a_names[0] = "login_email"
		a_names[1] = "login_password"
		a_names[2] = "retype_password"
		a_names[3] = "login_username"
		s = get_form("post", "login.php", "register2", "Simple Register Form", a_names)
		whtml(self, s)

#====================================
def main():
	# Route all requests to MainPage.
	application = webapp.WSGIApplication([("/.*", MainPage)], debug=True)
	wsgiref.handlers.CGIHandler().run(application)

if __name__ == "__main__": main()
