# microservices
# port details
   department service: 9001
   user service: 9002
   eureka service-registry: 8761
   api-gateway: 9191
   cloud-config-server: 9000
   zipkin: 9411
  
 # cloud-config-server - https://github.com/ab-gobi/cloud-config.git
    Generic configurations that is common to all microservices should be maintained here and it avoids the common configuration modification for 
    every microservices individually
        # Configuration in cloud config server component  (application.properties or application.yml)   
             spring:
              cloud:
                config:
                  server:
                    git:
                        uri: https://github.com/ab-gobi/cloud-config.git
                        clone-on-start: true
                        
        # Configuration in cloud config client component  (bootstrap.yml)
              spring:
                  cloud:
                    config:
                      enabled: true
                      uri: http://localhost:9000
                      
  # service-registry - http://localhost:8761/
     Every services to be registered with service registry server with spring application name. Its a common configuration so this conf will be maintained in cloud config             server
     eureka:
       client:
         register-with-eureka: true
         fetch-registry: true
       service-url:
         defaultZone: http://localhost:8761/eureka/
       instance:
         hostname: localhost
      
 # api-gateway server - http://localhost:9191
     Every api calls should go to this api gateway server and it takes care of redirecting to the microservices according to the uri which is configured in the properties as below
     spring:
       cloud:
         gateway:
           routes:
           - id: USER-SERVICE
             uri: lb://USER-SERVICE
             predicates:
               - Path=/users/**
           - id: DEPARTMENT-SERVICE
             uri: lb://DEPARTMENT-SERVICE
             predicates:
               - Path=/departments/**

# department-service - http://localhost:9001
# user-service - http://localhost:9002
# zipkin-server for distributed log tracing - 127.0.0.1:9411**
  spring.zipkin.base-url=http://127.0.0.1:9411/ - to be configured in the client application properties
________________________________________________________________________________________________________________________________________________________________________________ 
