@ECHO OFF
SET file=DatabaseManager.txt
IF NOT "%~1" == "" (
	SET file="%~1"
)
ECHO copying %file%
clip < %file% 
ECHO After the heroku postgreSQL shell opens simply right click and paste to setup the database.
heroku pg:psql 
