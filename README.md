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
