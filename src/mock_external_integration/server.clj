(ns mock-external-integration.server
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.handler :refer [site]]
            [environ.core :refer [env]]
            [mock-external-integration.handler :refer [app]])
  (:gen-class))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]

    ;; bootstrap checks
    (assert (env :gateway-path-email))

    ;; start server
    (run-server (site app) {:port port :join? false})))
