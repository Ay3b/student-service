# student-service

(base) ayyub@MacBook-Air-de-Ayyub efrei.net % curl -X POST -H "Content-Type: application/json" -d '{"name": "John Doe", "age": 25}' http://localhost:8080/api/students {"id":6,"name":"John Doe","age":25}% (base) 

ayyub@MacBook-Air-de-Ayyub efrei.net % curl -X PUT -H "Content-Type: application/json" -d '{"name": "Updated Name", "age": 30}' http://localhost:8080/api/students/6 {"id":6,"name":"Updated Name","age":30}% (base) 

ayyub@MacBook-Air-de-Ayyub efrei.net % curl -X DELETE http://localhost:8080/api/students/6 (base) 

ayyub@MacBook-Air-de-Ayyub efrei.net % curl -X POST -H "Content-Type: application/json" -d '{"name": "John Doe", "age": 25}' http://localhost:8080/api/students
{"id":7,"name":"John Doe","age":25}% (base) 

ayyub@MacBook-Air-de-Ayyub efrei.net % curl -X PUT -H "Content-Type: application/json" -d '{"name": "Updated Name", "age": 30}' http://localhost:8080/api/students/7 {"id":7,"name":"Updated Name","age":30}% (base) 

ayyub@MacBook-Air-de-Ayyub efrei.net % curl -X DELETE http://localhost:8080/api/students/7

#Commandes Docker :

docker build -t mon-image-docker:latest .
docker run -p 8080:8080 --name mon-nouveau-conteneur mon-image-docker:latest
