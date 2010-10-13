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
		# /doctor/california/sanfrancisco
		s_url = self.request.url
		a_parts = s_url.split("/")
		e = len(a_parts)
		p0 = a_parts[0]
		p1 = "" if e <= 1 else a_parts[1]
		p2 = "" if e <= 2 else a_parts[2]
		p3 = "" if e <= 3 else a_parts[3]
		p4 = "" if e <= 4 else a_parts[4]
		p5 = "" if e <= 5 else a_parts[5]
		p6 = "" if e <= 6 else a_parts[6]
		p7 = "" if e <= 7 else a_parts[7]
		p8 = "" if e <= 8 else a_parts[8]
		p9 = "" if e <= 9 else a_parts[9]

		wln(self, "p0 = " + p0)
		wln(self, "p1 = " + p1)
		wln(self, "p2 = " + p2)
		wln(self, "p3 = " + p3)
		wln(self, "p4 = " + p4)
		wln(self, "p5 = " + p5)
		wln(self, "p6 = " + p6)
		wln(self, "p7 = " + p7)
		wln(self, "p8 = " + p8)
		wln(self, "p9 = " + p9)
		

#====================================
def main():
	# Route all requests to MainPage.
	application = webapp.WSGIApplication([("/.*", MainPage)], debug=True)
	wsgiref.handlers.CGIHandler().run(application)

if __name__ == "__main__": main()
