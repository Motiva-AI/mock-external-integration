(ns mock-external-integration.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]

            [schema.core :as schema]

            [mock-external-integration.schema :as ms]
            [mock-external-integration.gateway :as gw]))

(defn handle-get-campaign
  ([] (ok))

  ([campaign-id] (ok)))

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

    (context "/campaigns" []
      :tags ["campaigns"]

      (GET "/" []
        :return [ms/Campaign]
        :summary "fetch a list of Motiva campaigns"
        (handle-get-campaign))

      (GET "/:campaign-id" []
        :path-params [campaign-id :- schema/Int]
        :return ms/Campaign
        :summary "fetch a list of Motiva campaigns"
        (handle-get-campaign campaign-id))

      (POST "/" []
        :summary "create a new campaign"
        :return schema/Int
        :body   [campaign ms/Campaign]
        (ok)))

    (context "/experiment" []
      :tags ["experiment"]

      (GET "/:experiment-id" []
        :path-params [experiment-id :- schema/Uuid]
        :summary "fetch a particular experiment meta information"
        :return ms/Experiment
        (ok))

      (DELETE "/:experiment-id" []
        :path-params [experiment-id :- schema/Uuid]
        :summary "delete an experiment"
        (no-content))

      (POST "/" []
        :summary "create a new experiment to send out messages"
        :return ms/ExperimentReponse
        :body   [experiment ms/ExperimentRequest]
        (ok)))

    (context "/export" []

      (context "/segment" []
        :tags ["export/contacts"]

        (GET "/:segment-id" []
          :path-params [segment-id :- schema/Int]
          :summary "get the export status for this segment export job"
          (ok))

        (DELETE "/:segment-id" []
          :path-params [segment-id :- schema/Int]
          :summary "delete this segment export job"
          (no-content))

        (POST "/:segment-id" []
          :path-params [segment-id :- schema/Int]
          :summary "create a request to export contacts from a segment"
          (ok)))

      (context "/activities" []
        :tags ["export/activities"]

        (GET "/:program-id" []
          :path-params [program-id :- schema/Uuid]
          :summary "fetch a list of activities export jobs for a given program"
          (ok))

        (DELETE "/:program-id" []
          :path-params [program-id :- schema/Uuid]
          :summary "delete all activities export jobs for a given program"
          (no-content))

        (POST "/:program-id" []
          :summary "Create a request to export activities for a given program"
          (ok))))))
