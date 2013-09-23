Start Jetty:
------------
mvn install
mvn jetty:run

Stop Jetty:
-----------
mvn jetty:stop

Tets RESTful Web Sevice:
------------------------
http://localhost:8080/sgm-restful/rest/optimize/get?o1=1

Test RESTFul client:
--------------------
mvn exec:java -Dexec.mainClass="org.epes.sgm.client.EpesClientGet"

mvn exec:java -Dexec.mainClass="org.epes.sgm.client.EpesClientPost"

Create Eclipse project:
-----------------------
mvn eclipse:eclipse

Copy dependencies to EPES VCN - Repo:
-------------------------------------
ant copy.dependencies