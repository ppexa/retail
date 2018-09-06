# myRetail

Running Instructions:
* Clone directly at, https://github.com/ppexa/retail.git
* Run in IDE or with maven
* The database used is MongoDB, https://www.mongodb.com/
* The app is available on a TomCat server at, http://localhost:8080

* To use the form to add a product go to, http://localhost:8080/products/create/form
* Everything else uses JSON
* To list all products, /products
* To create a product, /products/create?name=<name>&price=<price>&currency=<currency>&department=<department>
* To update a product, /products/update?productId=<productId>&name=<name>&price=<price>&currency=<currency>&department=<department>
* To delete a product, /products/delete/<productId>

Technology Stack:
* Java
* Spring Boot
* Maven
* MongoDb
* JSP