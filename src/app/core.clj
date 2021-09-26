(ns app.core
  (:require [org.httpkit.server :as httpkit]
            [compojure.core :refer [defroutes wrap-routes GET]]
            [app.pid :as pid])
  (:gen-class))

(set! *warn-on-reflection* true)

(defn with-logger [handler]
  (fn [req]
    (println "==============")
    (println "Request:" req)
    (let [resp (handler req)]
      (println "Response:" resp)
      resp)))

(defroutes router
  (GET "/ping" _ {} {:status 200 :body "pong" :headers {"Content-Type" "text/html"}}))

(defroutes app
  (wrap-routes router with-logger))

(defn -main [& args]
  (let [started-at (System/currentTimeMillis)]
    (httpkit/run-server app {:port 3000})
    (println (format "Server started after %dms, pid = %s"
                     (- (System/currentTimeMillis) started-at)
                     (pid/show)))))
