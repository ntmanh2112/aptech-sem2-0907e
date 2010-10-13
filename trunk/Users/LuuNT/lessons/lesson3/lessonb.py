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
		# ?find=doctor&state=california&city=sanfrancisco
		s1=input_int(self,"abc")
		wln(self,s1)
		s2=input_int(self,"cef")
		wln(self,s2)
		
		ss=[]
		ss.append(s1)
		ss.append(s2)		
		s3="".join(ss)
		wln(self,s3)		

#====================================
def main():
	# Route all requests to MainPage.
	application = webapp.WSGIApplication([("/.*", MainPage)], debug=True)
	wsgiref.handlers.CGIHandler().run(application)

if __name__ == "__main__": main()
#

