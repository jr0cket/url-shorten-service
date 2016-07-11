(ns url-shortner-service.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :refer [redirect]]))

(def urls (atom {"ldnclj" "http://londonclojurians.org"}))

(defn handle-form [request]
  (let [{:keys [url short-code] } (:params request)]
    (swap! urls assoc short-code url)
    (format "<p>Created short code <a href=\"/%s\">%s</a> for %s</p>" short-code  short-code url)))

(defn short-code
  "Returns the short code for the url"
  [request]
  (str "please implement me"))

(defn handle-short-code [request]
  (if-let [url (@urls (:possible-code (request :params)))]
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
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
