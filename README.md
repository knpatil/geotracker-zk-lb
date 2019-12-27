Start the services in following order

- start zookeeper
    - docker-compose -f docker-compose-zk.yaml up
- start 2 instances of geotracker
    - docker run --net geotracker_default --link zookeeper knpatil/geotracker:5
- start geotracker-zk-lb
    - docker run -p 8080:8080 --net geotracker_default --link zookeeper knpatil/geotracker-zk-lb
    
Use postman or curl to send GET and POST requests.
