 Eazy School - Web Application
This is a Spring Boot + Thymeleaf project that started as a simple study case but evolved into something bigger! Initially, we were given the basic homepage, but I decided to expand it by adding new features like Contact Page, Courses, and a functional contact form that stores messages in a MySQL database.

🔹 Features I Implemented
✅ Contact Page:
Created a form where users can enter their name, email, and message.
The messages are saved in a MySQL database using Spring Data JPA.
✅ Google Maps / TomTom API Integration:
Originally, I wanted to use Google Maps, but I learned about TomTom and managed to integrate it into the project!
✅ Spring Boot Backend (Controller + Service + Repository):
Created a ContactMessage model and stored user messages in a database.
Set up a Repository and Service to handle data storage and retrieval.
✅ Dynamic Pages with Thymeleaf:
Used Thymeleaf for rendering pages dynamically.
Integrated Bootstrap for styling.
✅ Database Connection (MySQL):

Configured Spring Data JPA and MySQL connection in application.properties.
Used Hibernate to map the ContactMessage entity.
