FROM openjdk:8-alpine
ENV consumerKey=qSSUipKbiSkfnyxENuPtIm7ov
ENV consumerSecret=XOmpuuzgPUcnZ17RRsTbZKGt1uakT76oKjhsZCedvrxO5bAAUl
ENV accessToken=764879745590829056-otYyQRNVwKLvl4IT6gp4zmdsgfapDhC
ENV tokenSecret=35hYK3ForVj1Nsh8sTL0U8ksUUT6FxcLwQJcxUIn43HQV
COPY target/java_apps*.jar /usr/local/app/twitter/lib/twitter.jar
ENTRYPOINT ["java","-jar","/usr/local/app/twitter/lib/twitter.jar"]
