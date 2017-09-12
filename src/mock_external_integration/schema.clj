(ns mock-external-integration.schema
  (:require [schema.core :as s]))

(s/defschema Campaign
  {:id            s/Int
   :currentStatus s/Keyword
   :updatedAt     s/Inst
   :updatedBy     s/Int
   :createdAt     s/Inst
   :createdBy     s/Int
   :startAt       s/Inst
   :endAt         s/Inst
   :name          s/Str
   :emailTemplateIds [s/Int]
   :segmentId        s/Int})


(s/defschema ExperimentRequest
  ;; experiments are {treatmentId: [contactID, ...]}
  {:experiments      {s/Keyword [s/Int]}})

(s/defschema ExperimentReponse
  {s/Keyword s/Uuid})

(s/defschema Experiment
  {:id            s/Int
   :currentStatus s/Keyword
   :name          s/Str
   :memberCount   s/Int
   :updatedAt     s/Inst
   :updatedBy     s/Int
   :createdAt     s/Inst
   :createdBy     s/Int
   :startAt       s/Inst
   :endAt         s/Inst})
