(ns url-shortner-service.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :refer [redirect]]))

(def urls {"ldnclj" "http://londonclojurians.org"})

(defn handle-form [request] "Create a new short code")

(defn short-code
  "Returns the short code for the url"
  [request]
  (str "please implement me"))

(defn handle-short-code [request]
  (if-let [url (urls (:possible-code (request :params)))]
    (redirect url)
    (route/not-found "Unknown short code")))

(defroutes app-routes
  (GET "/" [] (redirect "/index.html"))
  (route/resources "index.html")
  (GET "/url/:url-short-code" [] short-code)
  (POST "/url-form/submit" [] handle-form)
  (GET "/:possible-code" [] handle-short-code)
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
