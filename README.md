# running-information-analysis-service


## How to run


1. First start MySQL Docker container(see command below)

2. Under project folder

```
mvn clean install

cd target

java -jar running-information-analysis-service-1.0.0-SNAPSHOT.jar
````




## Docker Mysql Running Command:


### Install docker
```
sudo apt-get install docker.io
```
### Install mysql images
```
docker run --name running_information_analysis_db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=running_information_analysis_db -e MYSQL_USER=root -e MYSQL_PASSWORD=root -p 3306:3306 -d mysql:5.6
```
### Run docker container
```
docker start running_information_analysis_db 
```
### Stop docker container
```
docker stop running_information_analysis_db 
docker stop running_information_analysis_db 
```
### check docker process
```
docker ps -a
```

## Steps
1. Analyze GET request field/prop with POST Info
	- Create new domain entity/ Add prop/field to domain/entities
2. create RunningInfoRepository as DAO

3. Create new Service by interface and impl (RunningInformationAnalysisService)
4. Setup RestAPI, mapping with route
5. Test in h2 DB
6. Setup mySQL in Docker
7. Configure jdbc file, Application.properties hook with mySQL
8. Test in mySQL
9. Turn in git
