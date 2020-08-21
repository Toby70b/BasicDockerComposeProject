# Basic Docker Compose Project - Basic Todo App I created to learn more about docker and docker compose while doing a course

 ⛔ NOTE: this still a work in progess, as I discover new things I go back and edit this

## Rationale for development

I am doing a Udemy Course on docker and I wanted to get some hands on with both it and docker-compose 

## What is it?

This is a very simple "To Do" app, it just stores a list of things "To Do", its intentionally simple as the goal was to learn more about docker 

## Docker-Compose

Hopefully its pretty straight forward theres 1 mysql db, 1 spring boot web service, and 1 node.js-react UI

## REST API

The REST API is a spring boot project (created using spring initializr). The API is exposed (by default) on port 8080, it has full CRUD operations through its GET, POST, PUT and DELETE mappings

## UI

The UI is made with React with components from the ant design UI framework, all running on an node.js server. The UI allows the user to create To Do items and delete's them when the user marks an item as completed

## Things to improve
- [ ] Swaggerize the REST API for easier documentation
- [ ] Standardising the errors returned from the API, for easier consuming
- [ ] Logging to a file within the project, for easier debugging
- [ ] Adding security features
- [ ] More testing
- [ ] Probably a lot of cleanup and refactoring 
