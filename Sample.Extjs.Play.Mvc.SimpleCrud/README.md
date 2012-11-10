# Sample Demo Extjs MVC & Play 2.0 

## 1. Pre-requisites to compile & run this demo:
  - JDK 7 with latest updates version.
  - Latest version of Play 2.0 framework (www.playframework.org).
  - Latest version of MySql 5 database.
  - Git client

## 2. [HOW TO - Setup environment to run the demo]
  - Download & install JDK 7 with latest updates.
  - Download & unzip/unrar latest version of Play 2.0 framework distribution & make a note the folder's location.
  - Create a new environment variabel and point it to the Play folder's location (e.g. PLAY_HOME=D:\play-2.0.4).
  - Add the Play's environment variabel into the PATH variabel (e.g. PATH=.......;%PLAY_HOME%).
  - Ensure that you have installed Git client.
  - git clone the demo's URL: git@github.com:saintc0d3r/Sample.Extjs.Play.git 
    (e.g. git clone --recursive git@github.com:saintc0d3r/Sample.Extjs.Play.git)
  - Download & install the latest version of MySql 5 database.
  - Create the demo's database through executing the .sql script where is located in the demo's Schema folder
    (e.g. .\Sample.Extjs.Play\Sample.Extjs.Play.Mvc.SimpleCrud\Schema\sample.extjs.play.mvc.sql).
  - Open the demo's config file located in conf folder(e.g. .\Sample.Extjs.Play\Sample.Extjs.Play.Mvc.SimpleCrud\conf)
    using text editor or IDE application.
  - Adjust the database connection configuration to connect the demo app to your local mysql database

## 3. [HOW TO - Run the demo]
  - Open command line interface box (e.g. Type cmd in the windows run box then followed with [Enter] )
  - Change directory to the demo's folder.
  - Type play run then press [Enter]
  - Open your internet browser and browse to http://localhost:9000

## 4. TODOs
  - Add icons & tooltips on Employee Maintenance form's buttons.
  - Implement Supervision strategy, fail-over strategy & multiple workers in the master data service.
  - Add notification status after Synching is finished.
  - Add a Simple Report node+form which contains a list of employees using Jasper Report (JRXML).
  - Integrate JBehave+Watij and add comprehensive test cases for the demo.
  - Add many more ....
