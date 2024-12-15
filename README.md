# dedicated-thread-for-actuator-endpoints

Problem Statement
By default, actuator endpoint requests in Spring Boot are served by the same thread pool as regular HTTP requests, which is typically the Tomcat HTTP connector thread pool. This means that actuator endpoint requests will compete with regular HTTP requests for thread resources.

In scenarios when there is high traffic on the application, all 200 threads in the thread pool get occupied. This prevents Kubernetes from successfully checking the health endpoint in production, resulting in service downtime. To prevent such situation, we need to run actuator endpoint requests on a separate thread pool than the regular.



Solution

Without Separate Thread Pools:
+-------------------------+
| Main Thread Pool          |--- User Requests
|    Queue                  |--- Actuator Requests
+------------------------+

Actuator request has to wait in the Main Queue.

With Separate Thread Pools:
+-------------------------+        +-----------------------------+
| Main Thread Pool  |                | Actuator Thread Pool   |
|    Queue                |          |        Queue                  |
+------------------------+        +------------------------------+

Actuator request is handled independently.



To achieve separate thread pool for actuator requests we can implement following solutions:

1. Define a separate port for actuator endpoints in application.properties file using management.server.port.

Pros:

Serves actuator endpoint requests on a separate port.
It only allows to serve actuator endpoint requests and blocks the actuator requests on main application port.
Cons:

Using above approach, it results in the creation a new connector with a separate thread pool,  running on a distinct port. But this approach does not provides much control on the properties of created thread pool as spring boot currently does not provide any direct configuration to set the properties of management server thread pool like max-threads.



2. Adding a new connector using TomcatServletWebServerFactory in embedded tomcat server instance.

Pros:

Serves actuator endpoint requests on a separate port.
Provides more control over configuring the properties of new thread pool.
Cons:

It allows both user requests and actuator requests to be served on both the ports.