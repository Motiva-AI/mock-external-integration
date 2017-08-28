(ns mock-external-integration.gateway
  (:require [org.httpkit.client :as http]
            [environ.core :refer [env]]
            [cheshire.core :as json]))

(defn emails
  []
  (let [{:keys [status body]}
         @(http/get (str (env :gateway-path-email) "/"))

         body ((json/parse-string body true))]
    ;; validate body schema and throw error

    ))

(defn email
  [email-id]
  (let [{:keys [status body]}
         @(http/get (str (env :gateway-path-email) "/" email-id))

         body ((json/parse-string body true))]

    ;; TODO
    ))
