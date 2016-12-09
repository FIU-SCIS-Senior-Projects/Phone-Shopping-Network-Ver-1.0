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
 
##Developers
- Dewan Mohammad Moksedul Alam (dalam004@fiu.edu)
- Khaja Mohammed (kmoha023@fiu.edu)

##Mentors
- Charles Green (PO)
- Mohsen Taheri (mtahe006@fiu.edu)

