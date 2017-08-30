(ns mock-external-integration.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]

            [schema.core :as schema]

            [mock-external-integration.schema :as ms]
            [mock-external-integration.gateway :as gw]))

(defn handle-get-email
  ([] (ok (gw/emails)))

  ([email-id] (ok (gw/email email-id))))

(defn handle-get-segment
  ([]
   (ok))

  ([segment-id]
   (ok)))

(defapi app
  {:swagger
   {:ui "/"
    :spec "/swagger.json"
    :data {:info {:title "Mock API"
                  :description "Motiva mock API for external integration development"
                  :version "1.0"}
           :tags [{:name "api", :description "some apis"}]}
    :options {:ui {:docExpansion :list}}}}

  (context "/api" []

    (context "/asset" []

      (context "/email" []
        :tags ["email"]

        (GET "/" []
          :return [ms/Email]
          :summary "fetch a list of email assets"
          (handle-get-email))

        (GET "/:email-id" []
          :path-params [email-id :- schema/Int]
          :return ms/Email
          :summary "fetch a particular email asset"
          (handle-get-email email-id)))

      (context "/segment" []
        :tags ["segment"]

        (GET "/" []
          :return [ms/Segment]
          :summary "fetch a list of segment assets"
          (handle-get-segment))

        (GET "/:segment-id" []
          :path-params [segment-id :- schema/Int]
          :return ms/Segment
          :summary "fetch a particular segment asset"
          (handle-get-segment))))

    (context "/experiment" []
      :tags ["experiment"]

      (GET "/:experiment-id" []
        :summary "fetch a particular experiment meta information"
        (ok))

      (GET "/" []
        :summary "fetch a list of experiments for this user"
        (ok))

      (POST "/" []
        :summary "Create a new experiment to send out messages"
        :return schema/Uuid
        :body   [experiment ms/Experiment]
        (ok)))

    (context "/export" []

      (context "/activities" []
        :tags ["activities"]

        (GET
          "/:program-id" []
          :summary "fetch a list of activities export jobs for a given program"
          (ok))

        (POST "/:program-id" []
          :summary "Create a request to export activities for a given program"
          (ok))))))
