# Restful-Webservice-With-Spring-Boot

### Building a Robust REST API

Creating a high-quality REST API involves a set of key considerations:

- **Resource Identification**: Identify the resources you want to expose, like `/users`, `/users/{id}`, or `/posts`.

- **Action Definition**: Determine the actions your API will support, including GET, POST, PUT, DELETE, and more.

- **Request and Response Design**: Carefully define the structures for requests and responses, ensuring consistency.

- **Status Codes**: Use appropriate response status codes (e.g., 200, 404, 500) to convey meaningful information to clients.

- **Best Practices**: Embrace REST API best practices, focusing on the consumer's perspective. Consider validation, internationalization, exception handling, HATEOAS (Hypermedia as the Engine of Application State), versioning, and comprehensive documentation.

A well-designed REST API caters to both your application's needs and the expectations of its consumers, leading to an efficient and user-friendly API.

1**Simple Hello World REST APIs**

Key Concepts:

- **@RestController**: Annotate your controllers with `@RestController` to define them as REST endpoints, allowing them to respond to HTTP requests.

- **@RequestMapping**: Use `@RequestMapping` to map URL paths to specific controller methods.

- **@PathVariable**: Employ `@PathVariable` to extract values from the URL and pass them as method parameters.

- **JSON Conversion**: Spring Boot simplifies JSON conversion for handling data between your API and clients.

This hands-on practice will introduce to the core elements of building RESTful APIs with Spring Boot.

### Understanding Path Parameters

Path parameters are variable values within your URLs. For instance, consider the URL: `/hello-world/path-variable/ashu`. In this case, "ashu" is a path parameter.

To capture these path parameter values in your Spring Boot application, you can use the `@PathVariable` annotation. It enables you to extract and use these dynamic values in your REST API methods.

### Request Methods for REST API

REST APIs use specific request methods to perform actions on resources:

- **GET**: Retrieve details of a resource.
- **POST**: Create a new resource.
- **PUT**: Update an existing resource.
- **PATCH**: Update part of a resource.
- **DELETE**: Delete a resource.

### Social Media Application REST API Structure:**

**Key Resources:**
- Users
- Posts

**Users REST API:**

- Retrieve all users: `GET /users`
- Create a user: `POST /users`
- Retrieve one user: `GET /users/{id}` (e.g., `/users/1`)
- Delete a user: `DELETE /users/{id}` (e.g., `/users/1`)

**Posts REST API:**

- Retrieve all posts for a user: `GET /users/{id}/posts`
- Create a post for a user: `POST /users/{id}/posts`
- Retrieve details of posts: `GET /users/{id}/posts/{post id}`

This REST API structure defines how we interact with resources in a Social Media Application, including users and their posts.

- Response Entity: `use to represent the HTTP response returned from a controller method. It allows us to customize and control the HTTP response, including status code, headers and response body , when building RESTful web services or APIs`
- ServletUriComponentsBuilder.fromCurrentRequest(): `useful for generating URIs that are related to the current request, such as for creating links to other resources, redirecting to specific URLs etc.`

```sh
URI location = ServletUriComponentsBuilder.fromCurrentRequest()
.path("/{id}")
.buildAndExpand(savedUser.getId())
.toUri();
```
- ResponseStatus: `When an endpoint returns successfully, Spring provides an HTTP 200 (OK) response. If we want to specify the response status of a controller method, we can mark that method with @ResponseStatus. It has two interchangeable arguments for the desired response status: code, and value.
  For example, we can indicate that the server refuses to brew coffee because it is a teapot:`

```sh
@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
void teaPot() {}
```