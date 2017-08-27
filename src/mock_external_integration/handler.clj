(ns mock-external-integration.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]

            [schema.core :as schema]
            [mock-external-integration.schema :as ms]))

(defn handle-get-email
  ([] {})

  ([email-id] {}))

(defapi app
  {:swagger
   {:ui "/"
    :spec "/swagger.json"
    :data {:info {:title "Mock API"
                  :description "Motiva mock API for external integration development"
                  :version "1.0"}
           :tags [{:name "api", :description "some apis"}]}}}

  (context "/api" []

    (context "/asset" []

      (context "/email" []
        :tags ["email"]

        (GET "/" []
          :return [ms/Email]
          :summary "fetch a list of email assets"
          (ok (handle-get-email)))

        (GET "/:email-id" []
          :path-params [email-id :- schema/Int]
          :return ms/Email
          :summary "fetch a particular email asset"
          (ok (handle-get-email email-id))))

      ;(GET "/segment" [])

      ;(GET "/segment/:segment-id" [])
      )))
