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
		self.response.out.write("BBB, oh my!<br /><br />")
		self.response.out.write("Why, why, why?<br /><br />")
		self.response.out.write("30 x 2 = " + str(x2(30)) + "<br /><br />")
		self.response.out.write("30 x 30 = " + str(xx(30)) + "<br /><br />")

#====================================
def main():
	# Route all requests to MainPage.
	application = webapp.WSGIApplication([("/.*", MainPage)], debug=True)
	wsgiref.handlers.CGIHandler().run(application)

if __name__ == "__main__": main()
