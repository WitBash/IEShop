#!/usr/bin/env sh

heroku dyno:restart --app ieshop-market-chatbot
heroku dyno:restart --app ieshop-market-ui
heroku dyno:restart --app ieshop-market-eureka