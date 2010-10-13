#====================================
#====================================
#====================================
from google.appengine.ext import webapp
import wsgiref.handlers

#====================================
class MainPage(webapp.RequestHandler):
	
	#====================================
	def post(self):
		# Treat post and get the same.
		self.get()

	#====================================
	def get(self):
		self.response.out.write("Hello, AAA!<br /><br />")
		self.response.out.write("How are you?")

#====================================
def main():
	# Route all requests to MainPage.
	application = webapp.WSGIApplication([("/.*", MainPage)], debug=True)
	wsgiref.handlers.CGIHandler().run(application)

if __name__ == "__main__": main()
