(defproject mock-external-integration "0.1.0-SNAPSHOT"
  :description "Motiva Mock API"
  :url "https://motiva-mock.herokuapp.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [metosin/compojure-api "2.0.0-alpha7"]
                 [environ "1.1.0"]

                 ;; server
                 [http-kit "2.2.0"]
                 [javax.servlet/servlet-api "2.5"]

                 ;; data
                 [prismatic/schema "1.1.6"]]

  :ring {:handler mock-external-integration.handler/app}
  :uberjar-name "server.jar"
  :main mock-external-integration.server
  :min-lein-version "2.0.0"

  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]
                                  [cheshire "5.5.0"]
                                  [ring/ring-mock "0.3.0"]
                                  [circleci/bond "0.3.0"]]
                   :plugins [[lein-ring "0.12.0"]]}})
