(ns mock-external-integration.schema
  (:require [schema.core :as s]))

(s/defschema Email
  "Meta data for an email"
  {:id        s/Int
   :name      s/Str
   :subject   s/Str
   (s/optional-key :senderName)  s/Str
   (s/optional-key :senderEmail) s/Str
   :createdBy (s/maybe s/Int)
   :createdAt s/Inst
   :updatedBy (s/maybe s/Int)
   :updatedAt s/Inst})

(s/defschema Segment
  {:id            s/Int
   :currentStatus s/Keyword
   :createdAt     s/Inst
   :updatedAt     s/Inst
   :createdBy     s/Int
   :updatedBy     s/Int
   :name          s/Str
   :numberOfContacts s/Int})

