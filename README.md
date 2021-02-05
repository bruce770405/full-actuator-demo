# full-actuator-demo

![image](https://github.com/bruce770405/full-actuator-demo/blob/main/front.png)

We use this components to build a simple production enviorment include program monitoring ,process warning alert , containers and deploy node data monitoring.

## Side component: 

* node-exporter is going to help us to export deploy node's metrics.
* cadvisor is going to export container metrics.

## Technology
* Kotlin
* SpringBoot
* Gradle
* Prometheus
* Grafana
* AlertManager
* cadvisor
* node-exporter
* all feature in docker-compose


## Installation
  1. move to alertmanager folder , and open config.yml
  2. edit slack_configs.api_url to your slack webhook url
  3. back to project root
  4. key in docker-compose command 
```
docker-compose up -d
```
  5. now you can use your internal network to see this demo

## Default Enviorment Information

| Service name  | Port|
| ------------- | ------------- |
| the demo kotlin service app  | 8081  |
| prometheus  | 9090  |
| grafana  | 3000  |
| alertmanager  | 9003  |
| node-exporter  | 9100  |
| cadvisor  | 8080  |

  
## More Introduction
  If you have more interesting for this , you can browse my share article 
  [Article on Medium](https://brucehsu-developer.medium.com/microservices-%E7%B3%BB%E7%B5%B1%E7%9B%A3%E6%8E%A7%E6%9C%80%E4%BD%B3%E5%A4%A5%E4%BC%B4%E9%9B%86%E6%88%90-884570f81ae5?sk=00abd3ab4f7efd692f49b4c42603ec60 "Title")
