(defproject url-shortner-service "0.1.0-SNAPSHOT"
  :description "A simple webservice to create short aliases for web addresses"
  :url "https://github.com/jr0cket/url-shorten-service"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler url-shortner-service.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
