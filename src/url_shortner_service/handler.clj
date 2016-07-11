(ns url-shortner-service.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def urls {})

(defn handle-form [request] "Create a new short code")

(defn short-code
  "Returns the short code for the url"
  [request]
  (str "please implement me"))

(defn handle-short-code [request] "Redirect to url")

(defroutes app-routes
  (GET "/" [] "Hello URL World")
  (GET "/url/:url-short-code" [] short-code)
  (POST "/url-form/submit" [] handle-form)
  (GET "/:possible-code" [] handle-short-code)
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
