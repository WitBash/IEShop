#!/usr/bin/env sh

heroku container:release web --app=ieshop-market-eureka
heroku container:release web --app=ieshop-market-chatbot
heroku container:release web --app=ieshop-market-ui