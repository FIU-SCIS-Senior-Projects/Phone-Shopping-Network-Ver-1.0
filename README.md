# Phone-Shopping-Network-Ver-1.0

##Directory Structure
The code base of the project is organized in two top level directories.
- PhoneShopping
- backend

###The PhoneShopping directory
This folder contains the source code of the android application

### The backend directory
It contains the source code of the server side components and web based console application along with database sql scripts.
Some directories inside this represents different project modules to organize codes nicer way. The further decomposition 
of this directory is as follows
- **common:** The main purpose of this module is to organize codes that may be needed by both server and the client applications.
- **phoneshopping-webapp:** This module is the webapplication that contains the source codes of all the essential components of the system along with the webservice
- **web-console:** This module contains the source code of the web based management console. This is also another j2ee web application
- **misc:** This is not essentially a project module as it does not produce any artifact that can deployed of reused. Rather the primary intension for this module was to organize the non-source resources. Currently it contains only the mysql database scripts.
 
 
###How to Build the Projects
Building and running the PhoneShopping android application is pretty straight forward. The project was meant to be developed 
with Android Studio. If you do not have it installed then install it and open the project. Then run. If you do not have 
android SDK and emulators set up beforehand it may ask to set those up properly. You may also connect any development enabled
android device to run the application on it.

For building the applications two build tools are used. One of them is **Gradle** and another one is **Maven**. Basically 
to build the **backend** you only will need gradle. You just need to run the command **`gradle build`**. You can build any 
module separately by running the command from inside the specific module or the whole project from the root directory. 
After the build is finished, the phoneshopping-webapp and web-console will have the generated .war file that need to be 
deployed to an application server capable of running J2EE applications.
 
So far, maven is not needed. It is actually needed to collaborate between backend and frontend applications because the 
common module is designed to be reused by both server and client. Thus both applications have dependency on it. Since it
is part of the backend, there is no problem while building this. But when building the android application, the dependency 
needs to be resolved. One of the way to resolve this is to upload the artifacts to a local repository and use the uploaded 
version in the dependent projects. This synchronization is done by maven. The projects are already configured to use maven.
The developer needs to install maven in his/her environment. To upload an artifact to local repository you need to run 
the command **`gradle install`**. Projects are already set up to use local maven repository to get dependent libraries.

###Preparing the database
The DDL scripts for the database are already given. During design MariaDB 5.6 was the target database server which is also 
compatible with MySQL server. Either of these two can be used. After installation is done, you need to execute those scripts 
on your database to have a full fledged test environment. Assuming that, you already have a MyDQL database installation, 
you have mysql client installed. Now you need to run the following commands to set up database completely.
 
 `$ cd backend/misc/database/mysql`

 `$ mysql -h db-host -u db-user -p;`
 
 `mysql$ create database psnsdb character set utf8 collate utf8_general_ci;`
 
 `mysql$ grant all on *.* to db-user identified by db-pass`
 
 `$ for el in tables.sql indexes.sql constants.sql; do mysql -h db-host -u db-user -p psnsdb < $el; done`
  
  You are done. Your database is ready to accept requests.



##Developers
- Dewan Mohammad Moksedul Alam (dalam004@fiu.edu)
- Khaja Mohammed (kmoha023@fiu.edu)

##Mentors
- Charles Green (PO)
- Mohsen Taheri (mtahe006@fiu.edu)

