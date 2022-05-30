                                # LINUX/SQL PROJECT

#Introduction
This project is designed to monitor system's hardware specification and  usage within specific time intervals controlled by automated crontab jobs and storing the information in the psql database instance created using Docker. Technologies used in this project are:
1: Linux OS.
2: Bash Scripting.
3: Docker and its principles.
4: Gitflow.
5: Postgress RDMS and PSQL language.

# Quick Start
- First we need to start the psql instance container whcih has its script in psql_docker.sh - ./psql_docker.sh Start|Stop|Create(any of these);
-We need to create tables which can be done by running ddl.sql script file.
-Insert the data using host_info and host_usage scripts.
-Setting up the crontab job which run's the host_usage script every minute and  creates new entries in the host_usage table.  

# Implementation
-Firstly, I learned about the various technology used in the project so that i dont find any difficulties during the project. I used docker to initiate a psql instance. Then i wrote script(ddl.sql) that created tables in the database. After that, i wrote other scripts(host_usage.sh and host_info.sh) that populated the tables with the hardware usage and specifications. At the end i automated the usage script with crontab job so that the usage table gets the data at every minute which can be monitored later on.

## Scripts
-psql_docker.sh--- This script is used to START|CREATE|STOP the container. And we can pass the arguments in CLI according to what desired.

-host_info.sh --- This script is used to INSERT host_info data into the database.
-host_usage.sh--- This script is used to INSERT usage data into the database.
-crontab      --- This is used to automate the usage script so that it runs after each interval so that the usage can be monitored later on.
-queries.sql  --- This script contains the sql queries that a business may use when monitoring the usage information. 

##Database Modelling
-`host_info` This is the host info


# Test 
This is one of the main steps in SLDC. I have tested my all the quries and the scripts locaaly first so that i donot get any kind of errors when running inside the script. Thui has helpmed me to save alot of time in debugging itself.



# Deployment

I have deployed the application with the help of Docker where we instantiated the psql database. All the information about the usage has been there only.

# Improvements

- I want to improve my psql queries so that they run more faster for easy retrieval.





