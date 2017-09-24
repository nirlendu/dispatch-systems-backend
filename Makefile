build:
	mvn clean install

run-dev:
	make build && java -jar app/target/app-app-1.0.0.jar server config/dev/config.yml

run-prod:
	make build && java -jar app/target/app-app-1.0.0.jar server config/prod/config.yml