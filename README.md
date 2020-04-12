# restaurent-demo-server
This is a simple spring boot rest server that handles search in postgresql database using mybattis.

DEVELOPMENT CONFIGURATION STEPS:
1.Install postgreSQL 9.6 or above
2. create a database with name 'tomato_restaurent'
3. Execute the queries in the the schema.sql. ignore the mock data part if data is not required.
4.import the project into STS.
5. Run the project as spring boot application.

RUN CONFIGURATIONS:
1. Install postgres 9.6 or above.
2. Run the schema.sql in the database named 'tomato_restaurent'.
3. install JDK/JRE 1.8 and set it in the PATH of system environment.
4. Navigate to target/
5. in cmd, execute 'java - jar rest-service-cors-0.0.1-SNAPSHOT.jar'.
6. In browser,type localhost:8080 and press enter.
7. Search for the restaurents.

