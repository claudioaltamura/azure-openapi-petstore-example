# azure-openapi-petstore-example

## Backend

## Compile
```
    ./mvnw clean compile  
```

## Run
```
    ./mvnw spring-boot:run
```

## Swagger Docu
```
    http://localhost:8080/swagger-ui/index.html#/
```

## OpenAPI Spec
```
    curl http://localhost:8080/v3/api-docs
```

## Run example
```
    curl http://localhost:8080/v2/pets
```

## Convert OpenAPI Spec to Postman Collection
```
    npm i -g openapi-to-postmanv2 
    
    openapi2postmanv2 -s src/main/resources/petstore-expanded.json -o postman-collection.json -p -O folderStrategy=Tags,includeAuthInfoInExample=false
```