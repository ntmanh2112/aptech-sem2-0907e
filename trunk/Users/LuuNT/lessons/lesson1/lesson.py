# Download and install Notepad++
# Download and install Python
# Download and install Python Image Library (PIL)
# Download and install Google App Engine SDK.

# Register an app engine application name with appengine.google.com
# For example, we choose the application name "lesson1" (in reality, this name is not available anymore).
# Later on, when we publish the application lesson1 to the web, lesson1.appspot.com is the location of lesson1.

# Create a folder to hold one application, call it "lesson1", for example.
# Create a folder inside lesson1 to hold all static files such as css and images, call it "f", for example.
# Create an application file, call it "lesson1.py", for example.
# Create a configuration file called "app.yaml" (required file name).
# Write the following in app.yaml and save:
	
#application: lesson1
#version: 1
#runtime: python
#api_version: 1
#handlers:
#- url: /f
#  static_dir: f
#- url: /.*
#  script: lesson1.py

#application: lesson1
# (the app engine application we register with appengine.google.com.)
#version: 1
# (as we develop, we can change version number, and google will keep the old lesson1 application for rolling back.) (don't understand)
#runtime: python
# (using python language; another option is java)
#api_version: 1
# (settings for app engine, which for now is in version 1.)
#handlers:
#- url: /f
#  static_dir: f
# (map all url requests for /f to the static folder f, then store all static files in that folder)
#- url: /.*
#  script: lesson1.py
# (map all url requests to the script file lesson1.py)

# Go to DOS command, type this command (hopefully path1 was automatically added during app engine SDK installation):
#c:/[path1]dev_appserver.py [path2]lesson1
# appserver will read app.yaml inside lesson1 folder, compile and launch the app in the local machine.

# Go to DOS, type this command to publish it online
#c:/[path1]appcfg.py update [path2]lesson1





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
		self.response.out.write("Hello, world!<br /><br />")
		self.response.out.write("This is image1 <img src='f/image1.png' /><br /><br />")
		self.response.out.write("Second image <img src='f/image2.png' /><br /><br />")
		self.response.out.write("End.")

#====================================
def main():
	# Route all requests to MainPage.
	application = webapp.WSGIApplication([("/.*", MainPage)], debug=True)
	wsgiref.handlers.CGIHandler().run(application)

if __name__ == "__main__": main()
