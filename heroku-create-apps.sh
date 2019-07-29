#!/usr/bin/env sh

heroku apps:create ieshop-market-ui
heroku addons:create heroku-postgresql:hobby-dev --app ieshop-market-ui
heroku config:set DB_DRIVER=org.postgresql.Driver HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect --app ieshop-market-ui
heroku config:set EUREKA_URI=https://ieshop-market-eureka.herokuapp.com/eureka --app ieshop-market-ui
heroku config:set HOST_NAME=https://ieshop-market-ui.herokuapp.com --app ieshop-market-ui

heroku apps:create ieshop-market-chatbot
heroku config:set BOT_NAME=chatbot --app ieshop-market-chatbot
heroku config:set EUREKA_URI=https://ieshop-market-eureka.herokuapp.com/eureka --app ieshop-market-chatbot
heroku config:set HOST_NAME=https://ieshop-market-chatbot.herokuapp.com --app ieshop-market-chatbot

heroku apps:create ieshop-market-eureka