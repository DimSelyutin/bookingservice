# Hotel Management Service

![Logo](path/to/logo.png) <!-- Optional: Add your service's logo here -->

## Overview

The Hotel Management Service is a RESTful API designed to manage hotel information, including creating, retrieving, updating, and searching for hotels and their amenities. This service aims to simplify hotel management for developers and operators in the hospitality industry.

## Features

- Retrieve a list of all hotels with brief information.
- Get detailed information about a specific hotel.
- Search for hotels by various parameters (name, brand, city, country, amenities).
- Create new hotel entries.
- Add amenities to existing hotels.
- Get a histogram of hotels grouped by specified attributes.

## API Documentation

The API is documented using [OpenAPI](https://swagger.io/specification/) and can be found in the `openapi.yaml` file located in the root directory of the project.

### Available Endpoints

1. **GET /hotels**: Get a list of all hotels.
2. **GET /hotels/{id}**: Get detailed information about a specific hotel.
3. **GET /search**: Search for hotels based on multiple parameters.
4. **POST /hotels**: Create a new hotel.
5. **POST /hotels/{id}/amenities**: Add amenities to a hotel.
6. **GET /histogram/{param}**: Get the count of hotels grouped by the specified parameter (`brand`, `city`, `country`, `amenities`).

Refer to the OpenAPI documentation for detailed information on request/response formats.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.4 or higher
- Docker (for running integration tests with Testcontainers)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/hotel-management-service.git
   cd hotel-management-service
