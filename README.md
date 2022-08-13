# crypto-trade-bot
Automated cryptocurrency trading system

<p align="center">

<!--  <a href="https://crypto-trade-bot.com" target="_blank">
    <img alt="amplication-logo" height="70" alt="Amplication Logo" src="https://crypto-trade-bo.com/images/app-logo.svg"/>
  </a>
</p>
<p align="center">
    <a href="https://docs.crypto-trade-bot.com/docs/">Docs</a> <a href="https://twitter.com/crypto-trade-bot">Twitter</a>
</p>
-->
  
Crypto-trade-bot is an open‑source cryptocurrency trading tool. In the first place this tool can <b>simulate</b> crypto tradings according to real market cap data. A math indicator was implemented do analyse data and decide whether it should buy or sell a given cryptocurrency.

Upcoming versions will provide real trading though Binance API using your account's balance.   
  
# Features

Build database applications with:

- Integration with Binance API for data fetch 
- REST API built in Java using Spring for CRUD with relations, sorting, filtering, pagination
- Crypto operations based on math analytics
- Role-based access control
- Docker and docker-compose integration
- AWS deployment

# Getting Started

You can get started with crypto-trade-bot immediately on ```URL``` 

Alternatively you can set up a local development environment.

### System Requirements

:bulb: Before you begin, make sure you have all the below installed:

- [JRE](https://www.java.com/en/download/manual.jsp)
- [Docker](https://docs.docker.com/desktop/)
- [PostgreSQL](https://www.postgresql.org/download/)

### Running the app

Crypto-trade-bot is running with a PostgreSQL database. 

1. Initialize a database connection with the following data: <br/>
  Host:```http://localhost/``` <br/>
  Door:```8080``` <br/>
  Username:```root``` <br/>
  Password:```root``` 
  
1. Execute the following commands in the project root folder:

```jsx
docker-compose up
```
This will initialize the database connection.

2. Still in the root directory, execute the following command:
  
```jsx
mvnw clean package
  
docker build -t crypto-trade-bot:v1 .
  
docker run -p 8080:8080 --name NAME crypto-trade-bot:v1
```
https://github.com/acenelio/ms-course/tree/docker
# Support

## Ask a question about crypto-trade-bot

You can ask questions, and participate in discussions about crypto-trade-bot-related topics in the Whatsapp chat: +5519996698179

## Create a bug report

If you see an error message or run into an issue, please [create bug report](https://github.com/DanielDomingueti/crypto-trade-bot/issues/new). This effort is valued and it will help all crypto-trade-bot users.

# Contributing

Crypto-trade-bot is an open-source project. We are committed to a fully transparent development process and appreciate highly any contributions. Whether you are helping us fix bugs, proposing new features, improving our documentation or spreading the word - we would love to have you as part of the crypto-trade-bot community.
