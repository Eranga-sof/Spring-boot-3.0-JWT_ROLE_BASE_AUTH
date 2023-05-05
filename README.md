# Spring-boot-3.0-JWT_ROLE_BASE_AUTH
spring boot 3.0 basic JWT role base authentication


New User Registration- 
curl --location 'http://localhost:8080/api/v1/auth/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Jack",
    "lastName":"Peter",
    "email":"peter@gmail.com",
    "password":"test1234"
}'

Login User(Admin user create when project initiate)- 
curl --location 'http://localhost:8080/api/v1/auth/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    
    
       "username":"admin@admin.com",
    "password":"test1234"
}'
