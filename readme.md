# Running Camel on Top of Quarkus

## How To
Run the app
```
$ mvn quarkus:dev -s settings.xml
```

Test Rest API 1
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

Test Rest API 2
```
$ curl -kv http://localhost:8080/api/hello-world-hashmap
*   Trying ::1:8080...
* TCP_NODELAY set
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /api/hello-world-hashmap HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.65.0
> Accept: */*
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 OK
< Accept: */*
< User-Agent: curl/7.65.0
< Content-Length: 17
< Content-Type: application/json
<
* Connection #0 to host localhost left intact
{"hello":"world"}                    
```

Test Rest API 3, where we do an external API call as an example.
```
$  curl -kv http://localhost:8080/api/google
*   Trying ::1:8080...
* TCP_NODELAY set
*   Trying 127.0.0.1:8080...
* TCP_NODELAY set
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /api/google HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.65.0
> Accept: */*
>
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 OK
< Alt-Svc: h3=":443"; ma=2592000,h3-29=":443"; ma=2592000
< Content-Security-Policy-Report-Only: object-src 'none';base-uri 'self';script-src 'nonce-RkQ6U_dnY1oXqLstzCNPaw' 'strict-dynamic' 'report-sample' 'unsafe-eval' 'unsafe-inline' https: http:;report-uri https://csp.withgoogle.com/csp/gws/other-hp
< Expires: -1
< P3P: CP="This is not a P3P policy! See g.co/p3phelp for more info."
< Server: gws
< Set-Cookie: 1P_JAR=2023-11-09-09; expires=Sat, 09-Dec-2023 09:50:47 GMT; path=/; domain=.google.com; Secure
< Set-Cookie: AEC=Ackid1RZeivWX7G3qi0scfgdkYECO0CEn2akg6BBsXAKYuHmp90Vy-Zd6RA; expires=Tue, 07-May-2024 09:50:47 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax
< Set-Cookie: NID=511=X3iniZPw9D_xqAQa-mz-uhE9dAwQO_Db0LsQs5e4rqNdC4qS8WV-4HF-8JB1tdMLKqXaqCeE90FVvGphl6bte0FIYoMNM0LGZ43f6X3HHO1uQrGRaImCTO5Cx8dQKl650SOsxneLzIxYztscKKimlACFC7c9GQN1rBjvov3lYm4; expires=Fri, 10-May-2024 09:50:47 GMT; path=/; domain=.google.com; HttpOnly
< X-Frame-Options: SAMEORIGIN
< X-XSS-Protection: 0
< transfer-encoding: chunked
< Content-Type: text/html; charset=ISO-8859-1
<
<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="id"><head><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"><meta content="/images/branding/googleg/1x/googleg_standard_color_128dp.png" itemprop="image"><title>Google</title><script nonce="RkQ6U_dnY1oXqLstzCNPaw">(function(){var _g={kEI:'d6tMZZXVNciRseMPpoORsAU',kEXPI:'0,1365468,206,4804,2316,383,246,5,1129120,1827,85,1195869,620,380090,16114,28684,22431,1361,12319,17580,4998,17075,6884,31560,2872,2891,3926,4423,3405,606,30668,30022,16335,20583,4,4755,54862,4437,22616,6624,7593,1,11943,30211,2,39761,5679,1020,31122,4568,6253,23424,1252,33064,2,2,1,26632,8155,23351,872,19634,7,1922,9779,36284,6175,20199,20136,14,82,7651,12555,8377,8048,13218,3097,781,2249,15816,1804,13806,21462,11814,476,1157,285,2958,19621,11751,7653,1191,5223041,2,505,2,205,355,5992689,1209,2803214,3311,141,795,29783,173,100,15,20720477,3220020,4044106,14297,2375,43887,3,1558,5,542,3,552,1393390,23759270,11557,1242,8409,2878,335,1263,10223,1377,4835,13203,5456,5121,5878,1523,527,1488,702,11995,1238,3,1563,1519,1421,943,1464,2784,6777,5865,3,1688,2052,27,6,5,15,313,1064,3,1047,3369,4,872,438,664,764,7,9,987,1403,1068,367,2341,243,211,1054,735,169,332,419,349,220,2017,49,2734,3,611,820,745,46,561,872,802,523,440,394,1018,538,474,881,16,99,1375,678,573,108,376,477,153,50,943,4,1528,75,350,79,14,160,188,931,627,178,79,1,6,2588,268,603,183,6,6,225,269,850,12,1052,287,460,142,175,820,549,769,733,326,107,240,797,44,1005,125,371,44,2,520,129,302,413,19,34,104,6,21,1095,2,2,4,2,2,2,742,44,892,1071,2290,327,1787,2,566,3,541,433,26,439,93,97,39,198,368,4,2357,532,7,1,8,742,640,524,5,21352904,422120',kBL:'7oNW',kOPI:89978449};(function(){var a;(null==(a=window.google)?0:a.stvsc)?google.kEI=_g.kEI:window.google=_g;}).call(this);})();(function(){google.sn='webhp';google.kHL='id';})();(function(){
var h=this||self;function l(){return void 0!==window.google&&void 0!==window.google.kOPI&&0!==window.google.kOPI?window.google.kOPI:null};var m,n=[];function p(a){for(var b;a&&(!a.getAttribute||!(b=a.getAttribute("eid")));)a=a.parentNode;return b||m}function q(a){for(var b=null;a&&(!a.getAttribute||!(b=a.getAttribute("leid")));)a=a.parentNode;return b}function r(a){/^http:/i.test(a)&&"https:"===window.location.protocol&&(google.ml&&google.ml(Error("a"),!1,{src:a,glmm:1}),a="");return a}
.........
```