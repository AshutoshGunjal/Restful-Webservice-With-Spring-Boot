# SOCIAL MEDIA APPLICATION | Restful-Webservice-With-Spring-Boot

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

**Response Entity:** Use to represent the HTTP response returned from a controller method. It allows us to customize and control the HTTP response, including status code, headers and response body , when building RESTful web services or APIs
- ServletUriComponentsBuilder.fromCurrentRequest(): `useful for generating URIs that are related to the current request, such as for creating links to other resources, redirecting to specific URLs etc.`

```sh
URI location = ServletUriComponentsBuilder.fromCurrentRequest()
.path("/{id}")
.buildAndExpand(savedUser.getId())
.toUri();
```
**ResponseStatus:** When an endpoint returns successfully, Spring provides an HTTP 200 (OK) response. If we want to specify the response status of a controller method, we can mark that method with @ResponseStatus. It has two interchangeable arguments for the desired response status: code, and value.
  For example, we can indicate that the server refuses to brew coffee because it is a teapot:

```sh
@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
void teaPot() {}
```

**Validation and Jakarta with Spring:**

Validation is a crucial aspect of any application. It ensures that the data your application processes are correct and useful. Without it, you'd be left dealing with 
inconsistent data, leading to bugs that are hard to trace and fix.

- Jakarta Bean Validation: `It's a specification that standardizes validation, making it easier and more efficient. WHen combined with Spring Boot, a popular framework 
for building Java applications, you get a powerful tool that simplifies validation, letting you focus on building your application's core functionality`

**Springdoc-openapi & Swagger UI:**
It helps to automate the generation of API documentation using spring boot projects. It works by examining the application at runtime to infer API semantics based on
spring configuration, class structure and various annotaions.
It automatically generates documentation in JSON/YAML and HTML format APIs. This doc is completed by comments using swagger API annotations.

# Content Negotiation

In the context of REST APIs, content negotiation refers to the ability to request different representations of the same resource using the same URI. This typically involves specifying preferences for content types (e.g., XML or JSON) or languages (e.g., English, Marathi, Dutch).

## Use Case Examples

### Different Content Types:

- XML
- JSON

### Different Languages:

- English
- Marathi
- Dutch

## How Consumers Communicate Preferences

### Accept Header (MIME Types):

Example: `application/xml`, `application/json`, etc.

### Accept-Language Header:

Example: `en` (English), `fr` (French), etc.

This mechanism allows consumers of the REST API to communicate their preferences to the provider, indicating the desired format or language for the representation of the resource. By including the appropriate headers in the HTTP request (e.g., `Accept` and `Accept-Language`), consumers can influence the type of response they receive from the API.

This flexibility in content negotiation enhances the interoperability of RESTful services, enabling clients to retrieve information in a format and language that best suits their requirements.

# Internationalization (i18n)

When your REST APIs have consumers around the world, it's crucial to customize responses to cater to users from diverse regions. This process is known as Internationalization (i18n).

## Customizing for Users Around the World

Internationalization involves adapting the content of your application to different languages and regions. One common approach is to leverage the HTTP Request Header - `Accept-Language`, which indicates the natural language and locale that the consumer prefers.

### Example Usage of `Accept-Language`:

- `en`: English ("Good Morning")
- `nl`: Dutch ("Goedemorgen")
- `fr`: French ("Bonjour")

By interpreting the `Accept-Language` header, your application can dynamically serve content in the preferred language and locale of the user, providing a more personalized and user-friendly experience.

This internationalization strategy ensures that your REST APIs can effectively serve a global audience, accommodating language and cultural preferences seamlessly.

- MessageSource: `Strategy Interface for resolving messages, with support for the parameterization and internationalization of such messages.`

# Versioning of REST API

When you've developed a robust REST API with a large user base, introducing changes, especially breaking changes, requires careful consideration. One effective solution is to implement versioning for your REST API.

## Scenario Example

Consider a scenario where you need to make a breaking change, such as splitting the 'name' field into 'firstName' and 'lastName'.

## Solution: Versioning Options

There are various options for implementing versioning in REST APIs:

1. **URI Versioning**:
  - Example: `/api/v1/resource`
  - Advantage: Explicit version in the URL, easy to understand.

2. **Request Parameter Versioning**:
  - Example: `/api/resource?version=1`
  - Advantage: Version specified as a parameter, flexibility.

3. **Request Header Versioning**:
  - Example: Include a custom header like `Api-Version: 1` in the request.
  - Advantage: Versioning information is separated from the URL, clean and less intrusive.

4. **Media Type Versioning**:
  - Example: `/api/resource` with `Accept: application/vnd.company.resource.v1+json`
  - Advantage: Versioning through the media type, especially useful for content negotiation.

Choose the versioning strategy that best aligns with your application's requirements and the preferences of your API consumers.

Implementing versioning ensures a smooth transition for your existing consumers while allowing you to evolve and improve your REST API over time.

# Versioning REST API - Factors to Consider

When considering versioning for your REST API, there are several factors to take into account:

## Factors to Consider:

1. **URI Pollution**:
  - Consider how versioning impacts your URI structure. Avoid excessive changes that may lead to URI pollution.

2. **Misuse of HTTP Headers**:
  - Be cautious about overloading or misusing HTTP headers for versioning, as it may conflict with their intended use.

3. **Caching**:
  - Versioning can affect caching strategies. Ensure compatibility with caching mechanisms to maintain performance.

4. **Browser Execution**:
  - Evaluate if the API can be conveniently executed directly in web browsers, taking into consideration versioning constraints.

5. **API Documentation**:
  - Keep API documentation updated to reflect the versioning strategy in use, helping consumers understand and adapt.

## Summary: No Perfect Solution

While versioning is essential for API evolution, there's no one-size-fits-all solution. Each approach has its trade-offs, and the choice depends on the specific needs of your application and users.

## Recommendation

Think about versioning even before you need it. Plan for scalability and anticipate how your API might evolve. Consider adopting a consistent versioning approach across your enterprise for clarity and ease of management.

# HATEOAS (Hypermedia As The Engine Of Application State)

In the world of APIs, providing data is just one aspect. What if APIs could also guide consumers on how to perform subsequent actions? This is where HATEOAS (Hypermedia As The Engine Of Application State) comes in.

## Key Concept

Websites allow users to not only view data but also perform actions. HATEOAS extends this concept to APIs by enriching responses with hypermedia links, providing consumers with guidance on what actions they can take next.

## Implementation Options

1. **Custom Format and Implementation:**
  - *Challenge:* Difficult to maintain.
  - *Pros:* Complete flexibility.
  - *Cons:* Requires more effort and may lack standardized conventions.

2. **Use Standard Implementation:**
  - *Example:* HAL (JSON Hypertext Application Language)
  - *Pros:* Standardized format.
  - *Cons:* May not cover all use cases.

3. **Spring HATEOAS:**
  - *Pros:* Generates HAL responses with hyperlinks to resources.
  - *Cons:* Tied to the Spring ecosystem.

## HAL (JSON Hypertext Application Language)

HAL is a simple format that provides a consistent way to hyperlink between resources in your API. It's a standard that helps in creating self-describing APIs.

## Spring HATEOAS

If you are working in a Spring ecosystem, Spring HATEOAS is a powerful tool. It automates the generation of HAL responses, making it easier to include hyperlinks in your API responses.

### Example

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "_links": {
    "self": {
      "href": "/api/users/123"
    },
    "orders": {
      "href": "/api/users/123/orders"
    }
  }
}
```

# Customizing REST API Responses - Filtering and more...

When working with REST APIs, customizing the response is often crucial. Serialization, the process of converting objects to a stream (e.g., JSON), plays a significant role in shaping API responses. In Java, Jackson is a widely used framework for JSON serialization.

## JSON Serialization with Jackson

### Most Popular JSON Serialization in Java: Jackson

Jackson is a popular choice for JSON serialization in Java. It provides powerful features to customize the way JSON is generated.

### Customizing REST API Responses with Jackson

- **Customize Field Names in Response:**
  - Use `@JsonProperty` annotation to define custom field names in the JSON response.

- **Return Only Selected Fields:**
  - Implement filtering to return only selected fields in the API response.

### Filtering

Filtering is a technique to control what data gets serialized and returned in the API response.

- **Static Filtering:**
  - Apply the same filtering for a bean across different REST APIs.
  - Use annotations like `@JsonIgnoreProperties` and `@JsonIgnore`.

- **Dynamic Filtering:**
  - Customize filtering for a bean for specific REST APIs.
  - Use `@JsonFilter` in combination with a `FilterProvider`.

### Example

```java
public class User {
    @JsonProperty("user_id")
    private Long userId;
    
    @JsonIgnore
    private String password;
    
    // Other fields, getters, and setters...
}
```

