# spring-security
This project is intended to demo spring security implementation using form base login and a in-memory database to store the username, password and roles.
We will be leveraging spring security for authentication and authorization, thymleaf and bootstrap for creating the view, h2 and spring data for databse.

## Authentication
Authentication is the act of proving an assertion, such as the identity of a computer system user. In contrast with identification, the act of indicating a person or thing's identity,
authentication is the process of verifying that identity. Authentication is the determining wheather a pricipal is WHO they say they are. Principal is not limited us, human users,
it can also be other systems and/or services. In the microservices world, this is the different upstream services which are trying to reach out to various resources within our service.

Spring security supports Http Basic, Digest, form-based, x509 certificate based, LDAP, OAuth2 and many other common forms of authentication out of the box.

##Authorization
Authorization is the function of specifying access rights/privileges to pricipal, which is related to information security and computer security in general and to access control in particular.
More formally, "to authorize" is to define an access policy. Authorization is always the successor to authentication as we cannot grant access policy unless we dont confirm the pricipal.
To over simplify, we can say that authorization is a way to determine what the pricipal can do after authentication.



