# Hands-On 4: Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)

Java Persistence API (JPA) is a Java specification (JSR 338) that defines a standard way to map Java objects to relational database tables. It provides interfaces and annotations for Object Relational Mapping (ORM), but it does not provide any implementation.

### Features
- Java specification for ORM
- Provides standard APIs for persistence
- Database independent
- Does not contain implementation
- Implemented by frameworks like Hibernate and EclipseLink

---

## Hibernate

Hibernate is an Object Relational Mapping (ORM) framework and one of the most popular implementations of JPA. It simplifies database operations by automatically converting Java objects into database records.

### Features
- Implements JPA specification
- Generates SQL automatically
- Supports HQL (Hibernate Query Language)
- Provides caching
- Supports Lazy and Eager loading
- Reduces JDBC boilerplate code

---

## Spring Data JPA

Spring Data JPA is a Spring Framework module built on top of JPA. It does not implement JPA itself but simplifies data access by reducing boilerplate code. It uses Hibernate as the default JPA implementation.

### Features
- Built on top of JPA
- Uses Hibernate internally
- Provides automatic CRUD operations
- Supports pagination and sorting
- Automatic transaction management
- Repository-based architecture

---

# Comparison Table

| Feature | JPA | Hibernate | Spring Data JPA |
|---------|-----|-----------|-----------------|
| Type | Specification | ORM Framework | Spring Module |
| Implementation | No | Yes | No |
| CRUD Operations | Standard API | Manual | Automatic |
| SQL Generation | No | Yes | Yes |
| Transaction Management | No | Manual | Automatic |
| Boilerplate Code | More | Medium | Very Less |
| Repository Support | No | No | Yes |
| Depends On | Java | JPA | JPA + Hibernate |

---

# Hibernate Example

```java
/* Method to CREATE an employee in the database */

public Integer addEmployee(Employee employee) {

    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {
        tx = session.beginTransaction();

        employeeID = (Integer) session.save(employee);

        tx.commit();

    } catch (HibernateException e) {

        if (tx != null)
            tx.rollback();

        e.printStackTrace();

    } finally {

        session.close();

    }

    return employeeID;
}
```

---

# Spring Data JPA Example

### EmployeeRepository.java

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

### EmployeeService.java

```java
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void addEmployee(Employee employee) {

        employeeRepository.save(employee);

    }
}
```

---

# Advantages

## JPA
- Standard specification
- Database independent
- Easy to switch implementations

## Hibernate
- Powerful ORM framework
- Automatic SQL generation
- Caching support
- HQL support
- Better performance

## Spring Data JPA
- Minimal code
- Automatic CRUD methods
- Repository pattern
- Pagination and sorting
- Easy integration with Spring Boot

---

# Conclusion

- **JPA** is a specification that defines how Java objects should be persisted.
- **Hibernate** is an ORM framework that implements the JPA specification.
- **Spring Data JPA** is a Spring module that simplifies database operations by reducing boilerplate code and internally uses Hibernate as the default JPA provider.

Spring Data JPA is preferred in modern Spring Boot applications because it provides automatic CRUD operations, transaction management, and repository support with minimal code.