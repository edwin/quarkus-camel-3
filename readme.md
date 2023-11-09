# Running Camel on Top of Quarkus

## How To
Run the app
```
$ mvn quarkus:dev -s settings.xml
```

Test Rest API
```
$ curl -kv http://localhost:8080/api/hello-world
*   Trying ::1:8080...
* TCP_NODELAY set
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /api/hello-world HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.65.0
> Accept: */*
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 OK
< Accept: */*
< User-Agent: curl/7.65.0
< transfer-encoding: chunked
< Content-Type: application/json
<
* Connection #0 to host localhost left intact
{"hello":"world"}                                   
```