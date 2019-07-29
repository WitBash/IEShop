#!/usr/bin/env sh

heroku apps:destroy ieshop-market-ui --confirm ieshop-market-ui
heroku apps:destroy ieshop-market-chatbot --confirm ieshop-market-chatbot
heroku apps:destroy ieshop-market-eureka --confirm ieshop-market-eureka