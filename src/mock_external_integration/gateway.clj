(ns mock-external-integration.gateway
  (:require [environ.core :refer [env]]))

(defn get-emails
  []
  (let [{:keys [status body]}
         @(http/get (str (env :gateway-path-email) "/"))]
    ))
