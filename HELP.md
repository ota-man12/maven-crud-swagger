# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/#build-image)

# Full Stack Application

## Setup

1. Clone the repository:
    ```bash
    git clone [https://github.com/yourusername/fullstack-application.git](https://github.com/ota-man12/maven-crud-swagger.git)
    cd fullstack-application
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Using Swagger for API Documentation

Swagger provides interactive documentation for your API, making it easy to understand and test your endpoints.

1. **Access Swagger UI**: Once your application is running, navigate to the Swagger UI in your web browser:

    ```
    http://localhost:8080/swagger-ui/index.html
    ```

    Replace `localhost:8080` with your server address and port if it's different.

2. **Explore API Endpoints**: In the Swagger UI, you'll find a list of available endpoints along with descriptions and example requests and responses. Click on each endpoint to expand it and see more details.

3. **Try Out Endpoints**: Swagger UI allows you to test your endpoints directly from the browser. Click on the "Try it out" button, provide any required parameters, and execute the request. You'll see the response right there in the UI.

4. **View API Documentation**: Swagger UI generates API documentation automatically based on your annotations. Navigate through the documentation to understand how each endpoint works and what it expects in terms of inputs and outputs.

By following these steps, you can easily use Swagger to document and test your API endpoints. It provides a user-friendly interface for developers to interact with your API without the need for external tools.

## API Endpoints

- **PUT /api/users**: Add a new user.
    ```json
    {
        "userId": "1",
        "firstName": "John",
        "lastName": "Doe",
        "contactNumber": "1234567890"
    }
    ```

- **POST /api/users/{userId}**: Update an existing user.
    ```json
    {
        "firstName": "Jane",
        "lastName": "Doe",
        "contactNumber": "0987654321"
    }
    ```

- **GET /api/users/{userId}**: Retrieve a user by ID.

- **DELETE /api/users/{userId}**: Delete a user by ID.
