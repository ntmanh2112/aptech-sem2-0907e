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
		if (can_respond()):
			a = input_text(self, "a", 30)
			if (a == "info"):
				do_info();
			elif (a == "alert"):
				do_alert();
			elif (a == "error"):
				do_error();
			else:
				do_info();

	#====================================
	#====================================
	#====================================
	def do_info():
		m = input_text(self, "m", 1000)
		s = """<h2>Message</h2>
<br />
<h4>""" + m + """</h4>
<br />
Click the Back button to go back.
"""
		whtml(self, s)

	#====================================
	def do_alert():
		m = input_text(self, "m", 1000)
		s = """<h2 class="alert">Alert: Correction Needed!</h2>
<br />
<h4>""" + m + """</h4>
<br />
Click the Back button to go back.
"""
		whtml(self, s)

	#====================================
	def do_error():
		m = input_text(self, "m", 1000)
		s = """<h2 class="error">Error! Something is wrong!</h2>
<br />
<h4>""" + m + """</h4>
<br />
This is an application error. This is NOT a user's error.
<br /><br />
Click the Back button to go back.
"""
		whtml(self, s)

#====================================
def main():
	# Route all requests to MainPage.
	application = webapp.WSGIApplication([("/.*", MainPage)], debug=True)
	wsgiref.handlers.CGIHandler().run(application)

if __name__ == "__main__": main()
