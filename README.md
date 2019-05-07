# AIG API Coding Challenge
In this challenge, you will be tasked with creating an API that interacts with a Cassandra database.
The API functionality will have the ability to create new users, select users by their id
and retrieve a page of users.

## Getting Started
You've been given a starting Spring Boot template with all the dependencies you'll need and a simple file
structure. If you wish to create your own project in order to take advantage of reactive Spring Boot, feel free.

You will also most likely need a Cassandra database to connect too in order to test your application. How
this is achieved is up to you. 

## Application Requirements
The main deliverables of this application are as follows.

### User Model
Columns in the user table:
- UUID (Primary Key)
- Username 
- Password 

User response model:
```json
{
  "UUID": {UUID},
  "username": {username}
}
```

*IMPORTANT*: We never want the user password to be in a response.

### Endpoints

#### /api/v1/users/{userId} GET
Retrieves a single user with the given id, from the cassandra database.

Path Variables 
- userId - The id used to determine which user to query from cassandra.

*Potential Error:* If a user with the given id does not exist, handle this situation accordingly.

Response Body:
```json
{
  "UUID": {UUID},
  "username": {username}
}
```

#### /api/v1/users?pagingState={pagingState}&limit={limit} GET
Retrieves a page of users from the cassandra database.

Params:
- pagingState (Optional): The Cassandra paging state. Default is null.
- limit (Optional): The number of user records to be returned back. Default is 10 records.

*Potential Error:* If there are no users to query, handle this situation accordingly.

Response Body:
```json
{
  "count": {count},
  "pagingState": {pagingState},
  users: [
    {
      "UUID": {UUID},
      "username": {username}
    },
    ...
  ]
}
```

#### /api/v1/users POST
Creates a new user within cassandra database with the given information. Returns the newly created user.

*Potential Error:* The password and confirm fields must equal.
 If they are not, the post should not be successful and should be handled accordingly.
 
Request Body Model:
```json
{
    "username": {username},
    "password": {password},
    "confirm": {confirm}
}
```
Response Body:
```json
{
    "UUID": {UUID},
    "username": {username}
}
```

## Bonus

### Security
No security is required for this application. Passwords do not need hashed and resources do not require
authentication/authorization. Any security implementations will act as a bonus.

### Swagger
Swagger documentation is not required for this application. Any swagger documentation will act as a bonus.

### Unit/Integration Testing
Testing is not required for this application. Any testing with act as a bonus.