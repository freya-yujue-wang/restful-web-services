# RESTful Web Services

Social Media Application

User -> Posts

- Retrieve all Users      - GET /users
- Create a User           - POST /users
- Retrieve one User       - GET /users/{id} -> /users/1
- Delete a User           - DELETE /users/{id} -> /users/1

- Retrieve all posts for a User   - GET /users/{id}/posts
- Create a posts for a User       - POST /users/{id}/posts
- Retrieve details of a post      - GET /users/{id}/posts/{post_id}


#### Internationalization

##### Configuration
- LocaleResolver
  - Default Locale - Locale.US
- ResourceBundleMessageSource

##### Usage
- Autowire MessageSource
- @RequestHeader(value = "Accept-Language", required = false) Locale locale
- messageSource.getMessage("helloWorld.message", null, locale)


#### Versioning
- Media type versioning (a.k.a "content negotiation" or "accept header")
  - GitHub
- (Custom) headers versioning
  - Microsoft
- URI Versioning
  - Twitter
- Parameter versioning
  - Amazon
- Factors
  - URI Pollution
  - Misuse of HTTP Headers
  - Caching
  - Can we execute the request on the browser?
  - API Documentation
- No Perfect Solution

#### Spring JPA
##### Table Structure

create table user(
id integer not null,
birth_date timestamp,
name varchar(255),
primary key(id)
)