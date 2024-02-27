<h1>Demo application to demonstrate during the <b>Caching with Spring</b> presentation</h1>
<h2>Database</h2>
Used H2 DB for data storage. <br/>
User table structure:
<ul>
<li>Id</li>
<li>First name</li>
<li>Last name</li>
<li>Date of birth</li>
<li>Address</li>
</ul>

URL to H2: http://localhost:8080/h2-console/login.do?jsessionid=ecb28b682a50168a2d111ad77d60256e

<h2>Functionality</h2>
Application has user management functionality. Endpoints:
<ul>
<li>
    <b>Get All Users<br/></b>
    GET: http://localhost:8080/all-users
</li>
<li>
    <b>Get User by ID</b><br/>
    GET: http://localhost:8080/user/{user_id}
</li>
<li>
    <b>Update User</b><br/>
    POST: http://localhost:8080/user<br/>
    Body:<br/>

    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "dateOfBirth": "1990-05-15",
        "address": "123 Main Street, Cityville"
    }
</li>
<li>
    <b>Get Users by First and Last names</b><br/>
    GET: http://localhost:8080/user?firstName={first_name}&lastName={last_name}
</li>
<li>
    <b>Evict cache</b><br/>
    GET: http://localhost:8080/evict
</li>
<li>
    <b>Debug Cache Manager</b><br/>
    GET: http://localhost:8080/cache-manager
</li>
</ul>

<h2>Actuator</h2>
Actuator cache endpoint: http://localhost:8080/actuator/caches
