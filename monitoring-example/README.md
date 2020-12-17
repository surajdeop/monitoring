Welcome to this repository, which goes along with the *Tom Gregory Tech* Youtube series
and the *tomgregory.com* blog series!

There are 4 parts to the series:

* Part 1: Fundamentals ([blog](https://tomgregory.com/monitoring-a-spring-boot-application-part-1-fundamentals/)|[video](https://www.youtube.com/watch?v=YKT-bypm1wc&t=135s_))
* Part 2: Prometheus ([blog](https://tomgregory.com/monitoring-a-spring-boot-application-part-2-prometheus/)|[video](https://www.youtube.com/watch?v=PFVEFs1r0Is&t=416s))
* Part 3: Rules & Alerting ([blog](https://tomgregory.com/monitoring-a-spring-boot-application-part-3-rules-and-alerting/)|[video](https://www.youtube.com/watch?v=se0YVsAYnAM))
* Part 4: Visualisation & Graphing ([blog](https://tomgregory.com/monitoring-a-spring-boot-application-part-4-visualisation-and-graphing/)|[video](https://youtu.be/_6R1VssiCg8))

Each part is tagged in the repository, so you can checkout the code and follow
along with the video/blog post. e.g.

`git checkout part2`

Note that part 1 isn't tagged as it doesn't have a code example component.

## Pre-requisites

* Docker

## Running

1. Configure *alertmanager.yml* with your Gmail address and app
password (if you want alerts to be sent to your email address)
1. Run `docker-compose up`

## Using

* Prometheus is available at [http://localhost:9090](http://localhost:9090)
* AlertManager is available at [http://localhost:9093](http://localhost:9093)
* Grafana is available at [http://localhost:3000](http://localhost:3000) (login is admin/admin)
* Application metrics are available at [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)
* Application endpoint is available at [http://localhost:8080/doit](http://localhost:8080/doit)
* Try importing the JVM (Micrometer) [dashboard](https://grafana.com/grafana/dashboards/4701) with ID 4701

