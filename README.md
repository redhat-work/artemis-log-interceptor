# Artemis Log Interceptor

## Compile
```
git clone https://github.com/redhat-work/artemis-log-interceptor.git
cd artemis-log-interceptor
mvn clean install
```

## Install
put the generated .jar file inside the lib folder of artemis


## Enable

```
<remoting-incoming-interceptors>
    <class-name>com.redhat.consulting.LoggingInterceptor</class-name>
</remoting-incoming-interceptors>

<remoting-outgoing-interceptors>
    <class-name>com.redhat.consulting.LoggingInterceptor</class-name>
</remoting-outgoing-interceptors>
```

## Thanks To:
https://github.com/angelogalvao