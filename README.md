# 📝 Blog Application

A simple **Blog Application** built with **Spring Boot, JPA, and Hibernate**.  
This project demonstrates RESTful CRUD operations and seamless database integration using Spring Boot.

---

## 🚀 Features

- Create, Read, Update, and Delete (CRUD) blog posts
- RESTful API endpoints for managing blogs
- Spring Data JPA for easy database access
- Configurable database support (MySQL, PostgreSQL, etc.)
- Exception handling and logging for reliability
- Secure password storage with **BCrypt**
- Authentication and authorization via Spring Security (optional)

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot, Spring Data JPA, Hibernate
- **Database:** MySQL (can be swapped with PostgreSQL, H2, etc.)
- **Security:** Spring Security with JWT (optional)
- **Build Tool:** Maven
- **IDE:** Eclipse / IntelliJ IDEA

---

## 📂 Project Structure

```
Blog/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/    # Application source code
│   │   └── resources/                # Config files (application.properties)
│   └── test/                         # Unit and Integration tests
├── pom.xml                           # Maven dependencies
└── README.md                         # Project documentation
```

---

## ⚙️ Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/rishabh941/Blog.git
   cd Blog
   ```

2. **Configure the database in `src/main/resources/application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Build and run the application**
   ```bash
   mvn spring-boot:run
   ```

---

## 🌐 Usage & API Reference

API Base URL: `http://localhost:8080/api/blogs`

### Example Endpoints

- `POST /api/blogs` → Create a new blog post
- `GET /api/blogs` → List all blog posts
- `GET /api/blogs/{id}` → Get a single blog post by ID
- `PUT /api/blogs/{id}` → Update blog post by ID
- `DELETE /api/blogs/{id}` → Delete blog post by ID

---

## 🧪 Testing

Run the tests using:

```bash
mvn test
```

---

## 🔮 Future Enhancements

- Add a frontend (React/Next.js)
- Pagination and search for blogs
- Role-based access (admin, user)
- Deployment on AWS / Heroku / Render

---

## 📄 License

This project is licensed under the MIT License.

---

## 👤 Author

Made with ❤️ by [rishabh941](https://github.com/rishabh941)