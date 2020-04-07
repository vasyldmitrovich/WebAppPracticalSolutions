Java Web Application

1) Open the project in IntelliJIDEA Ultimate Edition.

2) Connect TomCat. Click Run - Edit Configuration - 
(on the left-side click) - plus - TomCat Local - 
(on the right-side) Deployment - plus - 
Artifact - Application context and set "/".
Add folders css, fonts, files and js with bootstrap and jquery 
click - External Source (and add folders) css fonts files and js
3) Install MySql: follow on-screen instructions 
https://www.mysqltutorial.org/install-mysql/ . 
- Run MySQL WorkbenchChange and create schema "solutions"
- change login and password to DataBase on yours 
in file context.xml
- In IntelliJIDEA (on the right-side) click 
- Database - plus - Data Source 
- enter User and Password, 
- click Advanced and serverTimezone set UTC, 
- after that click Apply and Ok.
- On schemas, mouse right click - Run Sql Script... 
- and choose /resources/init_db.sql
