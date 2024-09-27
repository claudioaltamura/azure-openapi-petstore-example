# azure-openapi-petstore-example

## API

### Convert OpenAPI Spec to Postman Collection
```
    npm i -g openapi-to-postmanv2 
    
    openapi2postmanv2 -s src/main/resources/petstore-expanded.json -o postman-collection.json -p -O folderStrategy=Tags,includeAuthInfoInExample=false
```