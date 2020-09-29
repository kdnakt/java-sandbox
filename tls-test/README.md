## Preparation

```
mvn install && mvn package
```

Add `ocsp.enable=true` to `java.security` if needed.


## Execution

java -Dcom.sun.net.ssl.checkRevocation=true -Djava.security.debug=certpath -jar target/tls-test-1.0-SNAPSHOT.jar https://gbiz-id.go.jp/top/
